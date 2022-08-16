package com.renua_sw.crm_v2.renua_sw_crm_v2.service;

import com.renua_sw.crm_v2.renua_sw_crm_v2.error.ErrorHelper;
import com.renua_sw.crm_v2.renua_sw_crm_v2.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OpportunityService {

    @Autowired
    private OpportunityRepository opportunityRepository;

    public void show() {
        for(final var opportunity: opportunityRepository.findAll()) System.out.println(opportunity.toString());
    }

    public void showById(int id) {
        final var row = opportunityRepository.findById(id);
        if(row.isEmpty()) ErrorHelper.notFound();
        else System.out.println(row.get().toString());
    }
}
