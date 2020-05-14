package com.test.frmw.saral.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.test.frmw.saral.dao.DbComponentNodesDao;
import com.test.frmw.saral.exceptions.EntityAlreadyExistsException;
import com.test.frmw.saral.exceptions.IncorrectParameterValueException;
import com.test.frmw.saral.exceptions.MissingParameterException;
import com.test.frmw.saral.model.ComponentNodeDetails;
import com.test.frmw.saral.util.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComponentNodesServices {

    @Autowired
    private DbComponentNodesDao componentNodesDao;

    public List<ComponentNodeDetails> getAllComponentNodes() {
        return componentNodesDao.findAll();
    }

    public ComponentNodeDetails findRootComponentNode() {
        return componentNodesDao.findRootElement();
    }

    public ComponentNodeDetails createNewComponentNode(String nodeData) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.readValue(nodeData, ObjectNode.class);
        ComponentNodeDetails nodeDetails = objectMapper.convertValue(objectNode, ComponentNodeDetails.class);

        if(nodeDetails.getName() == null || nodeDetails.getName().trim().isEmpty()){
            throw new IncorrectParameterValueException("Node name can not be blank");
        }

        if (nodeDetails.getParentNode() == null)
            throw new MissingParameterException("Parent id is required to create new Node");

        Optional<ComponentNodeDetails> optionalParentNode = componentNodesDao.findById(nodeDetails.getParentNode().getId());
        if (!optionalParentNode.isPresent())
            throw new IncorrectParameterValueException(
                    String.format("Parent_id {%s} does not exist", nodeDetails.getParentNode().getId()));


        ComponentNodeDetails parentNode = optionalParentNode.get();
        System.out.println(parentNode.getChildNodes());
        System.out.println(nodeDetails);
       if(CollectionUtil.ifNamedEntityAlreadyExists(parentNode.getChildNodes(),nodeDetails))
           throw new EntityAlreadyExistsException(
                   String.format("Entity with name {%s} already exists for parent with ID {%s}",nodeDetails.getName(),parentNode.getId()));

        nodeDetails.setParentNode(optionalParentNode.get());

        nodeDetails = componentNodesDao.save(nodeDetails);
        parentNode.addChildComponentNodeDetails(nodeDetails);
        return nodeDetails;

    }
}
