package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.model.SalesRep;

public interface SalesRepService {

    void show();
    void show(Long id);
    SalesRep getById(Long id);
    void put(SalesRep salesRep);
    SalesRep createSalesRep();
}
