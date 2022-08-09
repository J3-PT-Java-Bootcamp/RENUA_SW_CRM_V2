package com.ironhack.renua_sw_crm_v2.model;

import com.ironhack.renua_sw_crm_v2.serialize.Serialize;

public class SalesRep extends Serialize {

    private String name;

    static {
        serialVersionUID = 6L; // No modify
    }

    public SalesRep(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SalesRep{" + "\n" +
                " id=" + id + "\n" +
                " name=" + name + "\n" +
                "}";
    }
}
