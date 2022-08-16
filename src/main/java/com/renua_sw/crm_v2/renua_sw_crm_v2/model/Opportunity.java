package com.renua_sw.crm_v2.renua_sw_crm_v2.model;

import com.renua_sw.crm_v2.renua_sw_crm_v2.enums.OpportunityStatus;
import com.renua_sw.crm_v2.renua_sw_crm_v2.enums.ProductType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "opportunities")
public class Opportunity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    @Enumerated(EnumType.STRING)
    ProductType product;

    @Column
    int quantity;

    @ManyToOne
    Contact decisionMaker;

    @Column
    @Enumerated(EnumType.STRING)
    OpportunityStatus status;
}