package com.renua_sw.crm_v2.renua_sw_crm_v2.repository;

import com.renua_sw.crm_v2.renua_sw_crm_v2.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Integer> {
}