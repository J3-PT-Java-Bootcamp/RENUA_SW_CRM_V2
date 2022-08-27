package com.ironhack.renua_sw_crm_v2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    protected String name;
    @Column(name = "phone_number")
    protected String phoneNumber;
    protected String email;
    @Column(name = "company_name")
    protected String companyName;

    public User(String name, String phoneNumber, String email, String companyName) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
    }

    public String toString(String className, String extraAppend) {
        return className+"{" +  "\n" +
                "  id=" + id +  "\n" +
                "  name='" + name + '\'' +  "\n" +
                "  phoneNumber='" + phoneNumber + '\'' +  "\n" +
                "  email='" + email + '\'' +  "\n" +
                "  companyName='" + companyName + '\'' +  "\n" +
                "  " + extraAppend +
                "}";
    }
}
