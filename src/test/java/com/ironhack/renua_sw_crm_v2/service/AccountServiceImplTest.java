package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.error.NotFoundException;
import com.ironhack.renua_sw_crm_v2.utils.TestDataService;
import org.junit.jupiter.api.AfterEach;
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

    @BeforeEach
    void setUp() {
        testDataService.generateData();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test_createAccount_ok() {
    }

    @Test
    void test_addOpportunityAndContact_ok() {
    }

    @Test
    void test_getById_ok() throws NotFoundException {
        var account = accountService.getById(1L);
        assertEquals(1L, account.getId());
    }
}