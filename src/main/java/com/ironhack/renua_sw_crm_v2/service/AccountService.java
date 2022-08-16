package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.model.Account;
import com.ironhack.renua_sw_crm_v2.model.Opportunity;

public interface AccountService {

    Account createAccount(Opportunity opportunity);
    void show();
    void show(Long id);
    Account getById(Long id);
    void put(Account account);
}
