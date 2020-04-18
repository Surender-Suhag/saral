package com.test.frmw.saral.kw.registry;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.test.frmw.saral.exceptions.KeywordNotFoundException;
import com.test.frmw.saral.model.KeywordDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Component

public class DatabaseKeywordRegistry {

    private static Logger logger = LoggerFactory.getLogger(DatabaseKeywordRegistry.class);

    @Autowired
    private com.test.frmw.saral.dao.DbKeywordDao dbKeywordDao;

    private List<KeywordDetails> dbKeywords;

    //Hash maps keyword name to keyword Detail class.
    private ListMultimap<String, KeywordDetails> keywordMap;

    @PostConstruct
    private void init() {
        this.dbKeywords = Lists.newArrayList(dbKeywordDao.findAll());
    }

    public List<KeywordDetails> getDbKeywords() {
        return dbKeywords;
    }

    public KeywordDetails getDetailsByKeywordNameAndImplementingClassName(String keywordName, String implementingClass) throws KeywordNotFoundException {

        if (keywordMap == null)
            this.createKeywordMap();

        List<KeywordDetails> matchingKws = keywordMap.get(keywordName);

        Optional<KeywordDetails> kwDetail = matchingKws.stream().
                filter(kw -> kw.getImplementingClass().equals(implementingClass)).
                findFirst();
        if (!kwDetail.isPresent())
            throw new KeywordNotFoundException(
                    String.format("Keyword with name {%s} and classname {%s} does not exists", keywordName, implementingClass));

        return kwDetail.get();
    }

    private void createKeywordMap() {
        keywordMap = ArrayListMultimap.create();
        dbKeywords.forEach(kw -> keywordMap.put(kw.getName(), kw));
    }

    public KeywordDetails addKeywordToDb(KeywordDetails kw) {

        return dbKeywordDao.save(kw);
//        dbKeywords.add(keyword);
//        return keyword.getId();
    }

    public KeywordDetails getKeywordById(long id) throws KeywordNotFoundException {
        Optional<KeywordDetails> kw = dbKeywordDao.findById(id);
        if (!kw.isPresent()) {
            throw new KeywordNotFoundException(String.format("Keyword with id {%d} does not exists"));
        }

        return kw.get();
    }

}
