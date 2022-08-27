package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.error.NotFoundException;
import com.ironhack.renua_sw_crm_v2.model.Contact;
import com.ironhack.renua_sw_crm_v2.model.Lead;

public interface ContactService {

    void show();
    void show(Long id);
    Contact getById(Long id) throws NotFoundException;
    Contact createFromLead(Lead lead);
    Contact save(Contact contact);
}
