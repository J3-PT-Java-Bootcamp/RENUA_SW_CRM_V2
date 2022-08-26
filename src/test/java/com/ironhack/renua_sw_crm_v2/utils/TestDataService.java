package com.ironhack.renua_sw_crm_v2.utils;

import com.ironhack.renua_sw_crm_v2.Repository.*;
import com.ironhack.renua_sw_crm_v2.enums.IndustryType;
import com.ironhack.renua_sw_crm_v2.enums.OpportunityStatus;
import com.ironhack.renua_sw_crm_v2.enums.ProductType;
import com.ironhack.renua_sw_crm_v2.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestDataService {

    @Autowired
    SalesRepRepository salesRepRepository;

    @Autowired
    LeadRepository leadRepository;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    OpportunityRepository opportunityRepository;

    @Autowired
    AccountRepository accountRepository;

    public void generateData() {

        var salesRep = List.of(
                new SalesRep("Sergi"),
                new SalesRep("Ivan"),
                new SalesRep("Joel")
        );

        var salesRepSaved = salesRepRepository.saveAll(salesRep);

        var leads = List.of(
                new Lead("Salvatore", "615615615", "salvatore@mail.com", "McDonalds", salesRepSaved.get(0)),
                new Lead("Jorge", "654765476", "jorge@mail.com", "Decathlon", salesRepSaved.get(1)),
                new Lead("Lisa", "632632632", "lisa@mail.com", "Zara", salesRepSaved.get(0)),
                new Lead("Cristina", "698698698", "cristina@mail.com", "Coca-cola", salesRepSaved.get(1))
        );

        leadRepository.save(leads.get(1));
        leadRepository.save(leads.get(2));

        var contacts = List.of(
                new Contact(leads.get(0)),
                new Contact(leads.get(3))
        );

        var contactsSaved = contactRepository.saveAll(contacts);

        var opportunities = List.of(
                new Opportunity(ProductType.HYBRID, 5, contactsSaved.get(0), OpportunityStatus.OPEN, salesRepSaved.get(0)),
                new Opportunity(ProductType.FLATBED, 10, contactsSaved.get(1), OpportunityStatus.OPEN, salesRepSaved.get(1))
        );

        var opportunitiesSaved = opportunityRepository.saveAll(opportunities);

        var accounts = List.of(
                new Account(IndustryType.MANUFACTURING, 250, "Barcelona", "Spain", "McDonalds"),
                new Account(IndustryType.ECOMMERCE, 300, "Madrid", "Spain", "Coca-cola")
        );

        var accountsSaved = accountRepository.saveAll(accounts);

        contactsSaved.get(0).setContactAccount(accountsSaved.get(0));
        contactRepository.save(contactsSaved.get(0));
        opportunitiesSaved.get(0).setOpportunityAccount(accountsSaved.get(0));
        opportunityRepository.save(opportunitiesSaved.get(0));

        contactsSaved.get(1).setContactAccount(accountsSaved.get(1));
        contactRepository.save(contactsSaved.get(1));
        opportunitiesSaved.get(1).setOpportunityAccount(accountsSaved.get(1));
        opportunityRepository.save(opportunitiesSaved.get(1));
    }
}
