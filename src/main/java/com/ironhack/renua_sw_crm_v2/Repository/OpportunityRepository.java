package com.ironhack.renua_sw_crm_v2.Repository;

import com.ironhack.renua_sw_crm_v2.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {

//    @Query("SELECT COUNT(id) as 'count', sales_rep FROM opportunities GROUP BY sales_rep")
//    List<Object[]> countAllBySalesRep();
}
