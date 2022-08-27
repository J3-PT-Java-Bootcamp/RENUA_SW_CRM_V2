package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.Repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    OpportunityRepository opportunityRepository;

    public void reportOpportunityByCountry(){
        opportunityRepository.reportOpportunityByCountry().forEach(oppsByCountry -> {
            System.out.println(oppsByCountry[0].toString() + " " + oppsByCountry[1].toString());
        });
    };

    public void reportClosedWonByCountry(){
        opportunityRepository.reportClosedWonByCountry().forEach(oppsCloseWonByCountry -> {
            System.out.println(oppsCloseWonByCountry[0].toString() + " " + oppsCloseWonByCountry[1].toString());
        });
    };

    public void reportClosedLostByCountry(){
        opportunityRepository.reportClosedLostByCountry().forEach(oppsCloseLostByCountry -> {
            System.out.println(oppsCloseLostByCountry[0].toString() + " " + oppsCloseLostByCountry[1].toString());
        });
    };

    public void reportOpenByCountry(){
        opportunityRepository.reportOpenByCountry().forEach(oppsOpenByCountry -> {
            System.out.println(oppsOpenByCountry[0].toString() + " " + oppsOpenByCountry[1].toString());
        });
    };
}
