package com.ironhack.renua_sw_crm_v2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.renua_sw_crm_v2.enums.Product;
import com.ironhack.renua_sw_crm_v2.enums.Status;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Opportunity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private Product product;
    private int quantity;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "contact_id")
    private Contact decisionMaker;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne()
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private Account account;

    @ManyToOne()
    @JoinColumn(name = "sales_rep_id", nullable = false)
    private SalesRep salesRep;

    public Opportunity(Product product, int quantity, Contact decisionMaker, Status status, SalesRep salesRep) {
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
