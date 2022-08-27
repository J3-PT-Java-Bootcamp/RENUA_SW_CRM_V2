package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.Repository.ContactRepository;
import com.ironhack.renua_sw_crm_v2.Repository.OpportunityRepository;
import com.ironhack.renua_sw_crm_v2.enums.ProductType;
import com.ironhack.renua_sw_crm_v2.enums.OpportunityStatus;
import com.ironhack.renua_sw_crm_v2.error.ErrorHelper;
import com.ironhack.renua_sw_crm_v2.error.NotFoundException;
import com.ironhack.renua_sw_crm_v2.model.*;
import com.ironhack.renua_sw_crm_v2.userinput.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OpportunityServiceImpl implements OpportunityService {

    @Autowired
    ContactService contactService;

    @Autowired
    OpportunityRepository opportunityRepository;

    @Autowired
    AccountService accountService;

    @Autowired
    LeadService leadService;

    @Override
    public void createFromLead(Long leadId) throws NotFoundException {
        final var lead = leadService.getById(leadId);
        leadService.delete(lead);

        System.out.print("\nWrite product number:\n");

        System.out.println("1: HYBRID");
        System.out.println("2: FLATBED");
        System.out.println("3: BOX");

        ProductType product = new ProductType[] {ProductType.HYBRID, ProductType.FLATBED, ProductType.BOX}[UserInput.getIntBetween(1,3) - 1];

        System.out.print("\nNumber of trucks:\n");
        int trucksNum = UserInput.getIntNumber();

        final var decisionMaker = contactService.createFromLead(lead);
        System.out.print("Contact created: " + decisionMaker.getId() + "\n");

        System.out.println("Would you like to create a new Account? (Y/N)");
        if(UserInput.getYesNo()) {
            var account = accountService.createAccount(decisionMaker.getCompanyName());
            System.out.println("Account created: " + account.getId());
            var opportunity = new Opportunity(product, trucksNum, decisionMaker, OpportunityStatus.OPEN, lead.getSalesRep(), account);
            opportunityRepository.save(opportunity);
            System.out.println("opportunity id: " + opportunity.getId());

            account.getOpportunityList().add(opportunity);
            account.getContactList().add(opportunity.getDecisionMaker());

        } else {
            var account = accountService.assignData(decisionMaker, lead.getSalesRep(), product, trucksNum);
            var opportunity = new Opportunity(product, trucksNum, decisionMaker, OpportunityStatus.OPEN, lead.getSalesRep(), account);
            opportunityRepository.save(opportunity);
            System.out.print("Opportunity created: " + opportunity.getId() + "\n");

            var opportunityList = account.getOpportunityList();
            opportunityList.add(opportunity);

            account.getOpportunityList().add(opportunity);
            account.getContactList().add(opportunity.getDecisionMaker());
            System.out.print("Data assigned to Account\n");
            System.out.println("Opportunity: " + opportunity.getId() + "  " + "Decision maker: " + opportunity.getDecisionMaker().getId());

        }

    }

    @Override
    public void meanQuantity() {
        var mean = opportunityRepository.meanQuantity();
        System.out.println(mean);
    }

    @Override
    public void maxQuantity() {
        var max = opportunityRepository.maxQuantity();
        System.out.println(max);
    }

    @Override
    public void minQuantity() {
        var min = opportunityRepository.minQuantity();
        System.out.println(min);
    }

    @Override
    public void  updateStatus(Long id, OpportunityStatus status) throws NotFoundException {
        var opportunity = getById(id);

        if(opportunity.getStatus() == OpportunityStatus.OPEN) {
            opportunity.setStatus(status);
            opportunityRepository.save(opportunity);
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
        final var row = opportunityRepository.findById(id);
        if(row.isEmpty()) ErrorHelper.notFound();
        else System.out.println(row.get());
    }

    @Override
    public Opportunity getById(Long id) throws NotFoundException {
        final var opportunity = opportunityRepository.findById(id).orElseThrow(() -> new NotFoundException());
        return opportunity;
    }
}