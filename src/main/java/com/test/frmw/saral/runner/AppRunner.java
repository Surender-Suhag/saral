package com.test.frmw.saral.runner;

import com.test.frmw.saral.dao.DbComponentNodesDao;
import com.test.frmw.saral.dao.DbComponentsDao;
import com.test.frmw.saral.model.ComponentDetails;
import com.test.frmw.saral.model.ComponentNodeDetails;
import com.test.frmw.saral.services.ComponentNodesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {
    @Autowired
    private DbComponentNodesDao componentNodesDao;
    @Autowired
    private DbComponentsDao componentsDao;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("from run method of AppRunner");

//        ComponentNodeDetails root = new ComponentNodeDetails();
//        root.setName("electronics");
//
//        ComponentNodeDetails parent = componentNodesDao.findById("NC_00048").get();
//        parent.addChildComponentNodeDetails(root);
//        root.setParentNode(parent);
//        componentNodesDao.save(parent);
    }
}
