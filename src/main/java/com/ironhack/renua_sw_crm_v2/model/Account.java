package com.ironhack.renua_sw_crm_v2.model;

import com.ironhack.enums.Industry;
import com.ironhack.serialize.Serialize;

import java.util.List;
import java.util.UUID;

public class Account extends Serialize {

    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;
    private String companyName; // This attribute can be removed; it appears in one place in the exercise description and not in another.
    private List<UUID> contactList;
    private List<UUID> opportunityList;

    static {
        serialVersionUID = 5L; // No modify
    }

    public Account(Industry industry, int employeeCount, String city, String country, String companyName, List<UUID> contactList, List<UUID> opportunityList) {
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;
        this.companyName = companyName;
        this.contactList = contactList;
        this.opportunityList = opportunityList;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<UUID> getContactList() {
        return contactList;
    }

    public void setContactList(List<UUID> contactList) {
        this.contactList = contactList;
    }

    public List<UUID> getOpportunityList() {
        return opportunityList;
    }

    public void setOpportunityList(List<UUID> opportunityList) {
        this.opportunityList = opportunityList;
    }

    @Override
    public String toString() {
        return "Account{" + "\n" +
                " id=" + id + "\n" +
                " industry=" + industry + "\n" +
                " employeeCount=" + employeeCount + "\n" +
                " city='" + city + '\'' + "\n" +
                " country='" + country + '\'' + "\n" +
                " companyName='" + companyName + '\'' + "\n" +
                " contactList=" + contactList + "\n" +
                " opportunityList=" + opportunityList + "\n" +
                '}';
    }
}
