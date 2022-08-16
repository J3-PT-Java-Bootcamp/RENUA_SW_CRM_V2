package com.renua_sw.crm_v2.renua_sw_crm_v2.service;

import com.renua_sw.crm_v2.renua_sw_crm_v2.enums.IndustryType;
import com.renua_sw.crm_v2.renua_sw_crm_v2.error.ErrorHelper;
import com.renua_sw.crm_v2.renua_sw_crm_v2.error.NotFoundException;
import com.renua_sw.crm_v2.renua_sw_crm_v2.model.Account;
import com.renua_sw.crm_v2.renua_sw_crm_v2.model.Opportunity;
import com.renua_sw.crm_v2.renua_sw_crm_v2.repository.AccountRepository;
import com.renua_sw.crm_v2.renua_sw_crm_v2.userinput.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public void show() {
        for (final var account: accountRepository.findAll()) System.out.println(account.toString());
    }

    public void showById(int id) {
        final var row = accountRepository.findById(id);
        if(row.isEmpty()) ErrorHelper.notFound();
        else System.out.println(row.get().toString());
    }

    public Account findById(int id) throws NotFoundException {
        final var entity = accountRepository.findById(id);
        if(entity.isEmpty()) throw new NotFoundException();
        return entity.get();
    }

    public Account createAccount() {
        final var account = new Account();

        System.out.println("1: ECOMMERCE");
        System.out.println("2: MEDICAL");
        System.out.println("3: PRODUCE");
        System.out.println("4: MANUFACTURING");
        System.out.println("5: OTHER");
        final IndustryType industry = new IndustryType[] { IndustryType.ECOMMERCE, IndustryType.MEDICAL, IndustryType.PRODUCE, IndustryType.MANUFACTURING, IndustryType.OTHER }[UserInput.getIntBetween(1,5) - 1];
        account.setIndustry(industry);

        System.out.print("\nNumber of employees (Between 0 and 99999):\n");
        account.setEmployeeCount(UserInput.getIntBetween(1, 99999));

        System.out.println("\nCity");
        account.setCity(UserInput.readText());

        System.out.println("\nCountry");
        account.setCountry(UserInput.readText());

        accountRepository.save(account);

        return account;
    }

    public void addOpportunity(Account account, Opportunity opportunity) {
        account.getOpportunityList().add(opportunity);
        accountRepository.save(account);
    }
}