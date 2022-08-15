package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.Repository.SalesRepRepository;
import com.ironhack.renua_sw_crm_v2.model.SalesRep;
import com.ironhack.renua_sw_crm_v2.userinput.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesRepService {

    @Autowired
    SalesRepRepository salesRepRepository;

    public SalesRep createSalesRep() {
        System.out.print("\nWrite name:\n");
        var name = UserInput.readText();

        var salesRep = new SalesRep(name);
        put(salesRep);

        System.out.print("SalesRep created: " + salesRep.getId() + "\n");

        return salesRep;
    }

    public void show() {
        salesRepRepository.findAll().forEach((salesRep) -> {
            System.out.println(salesRep.toString());
        });
    }

    public void show(Long id) {
        final var contact = getById(id);
        System.out.println(contact.toString());
    }

    public SalesRep getById(Long id) {
        return salesRepRepository.findById(id).get();
    }

    public void put(SalesRep contact) {
        salesRepRepository.save(contact);
    }
}
