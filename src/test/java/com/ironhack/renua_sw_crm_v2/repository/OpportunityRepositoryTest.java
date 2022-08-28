package com.ironhack.renua_sw_crm_v2.repository;

import com.ironhack.renua_sw_crm_v2.utils.TestDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OpportunityRepositoryTest {

    @Autowired
    TestDataService testDataService;

    @Autowired
    OpportunityRepository opportunityRepository;

    @BeforeEach
    void setUp() {
        testDataService.generateData();
    }

    @Test
    void test_reportOpportunityByTheProduct_ok() {
        var report = opportunityRepository.reportOpenByTheProduct();
        var one = new BigInteger("1");
        assertEquals(one, report.get(0)[1]);
    }

    @Test
    void test_reportClosedWonByTheProduct_ok() {
        var report = opportunityRepository.reportClosedWonByTheProduct();
        assertEquals(0, report.size());
    }

    @Test
    void test_reportClosedLostByTheProduct_ok() {
        var report = opportunityRepository.reportClosedLostByTheProduct();
        assertEquals(0, report.size());
    }

    @Test
    void test_reportOpenByTheProduct_ok() {
        var report = opportunityRepository.reportOpenByTheProduct();
        var one = new BigInteger("1");
        assertEquals(one, report.get(0)[1]);
    }

    @Test
    void test_reportOpportunityByCountry_ok() {
        var report = opportunityRepository.reportOpportunityByCountry();
        var two = new BigInteger("2");
        assertEquals(two, report.get(0)[1]);
    }

    @Test
    void test_reportClosedWonByCountry_ok() {
        var report = opportunityRepository.reportClosedWonByCountry();
        assertEquals(0, report.size());
    }

    @Test
    void test_reportClosedLostByCountry_ok() {
        var report = opportunityRepository.reportClosedLostByCountry();
        assertEquals(0, report.size());
    }

    @Test
    void test_reportOpenByCountry_ok() {
        var report = opportunityRepository.reportOpenByCountry();
        var two = new BigInteger("2");
        assertEquals(two, report.get(0)[1]);
    }

    @Test
    void test_reportOpportunityByCity_ok() {
        var report = opportunityRepository.reportOpportunityByCity();
        var one = new BigInteger("1");
        assertEquals(one, report.get(0)[1]);
    }

    @Test
    void test_reportClosedWonByCity_ok() {
        var report = opportunityRepository.reportClosedWonByCity();
        assertEquals(0, report.size());
    }

    @Test
    void test_reportClosedLostByCity_ok() {
        var report = opportunityRepository.reportClosedLostByCity();
        assertEquals(0, report.size());
    }

    @Test
    void test_reportOpenByCity_ok() {
        var report = opportunityRepository.reportOpenByCity();
        var one = new BigInteger("1");
        assertEquals(one, report.get(0)[1]);
    }

    @Test
    void test_reportOpportunityByIndustry_ok() {
        var report = opportunityRepository.reportOpportunityByIndustry();
        var one = new BigInteger("1");
        assertEquals(one, report.get(0)[1]);
    }

    @Test
    void test_reportClosedWonByIndustry_ok() {
        var report = opportunityRepository.reportClosedWonByIndustry();
        assertEquals(0, report.size());
    }

    @Test
    void test_reportClosedLostByIndustry_ok() {
        var report = opportunityRepository.reportClosedLostByIndustry();
        assertEquals(0, report.size());
    }

    @Test
    void test_reportOpenByIndustry_ok() {
        var report = opportunityRepository.reportOpenByIndustry();
        var one = new BigInteger("1");
        assertEquals(one, report.get(0)[1]);
    }

    @Test
    void test_meanQuantity_ok() {
        var report = opportunityRepository.meanQuantity();
        assertEquals(7.50, report);
    }

    @Test
    void test_maxQuantity_ok() {
        var report = opportunityRepository.maxQuantity();
        assertEquals(10.00, report);
    }

    @Test
    void test_minQuantity_ok() {
        var report = opportunityRepository.minQuantity();
        assertEquals(5.00, report);
    }
}