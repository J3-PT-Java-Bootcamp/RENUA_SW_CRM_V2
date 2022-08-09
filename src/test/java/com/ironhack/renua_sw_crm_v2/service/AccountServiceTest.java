package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.enums.Industry;
import com.ironhack.renua_sw_crm_v2.model.Account;
import com.ironhack.renua_sw_crm_v2.model.Contact;
import com.ironhack.renua_sw_crm_v2.model.Opportunity;

import java.util.ArrayList;

public class AccountServiceTest {

    public void testShow() {
        AccountService.show();
    }

    public void testPut() {
        AccountService.put(new Account(Industry.ECOMMERCE, 244, "Baetulo", "Spagna", "Renua SW", new ArrayList<Contact>(), new ArrayList<Opportunity>()));
    }
}
