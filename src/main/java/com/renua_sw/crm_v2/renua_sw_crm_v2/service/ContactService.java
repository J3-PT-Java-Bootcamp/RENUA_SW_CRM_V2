package com.renua_sw.crm_v2.renua_sw_crm_v2.service;

import com.renua_sw.crm_v2.renua_sw_crm_v2.error.ErrorHelper;
import com.renua_sw.crm_v2.renua_sw_crm_v2.model.Contact;
import com.renua_sw.crm_v2.renua_sw_crm_v2.model.Lead;
import com.renua_sw.crm_v2.renua_sw_crm_v2.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public void show() {
        for(final var contact: contactRepository.findAll()) System.out.println(contact.toString());
    }

    public void showById(int id) {
        final var row = contactRepository.findById(id);
        if(row.isEmpty()) ErrorHelper.notFound();
        else System.out.println(row.get().toString());
    }

    public Contact createContact() {
        final var contact = new Contact();

        contactRepository.save(contact);
        return contact;
    }

    public Contact createFromLead(Lead lead) {
        final var contact = new Contact();
        contact.setEmail(lead.getEmail());
        contact.setPhoneNumber(lead.getPhoneNumber());

        contactRepository.save(contact);
        return contact;
    }
}