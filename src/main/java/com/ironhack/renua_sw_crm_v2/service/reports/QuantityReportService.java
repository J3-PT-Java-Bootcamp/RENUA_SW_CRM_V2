package com.ironhack.renua_sw_crm_v2.service.reports;

import com.ironhack.renua_sw_crm_v2.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuantityReportService {

    @Autowired
    OpportunityRepository opportunityRepository;

    public void meanQuantity() {
        var mean = opportunityRepository.meanQuantity();
        System.out.println(mean);
    }

    public void maxQuantity() {
        var max = opportunityRepository.maxQuantity();
        System.out.println(max);
    }

    public void minQuantity() {
        var min = opportunityRepository.minQuantity();
        System.out.println(min);
    }
}
