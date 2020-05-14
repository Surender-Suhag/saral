package com.test.frmw.saral.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.test.frmw.saral.dao.DbComponentNodesDao;
import com.test.frmw.saral.dao.DbComponentsDao;
import com.test.frmw.saral.exceptions.EntityAlreadyExistsException;
import com.test.frmw.saral.exceptions.IncorrectParameterValueException;
import com.test.frmw.saral.exceptions.MissingParameterException;
import com.test.frmw.saral.model.ComponentDetails;
import com.test.frmw.saral.model.ComponentNodeDetails;
import com.test.frmw.saral.util.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComponentDetailsServices {
    @Autowired
    private DbComponentsDao componentsDao;

    @Autowired
    private DbComponentNodesDao componentNodesDao;

    public ComponentDetails createNewComponentNode(String requestDetails) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.readValue(requestDetails, ObjectNode.class);
        ComponentDetails componentDetails = objectMapper.convertValue(objectNode, ComponentDetails.class);
        System.out.println("creating component details object");
        if(componentDetails.getName() == null || componentDetails.getName().trim().isEmpty()){
            throw new IncorrectParameterValueException("Component name can not be blank");
        }

        if(componentDetails.getParentComponentNodeDetails()==null)
            throw new MissingParameterException("Parent id is required to create new Component");

        Optional<ComponentNodeDetails> optionalParentNode = componentNodesDao.findById(
                componentDetails.getParentComponentNodeDetails().getId());

        if (!optionalParentNode.isPresent())
            throw new IncorrectParameterValueException(
                    String.format("Parent_id {%s} does not exist", componentDetails.getParentComponentNodeDetails().getId()));

        ComponentNodeDetails parentNode = optionalParentNode.get();


        if(CollectionUtil.ifNamedEntityAlreadyExists(parentNode.getChildComponentsDetails(),componentDetails))
            throw new EntityAlreadyExistsException(
                    String.format("Entity with name {%s} already exists for parent with ID {%s}",
                            componentDetails.getName(),componentDetails.getParentComponentNodeDetails().getId()));

        componentDetails.setParentComponentNodeDetails(parentNode);
        componentsDao.save(componentDetails);
        parentNode.addChildComponentDetails(componentDetails);
        return componentDetails;
    }
}
