package com.test.frmw.saral.controllers;

import com.test.frmw.saral.services.ComponentNodesServices;
import com.test.frmw.saral.model.ComponentNodeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ComponentNodesController {
    @Autowired
    private ComponentNodesServices componentNodesServices;

    @RequestMapping("/component-nodes")
    public ComponentNodeDetails getRootComponentNode() { return this.componentNodesServices.findRootComponentNode();}
//    public List<ComponentNodeDetails> getComponentNodes() {
//        return componentNodesServices.getAllComponentNodes();
//    }
}
