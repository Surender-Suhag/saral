package com.test.frmw.saral.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.test.frmw.saral.dao.TestComponentUniqueIdGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="components")
public class ComponentDetails {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "component_sequence")
    @GenericGenerator(name = "component_sequence",
            strategy = "com.test.frmw.saral.dao.TestComponentUniqueIdGenerator",
            parameters = {
            @org.hibernate.annotations.Parameter(name= TestComponentUniqueIdGenerator.INCREMENT_PARAM,value="1"),
                    @org.hibernate.annotations.Parameter(name= TestComponentUniqueIdGenerator.VALUE_PREFIX_PARAM,value="CO_")
            })
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "node")
    @JsonBackReference
    private ComponentNodeDetails parentComponentNodeDetails;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ComponentNodeDetails getParentComponentNodeDetails() {
        return parentComponentNodeDetails;
    }

    public void setParentComponentNodeDetails(ComponentNodeDetails parentComponentNodeDetails) {
        this.parentComponentNodeDetails = parentComponentNodeDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComponentDetails that = (ComponentDetails) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ComponentDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
