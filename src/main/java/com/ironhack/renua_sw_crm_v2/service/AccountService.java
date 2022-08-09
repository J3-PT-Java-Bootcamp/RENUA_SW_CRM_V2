package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.enums.Industry;
import com.ironhack.renua_sw_crm_v2.model.Account;
import com.ironhack.renua_sw_crm_v2.model.Contact;
import com.ironhack.renua_sw_crm_v2.model.Opportunity;
import com.ironhack.renua_sw_crm_v2.userinput.UserInput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private static final Map<Long, Account> accounts = new HashMap<>();

//    static {
//        var objects = SerializeService.getAll();
//        objects.forEach((id, object) -> {
//            if(object instanceof Account) {
//                var account = (Account) object;
//                accounts.put(account.getId(), account);
//            }
//        });
//    }

    public static Account createAccount(Opportunity opportunity) {

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

        var contact = ContactService.getById(opportunity.getDecisionMaker().getId());
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

    public static void show() {
        accounts.forEach((id, account) -> {
            System.out.println(account.toString());
        });
    }

    public static void show(Long id) {
        final var account = getById(id);
        System.out.println(account.toString());
    }

    public static Account getById(Long id) {
        return accounts.get(id);
    }

    public static void put(Account account) {
        accounts.put(account.getId(), account);
    }
}
