package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.model.Lead;
import com.ironhack.renua_sw_crm_v2.model.SalesRep;
import com.ironhack.renua_sw_crm_v2.userinput.UserInput;

import java.util.HashMap;
import java.util.Map;

public class LeadService {
    private static Map<Long, Lead> leads = new HashMap<>();

//    static {
//        var objects = SerializeService.getAll();
//        objects.forEach((id, object) -> {
//            if(object instanceof Lead) {
//                var lead = (Lead) object;
//                leads.put(lead.getId(), lead);
//            }
//        });
//    }

    public static Lead createLead() {
        System.out.print("\nLead name: ");
        final String name = UserInput.readText();

        System.out.print("\nLead phone number: ");
        final String leadPn = UserInput.readText();

        System.out.print("\nLead email");
        final String leadEmail = UserInput.readText();

        System.out.print("\nCompany name");
        final String companyName = UserInput.readText();

        // TODO: Ask for a Sales Rep
        var salesRep = new SalesRep("John");

        final var lead = new Lead(name, leadPn, leadEmail, companyName, salesRep);
        put(lead);

        System.out.print("\nLead created: " + lead.getId());

        return lead;
    }

    public static void convertLeadToOpportunity(Long id) {
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

    public static void show(Long id) {
        final var lead = getById(id);
        System.out.println(lead.toString("Lead"));
    }

    public static <T> void delete(T lead) {
        leads.remove(((Lead) lead).getId());
    }

    public static Lead getById(Long id) {
        return leads.get(id);
    }

    public static void put(Lead lead) {
        leads.put(lead.getId(), lead);
    }
}