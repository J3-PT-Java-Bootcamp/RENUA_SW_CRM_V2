package com.ironhack.renua_sw_crm_v2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "sales_reps")
public class SalesRep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToMany(mappedBy = "salesRep", cascade = CascadeType.MERGE)
    @JsonIgnore
    private Set<Lead> leadList;

    @OneToMany(mappedBy = "salesRep", cascade = CascadeType.MERGE)
    @JsonIgnore
    private Set<Opportunity> opportunityList;

    public SalesRep(String name) {
        setName(name);
    }

    @Override
    public String toString() {
        return "SalesRep{" + "\n" +
                " id=" + id + "\n" +
                " name=" + name + "\n" +
                "}";
    }
}
