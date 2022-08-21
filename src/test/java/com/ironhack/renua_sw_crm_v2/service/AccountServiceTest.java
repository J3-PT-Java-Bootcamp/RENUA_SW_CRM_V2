package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.enums.IndustryType;
import com.ironhack.renua_sw_crm_v2.model.Account;
import com.ironhack.renua_sw_crm_v2.model.Contact;
import com.ironhack.renua_sw_crm_v2.model.Opportunity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class AccountServiceTest {

    @Autowired
    AccountServiceImpl accountService;

    public void testShow() {
        accountService.show();
    }

    public void testPut() {
        accountService.put(new Account(IndustryType.ECOMMERCE, 244, "Baetulo", "Spagna", "Renua SW", new ArrayList<Contact>(), new ArrayList<Opportunity>()));
    }
}
