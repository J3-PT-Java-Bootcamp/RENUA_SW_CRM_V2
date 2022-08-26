package com.ironhack.renua_sw_crm_v2.Repository;

import com.ironhack.renua_sw_crm_v2.utils.TestDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class SalesRepRepositoryTest {

    @Autowired
    TestDataService testDataService;

    @Autowired
    SalesRepRepository salesRepRepository;

    @BeforeEach
    void setUp() {
        testDataService.generateData();
    }

    @Test
    void reportLeadBySalesRep() {
    }

    @Test
    void reportOpportunityBySalesRep() {
    }

    @Test
    void reportClosedWonBySalesRep() {
    }

    @Test
    void reportOpenBySalesRep() {
    }
}