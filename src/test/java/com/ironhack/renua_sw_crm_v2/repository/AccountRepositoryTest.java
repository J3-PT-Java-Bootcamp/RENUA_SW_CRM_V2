package com.ironhack.renua_sw_crm_v2.repository;

import com.ironhack.renua_sw_crm_v2.utils.TestDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountRepositoryTest {

    @Autowired
    TestDataService testDataService;

    @Autowired
    AccountRepository accountRepository;

    @BeforeEach
    void setUp() {
        testDataService.generateData();
    }

    @Test
    void test_meanEmployeeCount_ok() {
        var report = accountRepository.meanEmployeeCount();
        assertEquals(425.00, report);
    }

    @Test
    void test_maxEmployeecount_ok() {
        var report = accountRepository.maxEmployeecount();
        assertEquals(300.00, report);
    }

    @Test
    void test_minEmployeecount_ok() {
        var report = accountRepository.minEmployeecount();
        assertEquals(250.00, report);
    }

    @Test
    void test_meanOppsPerAccount_ok() {
        var report = accountRepository.meanOppsPerAccount();
        assertEquals(1.00, report);
    }

    @Test
    void test_maxOppsPerAccount_ok() {
        var report = accountRepository.maxOppsPerAccount();
        assertEquals(1.00, report);
    }

    @Test
    void test_minOppsPerAccount_ok() {
        var report = accountRepository.minOppsPerAccount();
        assertEquals(1.00, report);
    }
}