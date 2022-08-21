package com.ironhack.renua_sw_crm_v2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.renua_sw_crm_v2.enums.ProductType;
import com.ironhack.renua_sw_crm_v2.enums.OpportunityStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "opportunities")
public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private ProductType product;
    private int quantity;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "decision_maker_id")
    private Contact decisionMaker;

    @Enumerated(EnumType.STRING)
    private OpportunityStatus status;

    @ManyToOne()
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private Account account;

    @ManyToOne()
    @JoinColumn(name = "sales_rep_id")
    private SalesRep salesRep;

    public Opportunity(ProductType product, int quantity, Contact decisionMaker, OpportunityStatus status, SalesRep salesRep) {
        setProduct(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setStatus(status);
        setSalesRep(salesRep);
    }

    @Override
    public String toString() {
        return "Opportunity{" +  "\n" +
                "  id=" + id +  "\n" +
                "  product=" + product +  "\n" +
                "  quantity=" + quantity +  "\n" +
                "  decisionMaker=" + decisionMaker.getId() +  "\n" +
                "  status=" + status +  "\n" +
                "  salesRep=" + salesRep.getId() +  "\n" +
                "}";
    }

}
