package com.renua_sw.crm_v2.renua_sw_crm_v2.repository;

import com.renua_sw.crm_v2.renua_sw_crm_v2.model.Lead;
import com.renua_sw.crm_v2.renua_sw_crm_v2.model.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer> {

    @Query("SELECT COUNT(id) as 'count', sales_rep FROM leads GROUP BY sales_rep")
    List<Object[]> countAllBySalesRep();
}