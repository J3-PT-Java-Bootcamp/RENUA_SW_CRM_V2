package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.model.Lead;
import com.ironhack.serialize.SerializeService;
import com.ironhack.userinput.UserInput;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LeadService {
    private static Map<UUID, Lead> leads = new HashMap<>();

    static {
        var objects = SerializeService.getAll();
        objects.forEach((id, object) -> {
            if(object instanceof Lead) {
                var lead = (Lead) object;
                leads.put(lead.getId(), lead);
            }
        });
    }

    public static Lead createLead() {
        System.out.print("\nLead name: ");
        final String name = UserInput.readText();

        System.out.print("\nLead phone number: ");
        final String leadPn = UserInput.readText();

        System.out.print("\nLead email");
        final String leadEmail = UserInput.readText();

        System.out.print("\nCompany name");
        final String companyName = UserInput.readText();

        final var lead = new Lead(name, leadPn, leadEmail, companyName);
        put(lead);

        System.out.print("\nLead created: " + lead.getId());

        return lead;
    }

    public static void convertLeadToOpportunity(UUID id) {
        final var lead = getById(id);
        delete(lead);
        var opportunity = OpportunityService.createOpportunity(lead);
        System.out.print("\nNow create the account for the opportunity: " + opportunity.getId() + "\n");
        AccountService.createAccount(opportunity);
    }

    public static void show() {
        leads.forEach((id, lead) -> {
            System.out.println(lead.toString("Lead"));
        });
    }

    public static void show(UUID id) {
        final var lead = getById(id);
        System.out.println(lead.toString("Lead"));
    }

    public static <T> void delete(T lead) {
        leads.remove(((Lead) lead).getId());
        SerializeService.delete((Lead) lead);
    }

    public static Lead getById(UUID id) {
        return leads.get(id);
    }

    public static void put(Lead lead) {
        leads.put(lead.getId(), lead);
        SerializeService.put(lead);
    }
}