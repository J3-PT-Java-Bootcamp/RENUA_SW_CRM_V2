package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.Repository.LeadRepository;
import com.ironhack.renua_sw_crm_v2.error.ErrorHelper;
import com.ironhack.renua_sw_crm_v2.error.NotFoundException;
import com.ironhack.renua_sw_crm_v2.model.Lead;
import com.ironhack.renua_sw_crm_v2.model.SalesRep;
import com.ironhack.renua_sw_crm_v2.userinput.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LeadServiceImpl implements LeadService {

    @Autowired
    LeadRepository leadRepository;

    @Autowired
    @Qualifier("sql")
    SalesRepService salesRepService;

    @Override
    public Lead createLead() throws NotFoundException {
        System.out.print("\nLead name:\n");
        final String name = UserInput.readText();

        System.out.print("\nLead phone number:\n");
        final String leadPn = UserInput.readText();

        System.out.print("\nLead email:\n");
        final String leadEmail = UserInput.readText();

        System.out.print("\nCompany name:\n");
        final String companyName = UserInput.readText();

        System.out.println("\nSalesRep ID:\n");
        final Long salesRepId = Long.parseLong(UserInput.readText());
        final SalesRep salesRep = salesRepService.getById(salesRepId);

        final var lead = new Lead(name, leadPn, leadEmail, companyName, salesRep);

        leadRepository.save(lead);
        System.out.print("\nLead created: " + lead.getId());

        return lead;
    }

    @Override
    public void show() {
        leadRepository.findAll().forEach((Lead lead) -> {
            System.out.println(lead.toString("Lead", "SalesRep: " + lead.getSalesRep().getId() + "\n"));
        });
    }

    @Override
    public void show(Long id) {
        final var row = leadRepository.findById(id);
        if(row.isEmpty()) ErrorHelper.notFound();
        else System.out.println(row.get().toString("Lead", "SalesRep: " + row.get().getSalesRep().getId() + "\n"));
    }

    @Override
    public void delete(Lead lead) throws NotFoundException {
        final var leadFound = getById(lead.getId());
        leadRepository.delete(leadFound);
    }

    @Override
    public Lead getById(Long id) throws NotFoundException {
        final var lead = leadRepository.findById(id).orElseThrow(() -> new NotFoundException());
        return lead;
    }
}