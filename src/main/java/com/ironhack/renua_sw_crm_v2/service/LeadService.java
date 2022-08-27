package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.error.NotFoundException;
import com.ironhack.renua_sw_crm_v2.model.Lead;

public interface LeadService {

    void show();
    void show(Long id);
    Lead getById(Long id) throws NotFoundException;
    void delete(Lead lead) throws NotFoundException;
    Lead createLead() throws NotFoundException;
}
