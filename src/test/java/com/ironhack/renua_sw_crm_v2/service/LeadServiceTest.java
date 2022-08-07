package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.model.Lead;
import junit.framework.TestCase;
import org.junit.*;

public class LeadServiceTest extends TestCase {


    private Lead getLead() {
        return new Lead("Name", "555555555", "name@renuasw.org", "Renua SW");
    }

    @Test
    public void testCreateLead() {
        getLead();
    }

    @Test
    public void testShow() {
        LeadService.show();
    }

    @Test
    public void testDelete() {
        LeadService.delete(getLead());
    }

    @Test
    public void testPut() {
        LeadService.put(getLead());
    }
}