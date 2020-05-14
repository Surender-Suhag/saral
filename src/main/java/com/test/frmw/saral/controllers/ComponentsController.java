package com.test.frmw.saral.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.frmw.saral.model.ComponentDetails;
import com.test.frmw.saral.services.ComponentDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ComponentsController {

    @Autowired
    private ComponentDetailsServices componentDetailsServices;

    @RequestMapping(value = "/components",method = RequestMethod.POST)
    public ComponentDetails addNewComponent(@RequestBody String request) throws JsonProcessingException {
        System.out.println("request is -- "+ request);
        //todo add component details
        return  componentDetailsServices.createNewComponentNode(request);
    }
}
