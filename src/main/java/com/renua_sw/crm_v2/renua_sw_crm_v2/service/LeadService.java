package com.renua_sw.crm_v2.renua_sw_crm_v2.service;

import com.renua_sw.crm_v2.renua_sw_crm_v2.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;
}
