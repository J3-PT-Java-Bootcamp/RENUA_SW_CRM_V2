package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.repository.LeadRepository;
import com.ironhack.renua_sw_crm_v2.repository.SalesRepRepository;
import com.ironhack.renua_sw_crm_v2.error.NotFoundException;
import com.ironhack.renua_sw_crm_v2.model.Contact;
import com.ironhack.renua_sw_crm_v2.model.Lead;
import com.ironhack.renua_sw_crm_v2.utils.TestDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContactServiceImplTest {

    // Before run the test, please, remove or comment de line 45 from CRMStarterService
    // @EventListener(value = ApplicationReadyEvent.class)

    @Autowired
    TestDataService testDataService;

    @Autowired
    ContactService contactService;

    @Autowired
    SalesRepRepository salesRepRepository;

    @Autowired
    LeadRepository leadRepository;

    @BeforeEach
    void setUp() {
        testDataService.generateData();
    }

    @Test
    void test_getById_ok() throws NotFoundException {
        var contact = contactService.getById(1L);
        assertEquals(1L, contact.getId());
    }

    @Test
    void test_createFromLead_ok() {
        var firstSalesRep = salesRepRepository.findById(1L).orElseThrow();
        var lead = new Lead("Valeria", "682632654", "valeria@mail.com", "Tommy Hilfiger", firstSalesRep);
        var leadSaved = leadRepository.save(lead);
        var contactFromLead = contactService.createFromLead(leadSaved);
        assertTrue(contactFromLead instanceof Contact);
    }

    @Test
    void test_save_ok() {
        var contact = new Contact();
        var contactSaved = contactService.save(contact);
        assertTrue(contactSaved instanceof Contact);
    }
}