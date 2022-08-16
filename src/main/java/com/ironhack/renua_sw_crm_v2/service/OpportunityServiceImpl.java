package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.Repository.OpportunityRepository;
import com.ironhack.renua_sw_crm_v2.enums.Product;
import com.ironhack.renua_sw_crm_v2.enums.Status;
import com.ironhack.renua_sw_crm_v2.model.Contact;
import com.ironhack.renua_sw_crm_v2.model.Lead;
import com.ironhack.renua_sw_crm_v2.model.Opportunity;
import com.ironhack.renua_sw_crm_v2.userinput.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpportunityServiceImpl implements OpportunityService {

    @Autowired
    ContactService contactService;

    @Autowired
    OpportunityRepository opportunityRepository;

    @Override
    public Opportunity createOpportunity(Lead lead) {

        System.out.print("\nWrite product number:\n");

        System.out.println("1: HYBRID");
        System.out.println("2: FLATED");
        System.out.println("3: BOX");

        Product product = new Product[] {Product.HYBRID, Product.FLATBED, Product.BOX}[UserInput.getIntBetween(1,3) - 1];

        System.out.print("\nNumber of trucks (Between 0 and 9999):\n");
        int trucksNum = UserInput.getIntBetween(0, 9999);

        var contact = new Contact(lead);
        contact = contactService.put(contact);

        var opportunity = new Opportunity(product, trucksNum, contact, Status.OPEN, lead.getSalesRep());
        opportunity = put(opportunity);

        System.out.print("Contact created: " + contact.getId() + "\n");
        System.out.print("Opportunity created: " + opportunity.getId() + "\n");

        return opportunity;
    }

    @Override
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

    @Override
    public void show() {
        opportunityRepository.findAll().forEach((opportunity -> {
            System.out.println(opportunity.toString());
        }));
    }

    @Override
    public void show(Long id) {
        final var opportunity = getById(id);
        System.out.println(opportunity.toString());
    }

    @Override
    public Opportunity getById(Long id) {
        return opportunityRepository.findById(id).get();
    }

    @Override
    public Opportunity put(Opportunity opportunity) {
        return opportunityRepository.save(opportunity);
    }
}