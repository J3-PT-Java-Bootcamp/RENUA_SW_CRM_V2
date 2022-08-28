package com.ironhack.renua_sw_crm_v2.service.reports;

import com.ironhack.renua_sw_crm_v2.repository.SalesRepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalesRepReportService {

    @Autowired
    SalesRepRepository salesRepRepository;

    public void reportLeadBySalesRep() {
        salesRepRepository.reportLeadBySalesRep().forEach(leadsBySalesRep -> {
            System.out.println(leadsBySalesRep[0].toString() + " " + leadsBySalesRep[1].toString());
        });
    }

    public void reportOpportunityBySalesRep() {
        salesRepRepository.reportOpportunityBySalesRep().forEach(oppBySalesRep -> {
            System.out.println(oppBySalesRep[0].toString() + " " + oppBySalesRep[1].toString());
        });
    }

    public void reportClosedWonBySalesRep() {
        salesRepRepository.reportClosedWonBySalesRep().forEach(oppCloseWonBySalesRep -> {
            System.out.println(oppCloseWonBySalesRep[0].toString() + " " + oppCloseWonBySalesRep[1].toString());
        });
    }

    public void reportOpenBySalesRep() {
        salesRepRepository.reportOpenBySalesRep().forEach(oppOpenBySalesRep -> {
            System.out.println(oppOpenBySalesRep[0].toString() + " " + oppOpenBySalesRep[1].toString());
        });
    }
}
