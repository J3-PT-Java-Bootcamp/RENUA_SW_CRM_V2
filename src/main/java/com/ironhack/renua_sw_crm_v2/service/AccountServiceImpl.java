package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.repository.AccountRepository;
import com.ironhack.renua_sw_crm_v2.enums.IndustryType;
import com.ironhack.renua_sw_crm_v2.error.ErrorHelper;
import com.ironhack.renua_sw_crm_v2.error.NotFoundException;
import com.ironhack.renua_sw_crm_v2.model.Account;
import com.ironhack.renua_sw_crm_v2.model.Contact;
import com.ironhack.renua_sw_crm_v2.model.Opportunity;
import com.ironhack.renua_sw_crm_v2.userinput.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account createAccount(String companyName) {
        final var account = new Account();
        account.setCompanyName(companyName);

        System.out.print("\nWrite industry number:\n");
        System.out.println("1: PRODUCE");
        System.out.println("2: ECOMMERCE");
        System.out.println("3: MANUFACTURING");
        System.out.println("4: MEDICAL");
        System.out.println("5: OTHER");
        IndustryType industry = new IndustryType[] {
                IndustryType.PRODUCE,
                IndustryType.ECOMMERCE,
                IndustryType.MANUFACTURING,
                IndustryType.MEDICAL,
                IndustryType.OTHER
        }[UserInput.getIntBetween(1,5) - 1];
        account.setIndustry(industry);

        System.out.print("\nNumber of employees:\n");
        int employeeCount = UserInput.getIntNumber();
        account.setEmployeeCount(employeeCount);

        System.out.print("\nWrite city:\n");
        account.setCity(UserInput.readText());

        System.out.print("\nWrite country:\n");
        account.setCountry(UserInput.readText());

        accountRepository.save(account);
        System.out.print("Account created: " + account.getId());

        return account;
    }

    @Override
    public Account addOpportunityAndContact(Account account, Opportunity opportunity, Contact contact) {
        account.getContactList().add(contact);
        account.getOpportunityList().add(opportunity);
        return accountRepository.save(account);
    }

    @Override
    public void show() {
        accountRepository.findAll().forEach((account) -> {
            System.out.println(account.toString());
        });
    }

    @Override
    public void show(Long id) {
        final var row = accountRepository.findById(id);
        if(row.isEmpty()) ErrorHelper.notFound();
        else System.out.println(row.get());
    }

    @Override
    public Account getById(Long id) throws NotFoundException {
        final var account = accountRepository.findById(id).orElseThrow(() -> new NotFoundException());
        return account;
    }
}
