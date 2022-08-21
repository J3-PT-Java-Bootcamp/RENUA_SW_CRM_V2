package com.ironhack.renua_sw_crm_v2.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.renua_sw_crm_v2.enums.IndustryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private IndustryType industry;
    @Column(name = "employee_count")
    private int employeeCount;
    private String city;
    private String country;
    private String companyName;
    @OneToMany(
            mappedBy = "contactAccount",
            fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE
    )
    private Set<Contact> contactList;

    @OneToMany(
            mappedBy = "opportunityAccount",
            fetch = FetchType.EAGER,
            cascade = CascadeType.MERGE
    )
    private Set<Opportunity> opportunityList;

    public Account() {
        setContactList(new HashSet<>());
        setOpportunityList(new HashSet<>());
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
        var counter = 1;
        for (Contact contact : contactList) {
            sb.append(contact.getId());
            if(counter != contactList.size()) sb.append(", ");
            counter++;
        }
        sb.append("]");
        return sb.toString();
    }

    private String opportunityListToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        var counter = 1;
        for (Opportunity opportunity : opportunityList) {
            sb.append(opportunity.getId());
            if(counter != opportunityList.size()) sb.append(", ");
            counter++;
        }
        sb.append("]");
        return sb.toString();
    }
}
