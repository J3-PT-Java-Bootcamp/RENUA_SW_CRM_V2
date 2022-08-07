package com.ironhack.renua_sw_crm_v2.model;

import com.ironhack.enums.Product;
import com.ironhack.enums.Status;
import com.ironhack.serialize.Serialize;

import java.util.UUID;

public class Opportunity extends Serialize {

    private Product product;
    private int quantity;
    private UUID decisionMaker;
    private Status status;

    static {
        serialVersionUID = 2L; // No modify
    }

    public Opportunity(Product product, int quantity, UUID decisionMaker, Status status) {
        setProduct(product);
        setQuantity(quantity);
        setDecisionMaker(decisionMaker);
        setStatus(status);
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public UUID getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(UUID decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Opportunity{" +  "\n" +
                "  id=" + id +  "\n" +
                "  product=" + product +  "\n" +
                "  quantity=" + quantity +  "\n" +
                "  decisionMaker=" + decisionMaker +  "\n" +
                "  status=" + status +  "\n" +
                "  }";
    }
}
