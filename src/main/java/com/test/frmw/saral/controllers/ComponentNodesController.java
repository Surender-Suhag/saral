package com.test.frmw.saral.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.test.frmw.saral.exceptions.EntityAlreadyExistsException;
import com.test.frmw.saral.services.ComponentNodesServices;
import com.test.frmw.saral.model.ComponentNodeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ComponentNodesController {
    @Autowired
    private ComponentNodesServices componentNodesServices;

    @RequestMapping(value = "/component-nodes",method = RequestMethod.GET)
    public ComponentNodeDetails getRootComponentNode() {
        return this.componentNodesServices.findRootComponentNode();
    }


    @RequestMapping(value = "/component-nodes", method = RequestMethod.POST)
    public ComponentNodeDetails addNewComponentNode(@RequestBody String nodeDetails) throws JsonProcessingException, EntityAlreadyExistsException {
        return componentNodesServices.createNewComponentNode(nodeDetails);

    }
}
