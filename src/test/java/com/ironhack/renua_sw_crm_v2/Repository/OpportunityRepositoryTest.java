package com.ironhack.renua_sw_crm_v2.Repository;

import com.ironhack.renua_sw_crm_v2.utils.TestDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

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
    void reportOpportunityByTheProduct() {
    }

    @Test
    void reportClosedWonByTheProduct() {
    }

    @Test
    void reportClosedLostByTheProduct() {
    }

    @Test
    void reportOpenByTheProduct() {
    }

    @Test
    void reportOpportunityByCountry() {
    }

    @Test
    void reportClosedWonByCountry() {
    }

    @Test
    void reportClosedLostByCountry() {
    }

    @Test
    void reportOpenByCountry() {
    }

    @Test
    void reportOpportunityByCity() {
    }

    @Test
    void reportClosedWonByCity() {
    }

    @Test
    void reportClosedLostByCity() {
    }

    @Test
    void reportOpenByCity() {
    }

    @Test
    void reportOpportunityByIndustry() {
    }

    @Test
    void reportClosedWonByIndustry() {
    }

    @Test
    void reportClosedLostByIndustry() {
    }

    @Test
    void reportOpenByIndustry() {
    }
}