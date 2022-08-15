package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.Repository.OpportunityRepository;
import com.ironhack.renua_sw_crm_v2.enums.Product;
import com.ironhack.renua_sw_crm_v2.enums.Status;
import com.ironhack.renua_sw_crm_v2.model.Contact;
import com.ironhack.renua_sw_crm_v2.model.Lead;
import com.ironhack.renua_sw_crm_v2.model.Opportunity;
import com.ironhack.renua_sw_crm_v2.model.SalesRep;
import com.ironhack.renua_sw_crm_v2.userinput.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpportunityService {

    @Autowired
    ContactService contactService;

    @Autowired
    OpportunityRepository opportunityRepository;

    public Opportunity createOpportunity(Lead lead) {
        System.out.print("\nWrite product number:\n");

        System.out.println("1: HYBRID");
        System.out.println("2: FLATED");
        System.out.println("3: BOX");

        Product product = new Product[] {Product.HYBRID, Product.FLATBED, Product.BOX}[UserInput.getIntBetween(1,3) - 1];

        System.out.print("\nNumber of trucks (Between 0 and 9999):\n");
        int trucksNum = UserInput.getIntBetween(0, 9999);

        var contact = new Contact(lead);
        contactService.put(contact);

        System.out.print("Contact created: " + contact.getId() + "\n");

        // TODO: Ask for a Sales Rep
        var salesRep = new SalesRep("John");

        var opportunity = new Opportunity(product, trucksNum, contact, Status.OPEN, salesRep);
        put(opportunity);

        System.out.print("Opportunity created: " + opportunity.getId() + "\n");

        return opportunity;
    }

    public void  updateStatus(Long id, Status status) {
        var opportunity = getById(id);

        if(opportunity.getStatus() == Status.OPEN) {
            opportunity.setStatus(status);
            put(opportunity);
            System.out.println("Status updated to " + status);
        } else {
            System.out.println("\nOpportunity is already closed\n");
        }
    }

    public void show() {
        opportunityRepository.findAll().forEach((opportunity -> {
            System.out.println(opportunity.toString());
        }));
    }

    public void show(Long id) {
        final var opportunity = getById(id);
        System.out.println(opportunity.toString());
    }

    public Opportunity getById(Long id) {
        return opportunityRepository.findById(id).get();
    }

    public void put(Opportunity opportunity) {
        opportunityRepository.save(opportunity);
    }
}