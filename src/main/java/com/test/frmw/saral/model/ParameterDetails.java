package com.test.frmw.saral.model;

import javax.persistence.*;

@Entity
@Table(name = "parameters")
public class ParameterDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "keyword_id")
    private KeywordDetails keyword;

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

    public KeywordDetails getKeyword() {
        return keyword;
    }

    public void setKeyword(KeywordDetails keyword) {
        this.keyword = keyword;
    }

    @Override
    public int hashCode() {
        return Math.toIntExact(this.id);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || getClass()!= obj.getClass())
            return false;

        ParameterDetails pd =(ParameterDetails)obj;
        return this.getId().equals(pd.id);
    }

    @Override
    public String toString() {
        return "ParameterDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", keyword=" + keyword +
                '}';
    }
}
