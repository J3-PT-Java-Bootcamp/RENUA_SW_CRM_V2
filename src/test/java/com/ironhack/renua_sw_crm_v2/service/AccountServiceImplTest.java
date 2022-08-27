package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.Repository.ContactRepository;
import com.ironhack.renua_sw_crm_v2.Repository.OpportunityRepository;
import com.ironhack.renua_sw_crm_v2.Repository.SalesRepRepository;
import com.ironhack.renua_sw_crm_v2.enums.OpportunityStatus;
import com.ironhack.renua_sw_crm_v2.enums.ProductType;
import com.ironhack.renua_sw_crm_v2.error.NotFoundException;
import com.ironhack.renua_sw_crm_v2.model.Contact;
import com.ironhack.renua_sw_crm_v2.model.Opportunity;
import com.ironhack.renua_sw_crm_v2.utils.TestDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountServiceImplTest {

    // Before run the test, please, remove or comment de line 45 from CRMStarterService
    // @EventListener(value = ApplicationReadyEvent.class)

    @Autowired
    TestDataService testDataService;

    @Autowired
    AccountService accountService;

    @Autowired
    SalesRepRepository salesRepRepository;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    OpportunityRepository opportunityRepository;

    @BeforeEach
    void setUp() {
        testDataService.generateData();
    }

    @Test
    void test_addOpportunityAndContact_ok() throws NotFoundException {
        var firstSalesRep = salesRepRepository.findById(1L).orElseThrow();

        var contact = new Contact("Marco", "649649649", "marco@mail.com", "McDonalds");
        var contactSaved =contactRepository.save(contact);

        var opportunity = new Opportunity(ProductType.BOX, 10, contact, OpportunityStatus.OPEN, firstSalesRep);
        var opportunitySaved = opportunityRepository.save(opportunity);

        var account = accountService.getById(1L);
        var accountUpdated = accountService.addOpportunityAndContact(account, opportunitySaved, contactSaved);
        assertEquals(4, accountUpdated.getContactList().size() + accountUpdated.getOpportunityList().size());
    }

    @Test
    void test_getById_ok() throws NotFoundException {
        var account = accountService.getById(1L);
        assertEquals(1L, account.getId());
    }
}