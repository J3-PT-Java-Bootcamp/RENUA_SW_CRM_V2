package com.ironhack.renua_sw_crm_v2.service;


import com.ironhack.renua_sw_crm_v2.commander.Command;
import com.ironhack.renua_sw_crm_v2.commander.Commander;
import com.ironhack.renua_sw_crm_v2.enums.CommandType;
import com.ironhack.renua_sw_crm_v2.enums.Status;

public class CRMStarterService {

    public CRMStarterService() {

        System.out.println("Hello, welcome to the RENUA CRM!");
        System.out.println("Type 'help' to see the available commands");

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
                    System.out.println("\t6. show salesrep - Show all sales reps");
                    System.out.println("\t7. lookup lead :id - Show a lead by id");
                    System.out.println("\t8. lookup opportunity :id - Show an opportunity by id");
                    System.out.println("\t9. lookup account :id - Show an account by id");
                    System.out.println("\t10. lookup contact :id - Show a contact by id");
                    System.out.println("\t11. lookup salesrep :id - Show a sales rep by id");
                    System.out.println("\t12. convert :id - Convert a lead to a contact related with an opportunity and an account by lead id");
                    System.out.println("\t13. close-lost :id - Close an opportunity as lost by id");
                    System.out.println("\t14. close-won :id - Close an opportunity as won by id");
                    System.out.println("\t15. new salesrep - Create a new sales rep");
                    System.out.println("\t16. exit - Exit the program");
                }),

                // Show commands
                new Command<>("show leads", CommandType.SHOW_LEADS).addOnRun((cr) -> {
                    LeadService.show();
                }),
                new Command<>("show opportunities", CommandType.SHOW_OPPORTUNITIES).addOnRun((cr) -> {
                    OpportunityService.show();
                }),
                new Command<>("show accounts", CommandType.SHOW_ACCOUNTS).addOnRun((cr) -> {
                    AccountService.show();
                }),
                new Command<>("show contacts", CommandType.SHOW_CONTACTS).addOnRun((cr) -> {
                    ContactService.show();
                }),
                new Command<>("show salesRep", CommandType.SHOW_SALESREP).addOnRun((cr) -> {
                    SalesRepService.show();
                }),

                // Lookup commands
                new Command<>("lookup lead :id", CommandType.LOOKUP_LEAD_ID).addOnRun((cr) -> {
                    LeadService.show(cr.getUuidParameter("id"));
                }),
                new Command<>("lookup contact :id", CommandType.LOOKUP_CONTACT_ID).addOnRun((cr) -> {
                    ContactService.show(cr.getUuidParameter("id"));
                }),
                new Command<>("lookup opportunity :id", CommandType.LOOKUP_OPPORTUNITY_ID).addOnRun((cr) -> {
                    OpportunityService.show(cr.getUuidParameter("id"));
                }),
                new Command<>("lookup account :id", CommandType.LOOKUP_ACCOUNT_ID).addOnRun((cr) -> {
                    AccountService.show(cr.getUuidParameter("id"));
                }),
                new Command<>("lookup salesRep :id", CommandType.LOOKUP_SALESREP_ID).addOnRun((cr) -> {
                    SalesRepService.show(cr.getUuidParameter("id"));
                }),

                // Lead commands
                new Command<>("convert :id", CommandType.CONVERT_LEAD).addOnRun((cr) -> {
                    LeadService.convertLeadToOpportunity(cr.getUuidParameter("id"));
                }),
                new Command<>("new lead", CommandType.NEW_LEAD).addOnRun((cr) -> {
                    LeadService.createLead();
                }),

                // Change opportunity status commands
                new Command<>("close-lost :id", CommandType.CLOSE_LOST).addOnRun((cr) -> {
                    OpportunityService.updateStatus(cr.getUuidParameter("id"), Status.CLOSED_LOST);
                }),
                new Command<>("close-won :id", CommandType.CLOSE_WON).addOnRun((cr) -> {
                    OpportunityService.updateStatus(cr.getUuidParameter("id"), Status.CLOSED_WON);
                }),

                // SalesRep commands
                new Command<>("New SalesRep", CommandType.NEW_SALESREP).addOnRun((cr) -> {
                    SalesRepService.createSalesRep();
                }),
        });

        // Run event when a command is executed
        commander.setAutorun(true);

        do {
            var command = commander.askForCommand();
            if(command.getResult() == CommandType.EXIT) break;
        } while (true);
    }





}
