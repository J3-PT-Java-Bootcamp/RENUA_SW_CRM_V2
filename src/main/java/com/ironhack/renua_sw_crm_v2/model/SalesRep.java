package com.ironhack.renua_sw_crm_v2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "SalesRep")
public class SalesRep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(mappedBy = "salesRep")
    @JsonIgnore
    List<Lead> leadList;

    @OneToMany(mappedBy = "salesRep")
    @JsonIgnore
    List<Opportunity> opportunityList;

    public SalesRep(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SalesRep{" + "\n" +
                " id=" + id + "\n" +
                " name=" + name + "\n" +
                "}";
    }
}
