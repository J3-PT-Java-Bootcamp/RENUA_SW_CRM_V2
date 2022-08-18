package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.model.Contact;

public interface ContactService {

    void show();
    void show(Long id);
    Contact getById(Long id);
    Contact put(Contact contact);
}
