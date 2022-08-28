package com.ironhack.renua_sw_crm_v2.service.reports;

import com.ironhack.renua_sw_crm_v2.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountReportService {

    @Autowired
    AccountRepository accountRepository;

    public void meanOppsPerAccount() {
        var mean = accountRepository.meanOppsPerAccount();
        System.out.println(mean);
    }

    public void maxOppsPerAccount() {
        var max = accountRepository.maxOppsPerAccount();
        System.out.println(max);
    }

    public void minOppsPerAccount() {
        var min = accountRepository.minOppsPerAccount();
        System.out.println(min);
    }


}
