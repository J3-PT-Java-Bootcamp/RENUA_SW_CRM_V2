package com.ironhack.renua_sw_crm_v2.model;

import com.ironhack.renua_sw_crm_v2.serialize.Serialize;

public abstract class User extends Serialize {

    protected String name;
    protected String phoneNumber;
    protected String email;
    protected String companyName;

    static {
        serialVersionUID = 1L; // No modify
    }

    public User(String name, String phoneNumber, String email, String companyName) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String toString(String className) {
        return className+"{" +  "\n" +
                "  id=" + id +  "\n" +
                "  name='" + name + '\'' +  "\n" +
                "  phoneNumber='" + phoneNumber + '\'' +  "\n" +
                "  email='" + email + '\'' +  "\n" +
                "  companyName='" + companyName + '\'' +  "\n" +
                "}";
    }
}
