package com.renua_sw.crm_v2.renua_sw_crm_v2;

import com.renua_sw.crm_v2.renua_sw_crm_v2.commander.Command;
import com.renua_sw.crm_v2.renua_sw_crm_v2.commander.Commander;
import com.renua_sw.crm_v2.renua_sw_crm_v2.enums.CommandType;
import com.renua_sw.crm_v2.renua_sw_crm_v2.error.ErrorHelper;
import com.renua_sw.crm_v2.renua_sw_crm_v2.error.NotFoundException;
import com.renua_sw.crm_v2.renua_sw_crm_v2.service.AccountService;
import com.renua_sw.crm_v2.renua_sw_crm_v2.service.ContactService;
import com.renua_sw.crm_v2.renua_sw_crm_v2.service.LeadService;
import com.renua_sw.crm_v2.renua_sw_crm_v2.service.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RenuaSwCrmV2Application implements CommandLineRunner {

    @Autowired
    private LeadService leadService;

    @Autowired
    private ContactService contactService;

    @Autowired
    private OpportunityService opportunityService;

    @Autowired
    private AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(RenuaSwCrmV2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        final var commander = new Commander<CommandType>(new Command[] {
                // General commands
                new Command<>("exit", CommandType.EXIT),
                new Command<>("help", CommandType.HELP).addOnRun((cr) -> {
                    System.out.println("\nAvailable commands:");
                    System.out.println("\t1. new lead - Create a new lead");
                    System.out.println("\t2. show leads - Show all leads");
                    System.out.println("\t3. show opportunities - Show all opportunities");
                    System.out.println("\t4. show accounts - Show all accounts");
                    System.out.println("\t5. show contacts - Show all contacts");
                    System.out.println("\t6. lookup lead :id - Show a lead by id");
                    System.out.println("\t7. lookup opportunity :id - Show an opportunity by id");
                    System.out.println("\t8. lookup account :id - Show an account by id");
                    System.out.println("\t9. lookup contact :id - Show a contact by id");
                    System.out.println("\t10. convert :id - Convert a lead to a contact related with an opportunity and an account by lead id");
                    System.out.println("\t11. close-lost :id - Close an opportunity as lost by id");
                    System.out.println("\t11. close-won :id - Close an opportunity as won by id");
                    System.out.println("\t12. exit - Exit the program");
                }),

                // Show commands
                new Command<>("show leads", CommandType.SHOW_LEADS).addOnRun((cr) -> {
                    leadService.show();
                }),
                new Command<>("show opportunities", CommandType.SHOW_OPPORTUNITIES).addOnRun((cr) -> {
                    opportunityService.show();
                }),
                new Command<>("show accounts", CommandType.SHOW_ACCOUNTS).addOnRun((cr) -> {
                    accountService.show();
                }),
                new Command<>("show contacts", CommandType.SHOW_CONTACTS).addOnRun((cr) -> {
                    accountService.show();
                }),

                // Lookup commands
                new Command<>("lookup lead :id", CommandType.LOOKUP_LEAD_ID).addOnRun((cr) -> {
                    leadService.showById(cr.getIntParameter("id"));
                }),
                new Command<>("lookup contact :id", CommandType.LOOKUP_CONTACT_ID).addOnRun((cr) -> {
                    contactService.showById(cr.getIntParameter("id"));
                }),
                new Command<>("lookup opportunity :id", CommandType.LOOKUP_OPPORTUNITY_ID).addOnRun((cr) -> {
                    opportunityService.showById(cr.getIntParameter("id"));
                }),
                new Command<>("lookup account :id", CommandType.LOOKUP_ACCOUNT_ID).addOnRun((cr) -> {
                    accountService.showById(cr.getIntParameter("id"));
                }),

                // Lead commands
                new Command<>("new lead", CommandType.NEW_LEAD).addOnRun((cr) -> {
                    leadService.createLead();
                }),
                new Command<>("convert :id", CommandType.CONVERT_LEAD).addOnRun((cr) -> {
                    try {
                        opportunityService.createFromLead(cr.getIntParameter("id"));
                    } catch (NotFoundException e) {
                        ErrorHelper.notFound();
                    }
                }),

                // Change opportunity status commands
                /*new Command<>("close-lost :id", CommandType.CLOSE_LOST).addOnRun((cr) -> {
                    opportunityService.updateStatus(cr.getUuidParameter("id"), Status.CLOSED_LOST);
                }),
                new Command<>("close-won :id", CommandType.CLOSE_WON).addOnRun((cr) -> {
                    opportunityService.updateStatus(cr.getUuidParameter("id"), Status.CLOSED_WON);
                }),*/
        });

        commander.setAutorun(true);

        do {
            final var commandResult = commander.askForCommand();
            if(commandResult.getResult() == CommandType.EXIT) break;
        } while (true);
    }
}
