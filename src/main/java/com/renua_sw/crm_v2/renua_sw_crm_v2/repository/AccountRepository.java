package com.renua_sw.crm_v2.renua_sw_crm_v2.repository;

import com.renua_sw.crm_v2.renua_sw_crm_v2.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}