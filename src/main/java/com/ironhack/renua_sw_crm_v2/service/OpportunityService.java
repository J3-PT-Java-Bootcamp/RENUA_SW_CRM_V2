package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.enums.OpportunityStatus;
import com.ironhack.renua_sw_crm_v2.error.NotFoundException;
import com.ironhack.renua_sw_crm_v2.model.Lead;
import com.ironhack.renua_sw_crm_v2.model.Opportunity;

public interface OpportunityService {

    void show();
    void show(Long id) throws NotFoundException;
    Opportunity getById(Long id) throws NotFoundException;
    void  updateStatus(Long id, OpportunityStatus status) throws NotFoundException;
    Opportunity createFromLead(Long leadId) throws NotFoundException;
}
