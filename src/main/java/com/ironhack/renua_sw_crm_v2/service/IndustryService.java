package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.Repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndustryService {

    @Autowired
    OpportunityRepository opportunityRepository;

    public void reportOpportunityByIndustry(){
        opportunityRepository.reportOpportunityByIndustry().forEach(oppsByIndustry -> {
            System.out.println(oppsByIndustry[0].toString() + " " + oppsByIndustry[1].toString());
        });
    };

    public void reportClosedWonByIndustry(){
        opportunityRepository.reportClosedWonByIndustry().forEach(oppsCloseWonByIndustry -> {
            System.out.println(oppsCloseWonByIndustry[0].toString() + " " + oppsCloseWonByIndustry[1].toString());
        });
    };

    public void reportClosedLostByIndustry(){
        opportunityRepository.reportClosedLostByIndustry().forEach(oppsCloseLostByIndustry -> {
            System.out.println(oppsCloseLostByIndustry[0].toString() + " " + oppsCloseLostByIndustry[1].toString());
        });
    };

    public void reportOpenByIndustry(){
        opportunityRepository.reportOpenByIndustry().forEach(oppsOpenByIndustry -> {
            System.out.println(oppsOpenByIndustry[0].toString() + " " + oppsOpenByIndustry[1].toString());
        });
    };
}
