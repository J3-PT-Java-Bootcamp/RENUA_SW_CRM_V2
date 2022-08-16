package com.renua_sw.crm_v2.renua_sw_crm_v2.service;

import com.renua_sw.crm_v2.renua_sw_crm_v2.enums.IndustryType;
import com.renua_sw.crm_v2.renua_sw_crm_v2.enums.OpportunityStatus;
import com.renua_sw.crm_v2.renua_sw_crm_v2.enums.ProductType;
import com.renua_sw.crm_v2.renua_sw_crm_v2.error.ErrorHelper;
import com.renua_sw.crm_v2.renua_sw_crm_v2.error.NotFoundException;
import com.renua_sw.crm_v2.renua_sw_crm_v2.model.Opportunity;
import com.renua_sw.crm_v2.renua_sw_crm_v2.repository.OpportunityRepository;
import com.renua_sw.crm_v2.renua_sw_crm_v2.userinput.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OpportunityService {

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    private LeadService leadService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private AccountService accountService;

    public void show() {
        for(final var opportunity: opportunityRepository.findAll()) System.out.println(opportunity.toString());
    }

    public void showById(int id) {
        final var row = opportunityRepository.findById(id);
        if(row.isEmpty()) ErrorHelper.notFound();
        else System.out.println(row.get().toString());
    }

    public Opportunity findById(int id) throws NotFoundException {
        final var entity = opportunityRepository.findById(id);
        if(entity.isEmpty()) throw new NotFoundException();
        return entity.get();
    }

    public Opportunity createFromLead(int leadId) throws NotFoundException {
        final var lead = leadService.findAndDeleteById(leadId);

        System.out.print("\nWrite product number:\n");

        System.out.println("1: HYBRID");
        System.out.println("2: FLATED");
        System.out.println("3: BOX");

        ProductType product = new ProductType[] {ProductType.HYBRID, ProductType.FLATED, ProductType.BOX}[UserInput.getIntBetween(1,3) - 1];

        System.out.print("\nNumber of trucks (Between 0 and 9999):\n");
        int trucksNum = UserInput.getIntBetween(0, 9999);

        final var contact = contactService.createFromLead(lead);

        System.out.print("Contact created: " + contact.getId() + "\n");

        final var opportunity = new Opportunity(product, trucksNum, contact, OpportunityStatus.OPEN, lead.getSalesRep());

        opportunityRepository.save(opportunity);
        System.out.print("Opportunity created: " + opportunity.getId() + "\n");

        System.out.println("Would you like to create a new Account? (Y/N)");
        if(UserInput.getYesNo()) {
            final var account = accountService.createAccount();
            accountService.addOpportunity(account, opportunity);
            System.out.println("Accout created: " + account.getId());
        } else {
            final int accountId = UserInput.getIntBetween(0, 999999);
            final var account = accountService.findById(accountId);
            accountService.addOpportunity(account, opportunity);
        }

        return opportunity;
    }

    public void updateStatus(int id, OpportunityStatus status) throws NotFoundException {
        final var opportunity = findById(id);
        opportunity.setStatus(status);
        opportunityRepository.save(opportunity);
    }
}
