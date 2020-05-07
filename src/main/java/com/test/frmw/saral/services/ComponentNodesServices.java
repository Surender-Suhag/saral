package com.test.frmw.saral.services;

import com.test.frmw.saral.dao.DbComponentNodesDao;
import com.test.frmw.saral.model.ComponentNodeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentNodesServices {

    @Autowired
    private DbComponentNodesDao componentNodesDao;

    public List<ComponentNodeDetails> getAllComponentNodes(){
        return componentNodesDao.findAll();
    }
    public ComponentNodeDetails findRootComponentNode(){return componentNodesDao.findRootElement();}
}
