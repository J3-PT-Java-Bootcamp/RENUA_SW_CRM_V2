package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.Repository.ContactRepository;
import com.ironhack.renua_sw_crm_v2.error.ErrorHelper;
import com.ironhack.renua_sw_crm_v2.error.NotFoundException;
import com.ironhack.renua_sw_crm_v2.model.Contact;
import com.ironhack.renua_sw_crm_v2.model.Lead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Override
    public void show() {
        contactRepository.findAll().forEach((contact) -> {
            System.out.println(contact.toString("Contact", ""));
        });
    }

    @Override
    public void show(Long id) {
        final var row = contactRepository.findById(id);
        if(row.isEmpty()) ErrorHelper.notFound();
        else System.out.println(row.get());
    }
    @Override
    public Contact getById(Long id) throws NotFoundException {
        final var contact = contactRepository.findById(id).orElseThrow(() -> new NotFoundException());
        return contact;
    }

    @Override
    public Contact createFromLead(Lead lead) {
        final var contact = new Contact(lead);
        contactRepository.save(contact);

        return contact;
    }
}
