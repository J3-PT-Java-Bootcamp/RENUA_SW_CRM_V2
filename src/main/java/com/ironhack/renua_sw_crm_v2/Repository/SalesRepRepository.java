package com.ironhack.renua_sw_crm_v2.Repository;

import com.ironhack.renua_sw_crm_v2.model.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepRepository extends JpaRepository<SalesRep, Long> {

    @Query(value = "SELECT s.name, count(*) num_leads FROM leads l JOIN sales_reps s ON l.sales_rep_id = s.id GROUP BY s.name", nativeQuery = true)
    List<Object[]> reportLeadBySalesRep();

    @Query(value = "SELECT s.name, count(*) num_opportunities FROM opportunities o JOIN sales_reps s ON o.sales_rep_id = s.id GROUP BY s.name", nativeQuery = true)
    List<Object[]> reportOpportunityBySalesRep();

    @Query(value = "SELECT s.name, count(*) num_opportunities FROM opportunities o JOIN sales_reps s ON o.sales_rep_id = s.id AND o.status = 'CLOSED_WON' GROUP BY s.name", nativeQuery = true)
    List<Object[]> reportClosedWonBySalesRep();

    @Query(value = "SELECT s.name, count(*) num_opportunities FROM opportunities o JOIN sales_reps s ON o.sales_rep_id = s.id AND o.status = 'OPEN' GROUP BY s.name", nativeQuery = true)
    List<Object[]> reportOpenBySalesRep();

}
