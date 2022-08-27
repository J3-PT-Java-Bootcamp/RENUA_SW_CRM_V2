package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.enums.ProductType;
import com.ironhack.renua_sw_crm_v2.error.NotFoundException;
import com.ironhack.renua_sw_crm_v2.model.Account;
import com.ironhack.renua_sw_crm_v2.model.Contact;
import com.ironhack.renua_sw_crm_v2.model.Opportunity;
import com.ironhack.renua_sw_crm_v2.model.SalesRep;

import java.util.List;

public interface AccountService {

    Account createAccount(String companyName);
    void show();
    void show(Long id);
    Account getById(Long id) throws NotFoundException;
    void addOpportunityAndContact(Account account, Opportunity opportunity, Contact contact);

    void meanEmployeecount();

    void maxEmployeecount();

    void minEmployeecount();

    void meanOppsPerAccount();

    void maxOppsPerAccount();

    void minOppsPerAccount();

    Account assignData(Contact decisionMaker, SalesRep salesRep, ProductType product, int trucksNum);
}
