package com.ironhack.renua_sw_crm_v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RenuaSwCrmV2Application {

    public static void main(String[] args) {

//        SpringApplication.run(RenuaSwCrmV2Application.class, args);
        new CRMStarterService();
    }

}
