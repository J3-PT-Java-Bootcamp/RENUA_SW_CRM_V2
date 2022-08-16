package com.renua_sw.crm_v2.renua_sw_crm_v2.repository;

import com.renua_sw.crm_v2.renua_sw_crm_v2.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
}