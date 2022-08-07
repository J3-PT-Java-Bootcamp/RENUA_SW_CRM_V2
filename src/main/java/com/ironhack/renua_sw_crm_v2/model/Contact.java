package com.ironhack.renua_sw_crm_v2.model;

public class Contact extends User {

    static {
        serialVersionUID = 4L; // No modify
    }

    public  Contact(Lead lead) {
        super(lead.name, lead.phoneNumber, lead.email, lead.companyName);
    }
}
