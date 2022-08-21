package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.Repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    OpportunityRepository opportunityRepository;

    public void reportOpportunityByCity(){
        opportunityRepository.reportOpportunityByCity().forEach(oppsByCity -> {
            System.out.println(oppsByCity[0].toString() + " " + oppsByCity[1].toString());
        });
    };

    public void reportClosedWonByCity(){
        opportunityRepository.reportClosedWonByCity().forEach(oppsCloseWonByCity -> {
            System.out.println(oppsCloseWonByCity[0].toString() + " " + oppsCloseWonByCity[1].toString());
        });
    };

    public void reportClosedLostByCity(){
        opportunityRepository.reportClosedLostByCity().forEach(oppsCloseLostByCity -> {
            System.out.println(oppsCloseLostByCity[0].toString() + " " + oppsCloseLostByCity[1].toString());
        });
    };

    public void reportOpenByCity(){
        opportunityRepository.reportOpenByCity().forEach(oppsOpenByCity -> {
            System.out.println(oppsOpenByCity[0].toString() + " " + oppsOpenByCity[1].toString());
        });
    };
}
