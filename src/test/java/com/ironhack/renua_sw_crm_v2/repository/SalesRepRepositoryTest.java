package com.ironhack.renua_sw_crm_v2.repository;

import com.ironhack.renua_sw_crm_v2.utils.TestDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SalesRepRepositoryTest {

    // Before run the test, please, remove or comment de line 45 from CRMStarterService
    // @EventListener(value = ApplicationReadyEvent.class)

    @Autowired
    TestDataService testDataService;

    @Autowired
    SalesRepRepository salesRepRepository;

    @BeforeEach
    void setUp() {
        testDataService.generateData();
    }

    @Test
    void test_reportLeadBySalesRep_ok() {
        var report = salesRepRepository.reportLeadBySalesRep();
        var one = new BigInteger("1");
        assertEquals(one, report.get(0)[1]);
    }

    @Test
    void test_reportOpportunityBySalesRep_ok() {
        var report = salesRepRepository.reportOpportunityBySalesRep();
        var one = new BigInteger("1");
        assertEquals(one, report.get(0)[1]);
    }

    @Test
    void test_reportClosedWonBySalesRep_ok() {
        var report = salesRepRepository.reportClosedWonBySalesRep();
        assertEquals(0, report.size());
    }

    @Test
    void test_reportOpenBySalesRep_ok() {
        var report = salesRepRepository.reportOpenBySalesRep();
        var one = new BigInteger("1");
        assertEquals(one, report.get(0)[1]);
    }
}