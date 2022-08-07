package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.model.Contact;
import com.ironhack.serialize.SerializeService;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ContactService {
    private static final Map<UUID, Contact> contacts = new HashMap<>();

    static {
        var objects = SerializeService.getAll();
        objects.forEach((id, object) -> {
            if(object instanceof Contact) {
                var contact = (Contact) object;
                contacts.put(contact.getId(), contact);
            }
        });
    }

    public static void show() {
        contacts.forEach((id, contact) -> {
            System.out.println(contact.toString("Contact"));
        });
    }

    public static void show(UUID id) {
        final var contact = getById(id);
        System.out.println(contact.toString("Contact"));
    }

    public static Contact getById(UUID id) {
        return contacts.get(id);
    }

    public static void put(Contact contact) {
        contacts.put(contact.getId(), contact);
        SerializeService.put(contact);
    }
}
