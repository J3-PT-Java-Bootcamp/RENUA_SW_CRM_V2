package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.error.NotFoundException;
import com.ironhack.renua_sw_crm_v2.model.Account;
import com.ironhack.renua_sw_crm_v2.model.Contact;
import com.ironhack.renua_sw_crm_v2.model.Opportunity;

public interface AccountService {

    Account createAccount(String companyName);
    void show();
    void show(Long id);
    Account getById(Long id) throws NotFoundException;
    Account addOpportunityAndContact(Account account, Opportunity opportunity, Contact contact);
}
