package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.error.NotFoundException;
import com.ironhack.renua_sw_crm_v2.model.SalesRep;

import java.util.List;

public interface SalesRepService {

    void show();

    void show(Long id);

    SalesRep getById(Long id) throws NotFoundException;

    SalesRep createSalesRep();

    void reportLeadBySalesRep();

    void reportOpportunityBySalesRep();

    void reportClosedWonBySalesRep();
}
