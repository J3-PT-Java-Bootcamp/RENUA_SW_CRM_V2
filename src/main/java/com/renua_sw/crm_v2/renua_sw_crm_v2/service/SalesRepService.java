package com.renua_sw.crm_v2.renua_sw_crm_v2.service;

import com.renua_sw.crm_v2.renua_sw_crm_v2.model.SalesRep;
import com.renua_sw.crm_v2.renua_sw_crm_v2.repository.SalesRepRepository;
import com.renua_sw.crm_v2.renua_sw_crm_v2.userinput.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalesRepService {

    @Autowired
    private SalesRepRepository salesRepRepository;

    public void show() {
        for(final var salesRep: salesRepRepository.findAll()) System.out.println(salesRep.toString());
    }

    public SalesRep create() {
        final var salesRep = new SalesRep();
        salesRep.setName(UserInput.readText());

        salesRepRepository.save(salesRep);
        return salesRep;
    }
}