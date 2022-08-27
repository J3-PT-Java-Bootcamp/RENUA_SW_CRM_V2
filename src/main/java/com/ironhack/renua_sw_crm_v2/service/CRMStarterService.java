package com.ironhack.renua_sw_crm_v2.service;


import com.ironhack.renua_sw_crm_v2.commander.Command;
import com.ironhack.renua_sw_crm_v2.commander.Commander;
import com.ironhack.renua_sw_crm_v2.enums.CommandType;
import com.ironhack.renua_sw_crm_v2.enums.OpportunityStatus;
import com.ironhack.renua_sw_crm_v2.error.ErrorHelper;
import com.ironhack.renua_sw_crm_v2.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class CRMStarterService {

    @Autowired
    @Qualifier("sql")
    SalesRepService salesRepService;

    @Autowired
    ContactService contactService;

    @Autowired
    AccountService accountService;

    @Autowired
    OpportunityService opportunityService;

    @Autowired
    LeadService leadService;

    @Autowired
    CityService cityService;

    @Autowired
    CountryService countryService;

    @Autowired
    IndustryService industryService;

    @Autowired
    ProductService productService;

    @EventListener(ApplicationReadyEvent.class)
    public void CRMStarterService() {

        System.out.println("Hello, welcome to the RENUA CRM!");
        System.out.println("Type 'help' to see the available commands");

        final var commander = new Commander<CommandType>(new Command[] {

                // General commands
                new Command<>("exit", CommandType.EXIT),
                new Command<>("help", CommandType.HELP).addOnRun((cr) -> {
                    System.out.println("\nAvailable commands:");
                    System.out.println("\t1. new salesrep - Create a new sales rep");
                    System.out.println("\t2. new lead - Create a new lead");
                    System.out.println("\t3. show leads - Show all leads");
                    System.out.println("\t4. show opportunities - Show all opportunities");
                    System.out.println("\t5. show accounts - Show all accounts");
                    System.out.println("\t6. show contacts - Show all contacts");
                    System.out.println("\t7. show salesrep - Show all sales reps");
                    System.out.println("\t8. lookup lead :id - Show a lead by id");
                    System.out.println("\t9. lookup opportunity :id - Show an opportunity by id");
                    System.out.println("\t10. lookup account :id - Show an account by id");
                    System.out.println("\t11. lookup contact :id - Show a contact by id");
                    System.out.println("\t12. lookup salesrep :id - Show a sales rep by id");
                    System.out.println("\t13. convert :id - Convert a lead to a contact related with an opportunity and an account by lead id");
                    System.out.println("\t14. close-lost :id - Close an opportunity as lost by id");
                    System.out.println("\t15. close-won :id - Close an opportunity as won by id");
                    System.out.println("\t16. report lead by salesrep - show number of leads by salesrep");
                    System.out.println("\t17. report opportunity by salesrep - show number of opportunities by salesrep");
                    System.out.println("\t18. report closed won by salesrep - show number of closed won opportunities by salesrep");
                    System.out.println("\t19. report open by salesrep - show opened number of opportunities by salesrep");
                    System.out.println("\t20. report opportunity by :attribute - show number of opportunities by attribute, where attribute is one of the following: [the product], [city], [country], [industry]");
                    System.out.println("\t21. report closed won by :attribute - show number of closed won opportunities by attribute, where attribute is one of the following: [the product], [city], [country], [industry]");
                    System.out.println("\t22. report open by :attribute - show number of opened opportunities by attribute, where attribute is one of the following: [the product], [city], [country], [industry]");
                    System.out.println("\t23. report closed lost by :attribute - show number of closed lost opportunities by attribute, where attribute is one of the following: [the product], [city], [country], [industry]");
                    System.out.println("\t24. exit - Exit the program");
                    System.out.println("\t25. Mean Opps per Account");
                    System.out.println("\t26. Min Opps per Account");
                    System.out.println("\t27. Max Opps per Account");
                    System.out.println("\t28. Mean EmployeeCount");
                    System.out.println("\t29. Min EmployeeCount");
                    System.out.println("\t30. Max EmployeeCount");
                    System.out.println("\t31. Mean Quantity");
                    System.out.println("\t32. Min Quantity");
                    System.out.println("\t33. Max Quantity");
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
                    contactService.show();
                }),
                new Command<>("show salesreps", CommandType.SHOW_SALESREP).addOnRun((cr) -> {
                    salesRepService.show();
                }),

                // Lookup commands
                new Command<>("lookup lead :id", CommandType.LOOKUP_LEAD_ID).addOnRun((cr) -> {
                    leadService.show(cr.getLongParameter("id"));
                }),
                new Command<>("lookup contact :id", CommandType.LOOKUP_CONTACT_ID).addOnRun((cr) -> {
                    contactService.show(cr.getLongParameter("id"));
                }),
                new Command<>("lookup opportunity :id", CommandType.LOOKUP_OPPORTUNITY_ID).addOnRun((cr) -> {
                    opportunityService.show(cr.getLongParameter("id"));
                }),
                new Command<>("lookup account :id", CommandType.LOOKUP_ACCOUNT_ID).addOnRun((cr) -> {
                    accountService.show(cr.getLongParameter("id"));
                }),
                new Command<>("lookup salesRep :id", CommandType.LOOKUP_SALESREP_ID).addOnRun((cr) -> {
                    salesRepService.show(cr.getLongParameter("id"));
                }),

                // Lead commands
                new Command<>("convert :id", CommandType.CONVERT_LEAD).addOnRun((cr) -> {
                    try {
                        opportunityService.createFromLead(cr.getLongParameter("id"));
                    } catch (NotFoundException e) {
                        ErrorHelper.notFound();
                    }
                }),
                new Command<>("new lead", CommandType.NEW_LEAD).addOnRun((cr) -> {
                    try {
                        leadService.createLead();
                    } catch (NotFoundException e) {
                        ErrorHelper.notFound();
                    }
                }),

                // Change opportunity status commands
                new Command<>("close-lost :id", CommandType.CLOSE_LOST).addOnRun((cr) -> {
                    try {
                        opportunityService.updateStatus(cr.getLongParameter("id"), OpportunityStatus.CLOSED_LOST);
                    } catch (NotFoundException e) {
                        ErrorHelper.notFound();
                    }
                }),
                new Command<>("close-won :id", CommandType.CLOSE_WON).addOnRun((cr) -> {
                    try {
                        opportunityService.updateStatus(cr.getLongParameter("id"), OpportunityStatus.CLOSED_WON);
                    } catch (NotFoundException e) {
                        ErrorHelper.notFound();
                    }
                }),

                // SalesRep commands
                new Command<>("new salesrep", CommandType.NEW_SALESREP).addOnRun((cr) -> {
                    salesRepService.createSalesRep();
                }),
                new Command<>("report lead by salesrep", CommandType.REPORT_LEAD_BY_SALESREP).addOnRun((cr) -> {
                    salesRepService.reportLeadBySalesRep();
                }),
                new Command<>("report opportunity by salesrep", CommandType.REPORT_OPPORTUNITY_BY_SALESREP).addOnRun((cr) -> {
                    salesRepService.reportOpportunityBySalesRep();
                }),
                new Command<>("report closed-won by salesrep", CommandType.REPORT_CLOSED_WON_BY_SALESREP).addOnRun((cr) -> {
                    salesRepService.reportClosedWonBySalesRep();
                }),
                new Command<>("report open by salesrep", CommandType.REPORT_OPEN_BY_SALESREP).addOnRun((cr) -> {
                    salesRepService.reportOpenBySalesRep();
                }),

                // Product commands
                new Command<>("Report Opportunity by the product", CommandType.REPORT_OPPORTUNITY_BY_THE_PRODUCT).addOnRun((cr) -> {
                    productService.reportOpportunityByTheProduct();
                }),
                new Command<>("Report CLOSED-WON by the product", CommandType.REPORT_CLOSED_WON_BY_THE_PRODUCT).addOnRun((cr) -> {
                    productService.reportClosedWonByTheProduct();
                }),
                new Command<>("Report CLOSED-LOST by the product", CommandType.REPORT_CLOSED_LOST_BY_THE_PRODUCT).addOnRun((cr) -> {
                    productService.reportClosedLostByTheProduct();
                }),
                new Command<>("Report OPEN by the product", CommandType.REPORT_OPEN_BY_THE_PRODUCT).addOnRun((cr) -> {
                    productService.reportOpenByTheProduct();
                }),

                // Country commands
                new Command<>("Report Opportunity by country", CommandType.REPORT_OPPORTUNITY_BY_COUNTRY).addOnRun((cr) -> {
                    countryService.reportOpportunityByCountry();
                }),
                new Command<>("Report CLOSED-WON by country", CommandType.REPORT_CLOSED_WON_BY_COUNTRY).addOnRun((cr) -> {
                    countryService.reportClosedWonByCountry();
                }),
                new Command<>("Report CLOSED-LOST by country", CommandType.REPORT_CLOSED_LOST_BY_COUNTRY).addOnRun((cr) -> {
                    countryService.reportClosedLostByCountry();
                }),
                new Command<>("Report OPEN by country", CommandType.REPORT_OPEN_BY_COUNTRY).addOnRun((cr) -> {
                    countryService.reportOpenByCountry();
                }),

                // City commands
                new Command<>("Report Opportunity by city", CommandType.REPORT_OPPORTUNITY_BY_CITY).addOnRun((cr) -> {
                    cityService.reportOpportunityByCity();
                }),
                new Command<>("Report CLOSED-WON by city", CommandType.REPORT_CLOSED_WON_BY_CITY).addOnRun((cr) -> {
                    cityService.reportClosedWonByCity();
                }),
                new Command<>("Report CLOSED-LOST by city", CommandType.REPORT_CLOSED_LOST_BY_CITY).addOnRun((cr) -> {
                    cityService.reportClosedLostByCity();
                }),
                new Command<>("Report OPEN by city", CommandType.REPORT_OPEN_BY_CITY).addOnRun((cr) -> {
                    cityService.reportOpenByCity();
                }),

                // Industry commands
                new Command<>("Report Opportunity by industry", CommandType.REPORT_OPPORTUNITY_BY_INDUSTRY).addOnRun((cr) -> {
                    industryService.reportOpportunityByIndustry();
                }),
                new Command<>("Report CLOSED-WON by industry", CommandType.REPORT_CLOSED_WON_BY_INDUSTRY).addOnRun((cr) -> {
                    industryService.reportClosedWonByIndustry();
                }),
                new Command<>("Report CLOSED-LOST by industry", CommandType.REPORT_CLOSED_LOST_BY_INDUSTRY).addOnRun((cr) -> {
                    industryService.reportClosedLostByIndustry();
                }),
                new Command<>("Report OPEN by industry", CommandType.REPORT_OPEN_BY_INDUSTRY).addOnRun((cr) -> {
                    industryService.reportOpenByIndustry();
                }),

                //EmployeeCount commands
                new Command<>("Mean EmployeeCount", CommandType.MEAN_EMPLOYEE_COUNT).addOnRun((cr) -> {
                    accountService.meanEmployeecount();
                }),
                new Command<>("Max EmployeeCount", CommandType.MAX_EMPLOYEE_COUNT).addOnRun((cr) -> {
                    accountService.maxEmployeecount();
                }),
                new Command<>("Min EmployeeCount", CommandType.MIN_EMPLOYEE_COUNT).addOnRun((cr) -> {
                    accountService.minEmployeecount();
                }),

                //Quantity commands
                new Command<>("Mean Quantity", CommandType.MEAN_QUANTITY).addOnRun((cr) -> {
                    opportunityService.meanQuantity();
                }),
                new Command<>("Max Quantity", CommandType.MAX_QUANTITY).addOnRun((cr) -> {
                    opportunityService.maxQuantity();
                }),
                new Command<>("Min Quantity", CommandType.MIN_QUANTITY).addOnRun((cr) -> {
                    opportunityService.minQuantity();
                }),

                //Opportunity commands
                new Command<>("Mean Opps per Account", CommandType.MEAN_OPPS_PER_ACCOUNT).addOnRun((cr) -> {
                    accountService.meanOppsPerAccount();
                }),
                new Command<>("Max Opps per Account", CommandType.MAX_OPPS_PER_ACCOUNT).addOnRun((cr) -> {
                    accountService.maxOppsPerAccount();
                }),
                new Command<>("Min Opps per Account", CommandType.MIN_OPPS_PER_ACCOUNT).addOnRun((cr) -> {
                    accountService.minOppsPerAccount();
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
