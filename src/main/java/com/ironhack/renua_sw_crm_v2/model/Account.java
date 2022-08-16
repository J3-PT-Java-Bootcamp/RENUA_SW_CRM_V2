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
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    List<Contact> contactList;
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
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
                " contactList=" + contactListToString() + "\n" +
                " opportunityList=" + opportunityListToString() + "\n" +
                "}";
    }

    private String contactListToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Contact contact : contactList) {
            sb.append(contact.getId()).append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    private String opportunityListToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Opportunity opportunity : opportunityList) {
            sb.append(opportunity.getId()).append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
