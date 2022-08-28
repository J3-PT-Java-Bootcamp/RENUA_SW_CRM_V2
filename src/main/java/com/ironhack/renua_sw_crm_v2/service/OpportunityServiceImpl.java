package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.repository.AccountRepository;
import com.ironhack.renua_sw_crm_v2.repository.OpportunityRepository;
import com.ironhack.renua_sw_crm_v2.enums.ProductType;
import com.ironhack.renua_sw_crm_v2.enums.OpportunityStatus;
import com.ironhack.renua_sw_crm_v2.error.ErrorHelper;
import com.ironhack.renua_sw_crm_v2.error.NotFoundException;
import com.ironhack.renua_sw_crm_v2.model.*;
import com.ironhack.renua_sw_crm_v2.userinput.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpportunityServiceImpl implements OpportunityService {

    @Autowired
    ContactService contactService;

    @Autowired
    OpportunityRepository opportunityRepository;

    @Autowired
    AccountService accountService;

    @Autowired
    LeadService leadService;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Opportunity createFromLead(Long leadId) throws NotFoundException {
        final var lead = leadService.getById(leadId);
        leadService.delete(lead);

        System.out.print("\nWrite product number:\n");

        System.out.println("1: HYBRID");
        System.out.println("2: FLATBED");
        System.out.println("3: BOX");

        ProductType product = new ProductType[] {ProductType.HYBRID, ProductType.FLATBED, ProductType.BOX}[UserInput.getIntBetween(1,3) - 1];

        System.out.print("\nNumber of trucks:\n");
        int trucksNum = UserInput.getIntNumber();

        final var contact = contactService.createFromLead(lead);
        System.out.print("Contact created: " + contact.getId() + "\n");

        final var opportunity = new Opportunity(product, trucksNum, contact, OpportunityStatus.OPEN, lead.getSalesRep());

        opportunityRepository.save(opportunity);
        System.out.print("Opportunity created: " + opportunity.getId() + "\n");

        var areAccounts = accountRepository.findAll().size() > 0;
        Account account;

        if(areAccounts) {
            System.out.println("Would you like to create a new Account? (Y/N)");
            if(UserInput.getYesNo()) {
                account = accountService.createAccount(contact.getCompanyName());
                System.out.println("Accout created: " + account.getId());
            } else {
                System.out.println("\nAccount ID:\n");
                final Long accountId = Long.parseLong(UserInput.readText());
                account = accountService.getById(accountId);
                System.out.println("Accout added: " + account.getId());
            }
        } else {
            System.out.println("No account has been created yet. We will create one.");
            account = accountService.createAccount(contact.getCompanyName());
            System.out.println("Accout created: " + account.getId());
        }

        opportunity.setOpportunityAccount(account);
        opportunityRepository.save(opportunity);
        contact.setContactAccount(account);
        contactService.save(contact);

        return opportunity;
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