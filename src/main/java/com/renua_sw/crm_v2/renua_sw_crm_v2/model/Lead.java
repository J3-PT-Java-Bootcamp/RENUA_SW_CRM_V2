package com.renua_sw.crm_v2.renua_sw_crm_v2.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Table(name = "leads")
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    @NotNull
    String name;

    @Column
    String companyName;

    @Column
    String email;

    @Column
    String phoneNumber;

    public Lead(String name, String leadPn, String leadEmail, String companyName) {
        setName(name);
        setPhoneNumber(leadPn);
        setEmail(leadEmail);
        setCompanyName(companyName);
    }
}