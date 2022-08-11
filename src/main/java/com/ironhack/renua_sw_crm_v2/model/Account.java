package com.ironhack.renua_sw_crm_v2.model;


import com.ironhack.renua_sw_crm_v2.enums.Industry;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;
    private String companyName;
    @OneToMany(mappedBy = "account")
    List<Contact> contactList;
    @OneToMany(mappedBy = "account")
    List<Opportunity> opportunityList;

    public Account(Industry industry, int employeeCount, String city, String country, String companyName, List<Contact> contactList, List<Opportunity> opportunityList) {
        setIndustry(industry);
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
        setCompanyName(companyName);
        setContactList(contactList);
        setOpportunityList(opportunityList);
    }

    @Override
    public String toString() {
        return "Account{" + "\n" +
                " id=" + id + "\n" +
                " industry=" + industry + "\n" +
                " employeeCount=" + employeeCount + "\n" +
                " city='" + city + '\'' + "\n" +
                " country='" + country + '\'' + "\n" +
                " companyName='" + companyName + '\'' + "\n" +
                " contactList=" + contactList + "\n" +
                " opportunityList=" + opportunityList + "\n" +
                "}";
    }
}
