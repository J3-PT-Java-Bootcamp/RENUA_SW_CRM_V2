package com.ironhack.renua_sw_crm_v2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    protected String name;
    protected String phoneNumber;
    protected String email;
    protected String companyName;

    public User(String name, String phoneNumber, String email, String companyName) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
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
