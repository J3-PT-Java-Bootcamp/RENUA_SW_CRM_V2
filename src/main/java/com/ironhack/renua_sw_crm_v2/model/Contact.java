package com.ironhack.renua_sw_crm_v2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "contacts")
public class Contact extends User {

    @ManyToOne
    @JoinColumn(name = "contact_account_id")
    @JsonIgnore
    private Account contactAccount;

    @OneToOne(mappedBy = "decisionMaker", cascade = CascadeType.MERGE)
    @JsonIgnore
    private Opportunity opportunity;

    public Contact(Lead lead) {
        super(lead.name, lead.phoneNumber, lead.email, lead.companyName);
    }

    public Contact(String name, String phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email, companyName);
    }
}
