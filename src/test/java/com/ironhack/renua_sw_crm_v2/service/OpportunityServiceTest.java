package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.enums.Product;
import com.ironhack.renua_sw_crm_v2.enums.Status;
import com.ironhack.renua_sw_crm_v2.model.Contact;
import com.ironhack.renua_sw_crm_v2.model.Opportunity;
import com.ironhack.renua_sw_crm_v2.model.SalesRep;


public class OpportunityServiceTest {

    public void testShow() {
        OpportunityService.show();
    }

    public void testPut() {
        OpportunityService.put(new Opportunity(Product.FLATBED, 12, new Contact(), Status.OPEN, new SalesRep("Sergi")));
    }
}