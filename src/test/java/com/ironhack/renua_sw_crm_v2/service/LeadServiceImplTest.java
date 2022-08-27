package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.Repository.LeadRepository;
import com.ironhack.renua_sw_crm_v2.Repository.SalesRepRepository;
import com.ironhack.renua_sw_crm_v2.error.NotFoundException;
import com.ironhack.renua_sw_crm_v2.model.Lead;
import com.ironhack.renua_sw_crm_v2.utils.TestDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LeadServiceImplTest {

    // Before run the test, please, remove or comment de line 45 from CRMStarterService
    // @EventListener(value = ApplicationReadyEvent.class)

    @Autowired
    TestDataService testDataService;

    @Autowired
    LeadService leadService;

    @Autowired
    SalesRepRepository salesRepRepository;

    @Autowired
    LeadRepository leadRepository;

    @BeforeEach
    void setUp() {
        testDataService.generateData();
    }

    @Test
    void test_delete_ok() throws NotFoundException {
        var firstSalesRep = salesRepRepository.findById(1L).orElseThrow();
        var lead = new Lead("Robert", "682632654", "robert@mail.com", "Puma", firstSalesRep);
        var leadSaved = leadRepository.save(lead);
        leadService.delete(leadSaved);
        assertThrows(NotFoundException.class, () -> {leadService.getById(leadSaved.getId());});
    }

    @Test
    void test_getById_ok() throws NotFoundException {
        var lead = leadService.getById(1L);
        assertEquals(1L, lead.getId());
    }
}