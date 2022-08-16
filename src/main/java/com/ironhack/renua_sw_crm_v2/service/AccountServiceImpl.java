package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.Repository.AccountRepository;
import com.ironhack.renua_sw_crm_v2.enums.Industry;
import com.ironhack.renua_sw_crm_v2.model.Account;
import com.ironhack.renua_sw_crm_v2.model.Contact;
import com.ironhack.renua_sw_crm_v2.model.Opportunity;
import com.ironhack.renua_sw_crm_v2.userinput.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    ContactService contactService;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account createAccount(Opportunity opportunity) {

        System.out.print("\nWrite industry number:\n");

        System.out.println("1: PRODUCE");
        System.out.println("2: ECOMMERCE");
        System.out.println("3: MANUFACTURING");
        System.out.println("4: MEDICAL");
        System.out.println("5: OTHER");

        Industry industry = new Industry[] {
                Industry.PRODUCE,
                Industry.ECOMMERCE,
                Industry.MANUFACTURING,
                Industry.MEDICAL,
                Industry.OTHER
        }[UserInput.getIntBetween(1,5) - 1];

        System.out.print("\nNumber of employees (Between 0 and 999999999):\n");
        int employeeCount = UserInput.getIntBetween(0, 999999999);

        System.out.print("\nWrite city:\n");
        String city = UserInput.readText();

        System.out.print("\nWrite country:\n");
        String country = UserInput.readText();

        var contact = contactService.getById(opportunity.getDecisionMaker().getId());
        var companyName = contact.getCompanyName();

        var opportunityList = new ArrayList<Opportunity>();
        opportunityList.add(opportunity);

        var contactList = new ArrayList<Contact>();
        contactList.add(opportunity.getDecisionMaker());

        var account = new Account(industry, employeeCount, city, country, companyName, contactList, opportunityList);
        put(account);

        System.out.print("Account created: " + account.getId());

        return account;
    }

    @Override
    public void show() {
        accountRepository.findAll().forEach((account) -> {
            System.out.println(account.toString());
        });
    }

    @Override
    public void show(Long id) {
        final var account = getById(id);
        System.out.println(account.toString());
    }

    @Override
    public Account getById(Long id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public void put(Account account) {
        accountRepository.save(account);
    }
}
