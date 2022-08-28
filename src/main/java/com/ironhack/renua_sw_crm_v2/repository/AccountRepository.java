package com.ironhack.renua_sw_crm_v2.repository;

import com.ironhack.renua_sw_crm_v2.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT AVG(employeeCount) FROM Account")
    Double meanEmployeeCount();

    @Query("SELECT MAX(employeeCount) FROM Account")
    Double maxEmployeecount();

    @Query("SELECT MIN(employeeCount) FROM Account")
    Double minEmployeecount();

    @Query(value = "SELECT AVG(o.id) FROM opportunities o JOIN accounts a ON o.opportunity_account_id = a.id", nativeQuery = true)
    Double meanOppsPerAccount();

    @Query(value = "SELECT MAX(a.id) FROM opportunities o JOIN accounts a ON o.opportunity_account_id = a.id", nativeQuery = true)
    Double maxOppsPerAccount();

    @Query(value = "SELECT MIN(o.id) FROM opportunities o JOIN accounts a ON o.opportunity_account_id = a.id", nativeQuery = true)
    Double minOppsPerAccount();


}
