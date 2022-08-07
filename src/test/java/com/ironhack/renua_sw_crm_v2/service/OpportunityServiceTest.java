package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.enums.Product;
import com.ironhack.enums.Status;
import com.ironhack.model.Opportunity;
import junit.framework.TestCase;

import java.util.UUID;

public class OpportunityServiceTest extends TestCase {

    public void testShow() {
        OpportunityService.show();
    }

    public void testPut() {
        OpportunityService.put(new Opportunity(Product.FLATBED, 12, UUID.randomUUID(), Status.OPEN));
    }
}