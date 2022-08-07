package com.ironhack.renua_sw_crm_v2.model;

public class Lead extends User {

    static {
        serialVersionUID = 3L; // No modify
    }

    public Lead(String name, String phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email, companyName);
    }
}
