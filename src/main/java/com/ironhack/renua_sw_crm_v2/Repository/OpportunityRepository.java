package com.ironhack.renua_sw_crm_v2.Repository;

import com.ironhack.renua_sw_crm_v2.model.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {

    // By the product
    @Query(value = "SELECT product, count(*) num_opportunities FROM opportunities GROUP BY product", nativeQuery = true)
    List<Object[]> reportOpportunityByTheProduct();
    @Query(value = "SELECT product, count(*) num_opportunities FROM opportunities WHERE status = 'CLOSED_WON' GROUP BY product", nativeQuery = true)
    List<Object[]> reportClosedWonByTheProduct();
    @Query(value = "SELECT product, count(*) num_opportunities FROM opportunities WHERE status = 'CLOSED_LOST' GROUP BY product", nativeQuery = true)
    List<Object[]> reportClosedLostByTheProduct();
    @Query(value = "SELECT product, count(*) num_opportunities FROM opportunities WHERE status = 'OPEN' GROUP BY product", nativeQuery = true)
    List<Object[]> reportOpenByTheProduct();
}
