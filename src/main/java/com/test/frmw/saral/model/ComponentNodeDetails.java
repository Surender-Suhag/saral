package com.test.frmw.saral.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.test.frmw.saral.dao.TestComponentUniqueIdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="component_nodes")
public class ComponentNodeDetails implements EntityWithName {

    @Id
    @GenericGenerator(name = "node_sequence",
            strategy = "com.test.frmw.saral.dao.TestComponentUniqueIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name= TestComponentUniqueIdGenerator.INCREMENT_PARAM,value="1"),
                    @org.hibernate.annotations.Parameter(name= TestComponentUniqueIdGenerator.VALUE_PREFIX_PARAM,value="NC_")
            })
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "node_sequence")
    @Column(nullable = false,updatable = false,name = "Id")
    private String id;

    @Column(name="name")
    private String name;

    @JsonProperty("childFolders")
    @OneToMany(mappedBy = "parentNode",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<ComponentNodeDetails> childNodes;

    @ManyToOne
    @JoinColumn(name="parent_id")
    @JsonBackReference
    private ComponentNodeDetails parentNode;

    @JsonProperty("childFiles")
    @OneToMany(mappedBy = "parentComponentNodeDetails",cascade = CascadeType.ALL)
    private List<ComponentDetails> childComponentsDetails;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ComponentNodeDetails> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(List<ComponentNodeDetails> childNodes) {
        this.childNodes = childNodes;
    }

    public ComponentNodeDetails getParentNode() {
        return parentNode;
    }

    public void addChildComponentNodeDetails(ComponentNodeDetails childNode){
        if(this.childNodes == null)
            this.childNodes = new ArrayList<>();

        this.childNodes.add(childNode);
    }
    public void setParentNode(ComponentNodeDetails parentNode) {
        this.parentNode = parentNode;
    }

    public List<ComponentDetails> getChildComponentsDetails() {
        return childComponentsDetails;
    }

    public void setChildComponentsDetails(List<ComponentDetails> childComponentsDetails) {
        this.childComponentsDetails = childComponentsDetails;
    }

    public void addChildComponentDetails(ComponentDetails childComponent){
        if(this.childComponentsDetails == null)
            this.childComponentsDetails = new ArrayList<>();
        this.childComponentsDetails.add(childComponent);
    }

    @Override
    public String toString() {
        return "ComponentNodeDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", childNodes=" + childNodes +
//                ", childComponentsDetails=" + childComponentsDetails +
                '}';
    }
}
