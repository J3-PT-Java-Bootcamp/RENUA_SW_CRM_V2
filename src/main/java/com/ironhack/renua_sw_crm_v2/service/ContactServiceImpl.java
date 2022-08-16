package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.Repository.ContactRepository;
import com.ironhack.renua_sw_crm_v2.model.Contact;
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
        final var contact = getById(id);
        System.out.println(contact.toString("Contact", ""));
    }
    @Override
    public Contact getById(Long id) {
        return contactRepository.findById(id).get();
    }

    @Override
    public Contact put(Contact contact) {
        return contactRepository.save(contact);
    }
}
