package com.ironhack.renua_sw_crm_v2.Repository;

import com.ironhack.renua_sw_crm_v2.model.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesRepRepository extends JpaRepository<SalesRep, Long> {

    @Query(value = "SELECT s.name, count(*) num_leads FROM lead_user l JOIN sales_rep s ON l.sales_rep_id = s.id GROUP BY s.name", nativeQuery = true)
    List<Object[]> reportLeadBySalesRep();

    @Query(value = "SELECT s.name, count(*) num_opportunities FROM opportunity o JOIN sales_rep s ON o.sales_rep_id = s.id GROUP BY s.name", nativeQuery = true)
    List<Object[]> reportOpportunityBySalesRep();

    @Query(value = "select s.name, count(*) num_opportunities from opportunity o join sales_rep s on o.sales_rep_id = s.id group by s.name having o.status=\"CLOSE_WON\"", nativeQuery = true)
    List<Object[]> reportClosedWonBySalesRep();

}
