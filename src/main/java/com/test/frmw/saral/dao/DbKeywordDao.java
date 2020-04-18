package com.test.frmw.saral.dao;

import com.test.frmw.saral.model.KeywordDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbKeywordDao extends JpaRepository<KeywordDetails,Long> {
}
