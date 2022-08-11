package com.ironhack.renua_sw_crm_v2.service;

import com.ironhack.renua_sw_crm_v2.model.SalesRep;
import com.ironhack.renua_sw_crm_v2.userinput.UserInput;

import java.util.HashMap;
import java.util.Map;

public class SalesRepService {

    private static final Map<Long, SalesRep> salesReps = new HashMap<>();

//    static {
//        var objects = SerializeService.getAll();
//        objects.forEach((id, object) -> {
//            if(object instanceof SalesRep) {
//                var contact = (SalesRep) object;
//                salesReps.put(contact.getId(), contact);
//            }
//        });
//    }

    public static SalesRep createSalesRep() {
        System.out.print("\nWrite name:\n");
        var name = UserInput.readText();

        var salesRep = new SalesRep(name);
        put(salesRep);

        System.out.print("SalesRep created: " + salesRep.getId() + "\n");

        return salesRep;
    }

    public static void show() {
        salesReps.forEach((id, contact) -> {
            System.out.println(contact.toString());
        });
    }

    public static void show(Long id) {
        final var contact = getById(id);
        System.out.println(contact.toString());
    }

    public static SalesRep getById(Long id) {
        return salesReps.get(id);
    }

    public static void put(SalesRep contact) {
        salesReps.put(contact.getId(), contact);
    }
}
