package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.model.Lead;

public interface LeadService {

    void show();
    void show(Long id);
    Lead getById(Long id);
    void put(Lead lead);
    void delete(Lead lead);
    Lead createLead();
    void convertLeadToOpportunity(Long id);
}
