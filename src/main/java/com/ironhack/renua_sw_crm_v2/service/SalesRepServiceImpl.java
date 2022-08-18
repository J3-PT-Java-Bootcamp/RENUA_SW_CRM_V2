package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.Repository.SalesRepRepository;
import com.ironhack.renua_sw_crm_v2.model.SalesRep;
import com.ironhack.renua_sw_crm_v2.userinput.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesRepServiceImpl implements SalesRepService {

    @Autowired
    SalesRepRepository salesRepRepository;

    @Override
    public SalesRep createSalesRep() {
        System.out.print("\nWrite name:\n");
        var name = UserInput.readText();

        var salesRep = new SalesRep(name);
        put(salesRep);

        System.out.print("SalesRep created: " + salesRep.getId() + "\n");

        return salesRep;
    }

    @Override
    public void reportLeadBySalesRep() {
        salesRepRepository.reportLeadBySalesRep().forEach(leadsBySalesRep -> {
            System.out.println(leadsBySalesRep[0].toString() + " " + leadsBySalesRep[1].toString());
        });
    }

    @Override
    public void reportOpportunityBySalesRep() {
        salesRepRepository.reportOpportunityBySalesRep().forEach(oppBySalesRep -> {
            System.out.println(oppBySalesRep[0].toString() + " " + oppBySalesRep[1].toString());
        });
    }

    @Override
    public void reportClosedWonBySalesRep() {
        salesRepRepository.reportClosedWonBySalesRep().forEach(oppCloseWonBySalesRep -> {
            System.out.println(oppCloseWonBySalesRep[0].toString() + " " + oppCloseWonBySalesRep[1].toString());
        });
    }

    @Override
    public void show() {
        salesRepRepository.findAll().forEach((salesRep) -> {
            System.out.println(salesRep.toString());
        });
    }

    @Override
    public void show(Long id) {
        final var contact = getById(id);
        System.out.println(contact.toString());
    }

    @Override
    public SalesRep getById(Long id) {
        return salesRepRepository.findById(id).get();
    }

    @Override
    public void put(SalesRep contact) {
        salesRepRepository.save(contact);
    }
}
