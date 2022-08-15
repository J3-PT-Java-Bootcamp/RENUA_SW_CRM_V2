package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.Repository.ContactRepository;
import com.ironhack.renua_sw_crm_v2.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public void show() {
        contactRepository.findAll().forEach((contact) -> {
            System.out.println(contact.toString());
        });
    }

    public void show(Long id) {
        final var contact = getById(id);
        System.out.println(contact.toString("Contact"));
    }

    public Contact getById(Long id) {
        return contactRepository.findById(id).get();
    }

    public void put(Contact contact) {
        contactRepository.save(contact);
    }
}
