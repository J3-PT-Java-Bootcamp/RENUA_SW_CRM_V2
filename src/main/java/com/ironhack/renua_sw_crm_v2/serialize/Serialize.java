package com.ironhack.renua_sw_crm_v2.serialize;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.UUID;

public abstract class Serialize implements Serializable {
    // Serial version ID
    protected static long serialVersionUID;
    protected UUID id;

    static {
        serialVersionUID = 0L; // No modify
    }

    public Serialize() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }


    /**
     * This method is called during serialization.
     *
     * @param oos
     */
    protected void writeObject(ObjectOutputStream oos) {
    }

    /**
     * This method is called during deserialization.
     *
     * @param ois
     */
    protected void readObject(ObjectInputStream ois) {
    }

}
