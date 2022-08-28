package com.ironhack.renua_sw_crm_v2.service.reports;

import com.ironhack.renua_sw_crm_v2.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductReportService {
    @Autowired
    OpportunityRepository opportunityRepository;
    public void reportOpportunityByTheProduct(){
        opportunityRepository.reportOpportunityByTheProduct().forEach(oppsByProduct -> {
            System.out.println(oppsByProduct[0].toString() + " " + oppsByProduct[1].toString());
        });
    };
    public void reportClosedWonByTheProduct(){
        opportunityRepository.reportClosedWonByTheProduct().forEach(oppsCloseWonByProduct -> {
            System.out.println(oppsCloseWonByProduct[0].toString() + " " + oppsCloseWonByProduct[1].toString());
        });
    };
    public void reportClosedLostByTheProduct(){
        opportunityRepository.reportClosedLostByTheProduct().forEach(oppsCloseLostByProduct -> {
            System.out.println(oppsCloseLostByProduct[0].toString() + " " + oppsCloseLostByProduct[1].toString());
        });
    };
    public void reportOpenByTheProduct(){
        opportunityRepository.reportOpenByTheProduct().forEach(oppsOpenByProduct -> {
            System.out.println(oppsOpenByProduct[0].toString() + " " + oppsOpenByProduct[1].toString());
        });
    };
}
