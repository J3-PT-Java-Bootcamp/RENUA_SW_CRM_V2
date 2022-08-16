package com.renua_sw.crm_v2.renua_sw_crm_v2.model;

import com.renua_sw.crm_v2.renua_sw_crm_v2.enums.IndustryType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Enumerated(EnumType.STRING)
    @Column
    IndustryType industry;

    @Column(name = "employee_count")
    int employeeCount;

    @Column
    String city;

    @Column
    String country;

    @OneToMany
    @Column(name = "contact_list")
    List<Contact> contactList;

    @OneToMany
    @Column(name = "opportunity_list")
    List<Opportunity> opportunityList;
}