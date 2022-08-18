package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.enums.Status;
import com.ironhack.renua_sw_crm_v2.model.Lead;
import com.ironhack.renua_sw_crm_v2.model.Opportunity;

public interface OpportunityService {

    void show();
    void show(Long id);
    Opportunity getById(Long id);
    Opportunity put(Opportunity opportunity);
    Opportunity createOpportunity(Lead lead);
    void  updateStatus(Long id, Status status);
}
