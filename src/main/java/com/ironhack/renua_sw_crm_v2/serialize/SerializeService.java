package com.ironhack.renua_sw_crm_v2.serialize;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SerializeService<T> {

    // Creating a map of the file names and the file paths.
    private final static String DATABASE = "src/main/java/com/ironhack/serialize/serialised-data.txt";

    /**
     * Save the data into a file using Serialization.
     *
     * @param map the Map<UUID, Object> to save.
     */
    private static void save(Map<UUID, Object> map) {

        try (FileOutputStream fos = new FileOutputStream(DATABASE);
             ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(map);
        } catch (FileNotFoundException e) {
            // Error in accessing the file
            e.printStackTrace();
        } catch (IOException e) {
            // Error in converting the Map
            e.printStackTrace();
        }
    }

    /**
     * Reading data object from the given file.
     *
     * @return converted Map<UUID, Object> object.
     */
    private static Map<UUID, Object> read() throws FileNotFoundException {
        Map<UUID, Object> map = null;

        try (FileInputStream fis = new FileInputStream(DATABASE); ObjectInputStream ois = new ObjectInputStream(fis);) {
            map = (Map<UUID, Object>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Error in accessing the file
            return new HashMap<>();
        } catch (IOException e) {
            // Error in converting the Map
            return new HashMap<>();
        } catch (ClassNotFoundException e) {
            // You are converting an invalid stream to Map
            e.printStackTrace();
        }
        return map;
    }

    /**
     * Read the file, get the object with the given id, and return it.
     *
     * @param id The id of the object you want to get.
     * @return The object with the given id.
     */
    public static Object getById(UUID id) {
        Map<UUID, Object> map;

        try {
            map = read();
            return map.get(id);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reads the file and returns a map of all the key-value pairs
     *
     * @return A map of the contents of the file.
     */
    public static Map<UUID, Object> getAll() {
        Map<UUID, Object> map;

        try {
            map = read();
            return map;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new HashMap();
        }
    }

    /**
     * If the file exists, read it, add the object to the map, and save the map. If the file doesn't exist, create a new
     * map, add the object to the map, and save the map
     *
     * @param object The object to be saved.
     */
    public static void put(Serialize object) {

        Map<UUID, Object> map;

        try {
            map = read();
        } catch (FileNotFoundException e) {
            map = new HashMap();
        }

        if(map == null) {
            map = new HashMap();
        }

        map.put(object.getId(), object);
        save(map);
    }

    /**
     * Replace the object in the file with the same id as the object passed in
     *
     * @param object the object to be replaced
     */
    public static void replace(Serialize object) {
        Map<UUID, Object> map;

        try {
            map = read();
        } catch (FileNotFoundException e) {
            map = new HashMap();
        }

        map.replace(object.getId(), object);
        save(map);
    }

    /**
     * Delete the object from the map.
     *
     * @param object The object to be deleted.
     */
    public static void delete(Serialize object) {
        Map<UUID, Object> map;

        try {
            map = read();
        } catch (FileNotFoundException e) {
            map = new HashMap();
        }

        map.remove(object.getId());
        save(map);
    }

    /**
     * Delete the record with the given id from the given table.
     *
     * @param id The id of the object you want to delete.
     */
    public static void delete(UUID id) {
        Map<UUID, Object> map;

        try {
            map = read();
        } catch (FileNotFoundException e) {
            map = new HashMap();
        }

        map.remove(id);
        save(map);
    }
}
