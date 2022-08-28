package com.ironhack.renua_sw_crm_v2.service.reports;

import com.ironhack.renua_sw_crm_v2.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCountReportService {

    @Autowired
    AccountRepository accountRepository;
    public void meanEmployeecount() {
        var mean = accountRepository.meanEmployeeCount();
        System.out.println(mean);
    }

    public void maxEmployeecount() {
        var max = accountRepository.maxEmployeecount();
        System.out.println(max);
    }

    public void minEmployeecount() {
        var min = accountRepository.minEmployeecount();
        System.out.println(min);
    }

}
