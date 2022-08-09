package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.enums.Industry;
import com.ironhack.renua_sw_crm_v2.model.Account;

import java.util.ArrayList;
import java.util.UUID;

public class AccountServiceTest {

    public void testShow() {
        AccountService.show();
    }

    public void testPut() {
        AccountService.put(new Account(Industry.ECOMMERCE, 244, "Baetulo", "Spagna", "Renua SW", new ArrayList<UUID>(), new ArrayList<UUID>()));
    }
}
