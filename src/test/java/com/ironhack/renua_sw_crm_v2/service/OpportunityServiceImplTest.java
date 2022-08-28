package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.repository.LeadRepository;
import com.ironhack.renua_sw_crm_v2.repository.SalesRepRepository;
import com.ironhack.renua_sw_crm_v2.enums.OpportunityStatus;
import com.ironhack.renua_sw_crm_v2.error.NotFoundException;
import com.ironhack.renua_sw_crm_v2.utils.TestDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OpportunityServiceImplTest {

    // Before run the test, please, remove or comment de line 45 from CRMStarterService
    // @EventListener(value = ApplicationReadyEvent.class)

    @Autowired
    TestDataService testDataService;

    @Autowired
    OpportunityService opportunityService;

    @Autowired
    SalesRepRepository salesRepRepository;

    @Autowired
    LeadRepository leadRepository;

    @BeforeEach
    void setUp() {
        testDataService.generateData();
    }

    @Test
    void test_updateStatus_ok() throws NotFoundException {
        opportunityService.updateStatus(1L, OpportunityStatus.CLOSED_WON);
        var opportunityWon = opportunityService.getById(1L);
        assertEquals(OpportunityStatus.CLOSED_WON, opportunityWon.getStatus());
    }

    @Test
    void test_getById_ok() throws NotFoundException {
        var opportunity = opportunityService.getById(1L);
        assertEquals(1L, opportunity.getId());
    }
}