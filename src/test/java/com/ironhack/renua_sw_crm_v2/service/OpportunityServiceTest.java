package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.enums.Product;
import com.ironhack.renua_sw_crm_v2.enums.Status;
import com.ironhack.renua_sw_crm_v2.model.Contact;
import com.ironhack.renua_sw_crm_v2.model.Opportunity;
import com.ironhack.renua_sw_crm_v2.model.SalesRep;
import org.springframework.beans.factory.annotation.Autowired;


public class OpportunityServiceTest {

    @Autowired
    OpportunityServiceImpl opportunityService;

    public void testShow() {
        opportunityService.show();
    }

    public void testPut() {
        opportunityService.put(new Opportunity(Product.FLATBED, 12, new Contact(), Status.OPEN, new SalesRep("Sergi")));
    }
}