package com.ironhack.renua_sw_crm_v2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Lead extends User {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sales_rep_id")
    private SalesRep salesRep;

    public Lead(String name, String phoneNumber, String email, String companyName, SalesRep salesRep) {
        super(name, phoneNumber, email, companyName);
        setSalesRep(salesRep);
    }
}
