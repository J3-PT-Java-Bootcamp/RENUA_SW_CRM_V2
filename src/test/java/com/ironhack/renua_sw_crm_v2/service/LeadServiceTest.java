package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.model.Lead;
import com.ironhack.renua_sw_crm_v2.model.SalesRep;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LeadServiceTest {

    @Autowired
    LeadServiceImpl leadService;

    private Lead getLead() {
        return new Lead("Name", "555555555", "name@renuasw.org", "Renua SW", new SalesRep("Sergi"));
    }

    @Test
    public void testCreateLead() {
        getLead();
    }

    @Test
    public void testShow() {
        leadService.show();
    }

    @Test
    public void testDelete() {
        leadService.delete(getLead());
    }

    @Test
    public void testPut() {
        leadService.put(getLead());
    }
}