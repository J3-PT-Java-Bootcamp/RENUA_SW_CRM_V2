package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.Repository.AccountRepository;
import com.ironhack.renua_sw_crm_v2.enums.IndustryType;
import com.ironhack.renua_sw_crm_v2.enums.ProductType;
import com.ironhack.renua_sw_crm_v2.error.ErrorHelper;
import com.ironhack.renua_sw_crm_v2.error.NotFoundException;
import com.ironhack.renua_sw_crm_v2.model.Account;
import com.ironhack.renua_sw_crm_v2.model.Contact;
import com.ironhack.renua_sw_crm_v2.model.Opportunity;
import com.ironhack.renua_sw_crm_v2.model.SalesRep;
import com.ironhack.renua_sw_crm_v2.userinput.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import javax.persistence.EntityManager;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    OpportunityService opportunityService;

    @Override
    public Account createAccount(String companyName) {

        //account.setCompanyName(companyName);

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
        //account.setIndustry(industry);

        System.out.print("\nNumber of employees:\n");
        int employeeCount = UserInput.getIntNumber();
        //account.setEmployeeCount(employeeCount);

        System.out.print("\nWrite city:\n");
        var city = UserInput.readText();
        //account.setCity(UserInput.readText());

        System.out.print("\nWrite country:\n");
        var country = UserInput.readText();
        //account.setCountry(UserInput.readText());

        var account = new Account(industry, employeeCount, city, country, companyName, new ArrayList<Contact>(), new ArrayList<Opportunity>());
        //IndustryType industry, int employeeCount, String city, String country, String companyName, List<Contact> contactList, List<Opportunity> opportunityList

        accountRepository.save(account);
        System.out.print("Account created: " + account.getId());

        return account;
    }

    @Override
    public Account assignData(Contact decisionMaker, SalesRep salesRep, ProductType product, int trucksNum) {
        var accountList = accountRepository.findAll();
        for (Account a : accountList) {
            System.out.println(a.getId() + " " + a.getCompanyName());
        }
        System.out.print("\nSelect an account:\n");
        String accountId = String.valueOf(UserInput.getIntBetween(1, accountList.size()));
        var account = accountRepository.findById(Long.valueOf(accountId));

        return account.orElseThrow(null);
    }

    @Override
    public void addOpportunityAndContact(Account account, Opportunity opportunity, Contact contact) {
        account.getContactList().add(contact);
        account.getOpportunityList().add(opportunity);
        accountRepository.save(account);
    }

    @Override
    public void meanEmployeecount() {
        var mean = accountRepository.meanEmployeeCount();
        System.out.println(mean);
    }

    @Override
    public void maxEmployeecount() {
        var max = accountRepository.maxEmployeecount();
        System.out.println(max);
    }

    @Override
    public void minEmployeecount() {
        var min = accountRepository.minEmployeecount();
        System.out.println(min);
    }

    @Override
    public void meanOppsPerAccount() {
        var mean = accountRepository.meanOppsPerAccount();
        System.out.println(mean);
    }

    @Override
    public void maxOppsPerAccount() {
        var max = accountRepository.maxOppsPerAccount();
        System.out.println(max);
    }

    @Override
    public void minOppsPerAccount() {
        var min = accountRepository.minOppsPerAccount();
        System.out.println(min);
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
