package com.ironhack.renua_sw_crm_v2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "lead_user")
public class Lead extends User {

    @ManyToOne()
    @JoinColumn(name = "sales_rep_id", nullable = false)
    private SalesRep salesRep;

    public Lead(String name, String phoneNumber, String email, String companyName, SalesRep salesRep) {
        super(name, phoneNumber, email, companyName);
        setSalesRep(salesRep);
    }
}
