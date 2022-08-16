package com.renua_sw.crm_v2.renua_sw_crm_v2.service;

import com.renua_sw.crm_v2.renua_sw_crm_v2.error.ErrorHelper;
import com.renua_sw.crm_v2.renua_sw_crm_v2.error.NotFoundException;
import com.renua_sw.crm_v2.renua_sw_crm_v2.model.Lead;
import com.renua_sw.crm_v2.renua_sw_crm_v2.model.SalesRep;
import com.renua_sw.crm_v2.renua_sw_crm_v2.repository.LeadRepository;
import com.renua_sw.crm_v2.renua_sw_crm_v2.userinput.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private SalesRepService salesRepService;

    public void show() {
        for(final var lead: leadRepository.findAll()) System.out.println(lead.toString());
    }

    public void showById(int id) {
        final var row = leadRepository.findById(id);
        if(row.isEmpty()) ErrorHelper.notFound();
        else System.out.println(row.get().toString());
    }

    public Lead findById(int id) throws NotFoundException {
        final var lead = leadRepository.findById(id);
        if(lead.isEmpty()) throw new NotFoundException();

        return lead.get();
    }

    public Lead findAndDeleteById(int id) throws NotFoundException {
        final var lead = findById(id);

        leadRepository.delete(lead);

        return lead;
    }

    public Lead createLead() throws NotFoundException {

        System.out.println("\nSalesRep ID:");
        final var salesRepId = UserInput.getIntBetween(0, 999999);
        final var salesRep = salesRepService.findById(salesRepId);

        System.out.print("\nLead name: ");
        final String name = UserInput.readText();

        System.out.print("\nLead phone number: ");
        final String leadPn = UserInput.readText();

        System.out.print("\nLead email");
        final String leadEmail = UserInput.readText();

        System.out.print("\nCompany name");
        final String companyName = UserInput.readText();

        final var lead = new Lead(salesRep, name, leadPn, leadEmail, companyName);

        leadRepository.save(lead);
        System.out.print("\nLead created: " + lead.getId());

        return lead;
    }
}
