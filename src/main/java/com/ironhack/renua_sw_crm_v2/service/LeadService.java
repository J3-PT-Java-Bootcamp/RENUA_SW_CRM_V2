package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.Repository.LeadRepository;
import com.ironhack.renua_sw_crm_v2.model.Lead;
import com.ironhack.renua_sw_crm_v2.model.SalesRep;
import com.ironhack.renua_sw_crm_v2.userinput.UserInput;
import org.springframework.beans.factory.annotation.Autowired;

public class LeadService {

    @Autowired
    AccountService accountService;

    @Autowired
    OpportunityService opportunityService;

    @Autowired
    LeadRepository leadRepository;

    public Lead createLead() {
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

    public void convertLeadToOpportunity(Long id) {
        final var lead = getById(id);
        delete(lead);
        var opportunity = opportunityService.createOpportunity(lead);
        System.out.print("\nNow create the account for the opportunity: " + opportunity.getId() + "\n");
        accountService.createAccount(opportunity);
    }

    public void show() {
        leadRepository.findAll().forEach((lead) -> {
            System.out.println(lead.toString());
        });
    }

    public void show(Long id) {
        final var lead = getById(id);
        System.out.println(lead.toString("Lead"));
    }

    public void delete(Lead lead) {
        leadRepository.delete(lead);
    }

    public Lead getById(Long id) {
        return leadRepository.findById(id).get();
    }

    public void put(Lead lead) {
        leadRepository.save(lead);
    }
}