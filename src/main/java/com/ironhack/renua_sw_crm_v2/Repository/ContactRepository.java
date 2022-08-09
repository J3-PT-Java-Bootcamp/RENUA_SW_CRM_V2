package com.ironhack.renua_sw_crm_v2.Repository;

import com.ironhack.renua_sw_crm_v2.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
