package com.test.frmw.saral.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "keywords")
public class KeywordDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "implementing_class")
    private String implementingClass;

    @OneToMany(mappedBy = "keyword",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)

    List<ParameterDetails> parameterDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImplementingClass() {
        return implementingClass;
    }

    public void setImplementingClass(String implementingClass) {
        this.implementingClass = implementingClass;
    }

    public void addParameterDetails(ParameterDetails param) {
        if (this.parameterDetails == null)
            this.parameterDetails = new ArrayList<>();
        this.parameterDetails.add(param);
    }

    public List<ParameterDetails> getParameterDetails() {
        return parameterDetails;
    }

    public void setParameterDetails(List<ParameterDetails> parameterDetails) {
        this.parameterDetails = parameterDetails;
    }

    @Override
    public int hashCode() {
        return Math.toIntExact(this.id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        return (id.equals(((KeywordDetails) obj).getId()));
    }

    @Override
    public String toString() {
        return "KeywordDetails{" +
                "name='" + name + '\'' +
                ", implementingClass='" + implementingClass + '\'' +
                '}';
    }
}
