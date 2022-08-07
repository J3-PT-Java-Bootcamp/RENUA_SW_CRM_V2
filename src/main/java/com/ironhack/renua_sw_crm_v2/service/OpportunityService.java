package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.enums.Product;
import com.ironhack.enums.Status;
import com.ironhack.model.*;
import com.ironhack.serialize.SerializeService;
import com.ironhack.userinput.UserInput;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OpportunityService {

    private static final Map<UUID, Opportunity> opportunities = new HashMap<>();

    static {
        var objects = SerializeService.getAll();
        objects.forEach((id, object) -> {
            if(object instanceof Opportunity) {
                var opportunity = (Opportunity) object;
                opportunities.put(opportunity.getId(), opportunity);
            }
        });
    }

    public static Opportunity createOpportunity(Lead lead) {
        System.out.print("\nWrite product number:\n");

        System.out.println("1: HYBRID");
        System.out.println("2: FLATED");
        System.out.println("3: BOX");

        Product product = new Product[] {Product.HYBRID, Product.FLATBED, Product.BOX}[UserInput.getIntBetween(1,3) - 1];

        System.out.print("\nNumber of trucks (Between 0 and 9999):\n");
        int trucksNum = UserInput.getIntBetween(0, 9999);

        var contact = new Contact(lead);
        ContactService.put(contact);

        System.out.print("Contact created: " + contact.getId() + "\n");

        var opportunity = new Opportunity(product, trucksNum, contact.getId(), Status.OPEN);
        put(opportunity);

        System.out.print("Opportunity created: " + opportunity.getId() + "\n");

        return opportunity;
    }

    public static void  updateStatus(UUID id, Status status) {
        var opportunity = getById(id);

        if(opportunity.getStatus() == Status.OPEN) {
            opportunity.setStatus(status);
            put(opportunity);
            System.out.println("Status updated to " + status);
        } else {
            System.out.println("\nOpportunity is already closed\n");
        }
    }

    public static void show() {
        opportunities.forEach((id, opportunity) -> {
            System.out.println(opportunity.toString());
        });
    }

    public static void show(UUID id) {
        final var opportunity = getById(id);
        System.out.println(opportunity.toString());
    }

    public static Opportunity getById(UUID id) {
        return opportunities.get(id);
    }

    public static void put(Opportunity opportunity) {
        opportunities.put(opportunity.getId(), opportunity);
        SerializeService.put(opportunity);
    }
}