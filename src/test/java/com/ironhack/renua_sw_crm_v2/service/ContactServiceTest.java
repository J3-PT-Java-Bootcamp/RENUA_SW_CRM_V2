package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.model.Contact;
import com.ironhack.renua_sw_crm_v2.model.Lead;
import com.ironhack.renua_sw_crm_v2.model.SalesRep;

public class ContactServiceTest {

    public void testShow() {
        ContactService.show();
    }

    public void testPut() {
        // TODO: Ask for a Sales Rep
        var salesRep = new SalesRep("John");
        ContactService.put(new Contact(new Lead("Name", "555555555", "name@renuasw.org", "Renua SW", salesRep)));
    }
}