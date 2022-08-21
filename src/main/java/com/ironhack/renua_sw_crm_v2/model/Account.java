package com.ironhack.renua_sw_crm_v2.model;


import com.ironhack.renua_sw_crm_v2.enums.IndustryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    @Column(name = "contact_list")
    private Set<Contact> contactList;

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    @Column(name = "opportunity_list")
    private Set<Opportunity> opportunityList;

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
