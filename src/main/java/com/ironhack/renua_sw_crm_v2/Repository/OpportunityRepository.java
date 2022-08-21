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

    // By country
    @Query(value = "SELECT a.country, count(*) num_opportunities FROM opportunities o JOIN accounts a ON o.opportunity_account_id = a.id GROUP BY a.country", nativeQuery = true)
    List<Object[]> reportOpportunityByCountry();
    @Query(value = "SELECT a.country, count(*) num_opportunities FROM opportunities o JOIN accounts a ON o.opportunity_account_id = a.id AND o.status = 'CLOSED_WON' GROUP BY a.country", nativeQuery = true)
    List<Object[]> reportClosedWonByCountry();
    @Query(value = "SELECT a.country, count(*) num_opportunities FROM opportunities o JOIN accounts a ON o.opportunity_account_id = a.id AND o.status = 'CLOSED_LOST' GROUP BY a.country", nativeQuery = true)
    List<Object[]> reportClosedLostByCountry();
    @Query(value = "SELECT a.country, count(*) num_opportunities FROM opportunities o JOIN accounts a ON o.opportunity_account_id = a.id AND o.status = 'OPEN' GROUP BY a.country", nativeQuery = true)
    List<Object[]> reportOpenByCountry();

    // By city
    @Query(value = "SELECT a.city, count(*) num_opportunities FROM opportunities o JOIN accounts a ON o.opportunity_account_id = a.id GROUP BY a.city", nativeQuery = true)
    List<Object[]> reportOpportunityByCity();
    @Query(value = "SELECT a.city, count(*) num_opportunities FROM opportunities o JOIN accounts a ON o.opportunity_account_id = a.id AND o.status = 'CLOSED_WON' GROUP BY a.city", nativeQuery = true)
    List<Object[]> reportClosedWonByCity();
    @Query(value = "SELECT a.city, count(*) num_opportunities FROM opportunities o JOIN accounts a ON o.opportunity_account_id = a.id AND o.status = 'CLOSED_LOST' GROUP BY a.city", nativeQuery = true)
    List<Object[]> reportClosedLostByCity();
    @Query(value = "SELECT a.city, count(*) num_opportunities FROM opportunities o JOIN accounts a ON o.opportunity_account_id = a.id AND o.status = 'OPEN' GROUP BY a.city", nativeQuery = true)
    List<Object[]> reportOpenByCity();

    // By industry
    @Query(value = "SELECT a.industry, count(*) num_opportunities FROM opportunities o JOIN accounts a ON o.opportunity_account_id = a.id GROUP BY a.industry", nativeQuery = true)
    List<Object[]> reportOpportunityByIndustry();
    @Query(value = "SELECT a.industry, count(*) num_opportunities FROM opportunities o JOIN accounts a ON o.opportunity_account_id = a.id AND o.status = 'CLOSED_WON' GROUP BY a.industry", nativeQuery = true)
    List<Object[]> reportClosedWonByIndustry();
    @Query(value = "SELECT a.industry, count(*) num_opportunities FROM opportunities o JOIN accounts a ON o.opportunity_account_id = a.id AND o.status = 'CLOSED_LOST' GROUP BY a.industry", nativeQuery = true)
    List<Object[]> reportClosedLostByIndustry();
    @Query(value = "SELECT a.industry, count(*) num_opportunities FROM opportunities o JOIN accounts a ON o.opportunity_account_id = a.id AND o.status = 'OPEN' GROUP BY a.industry", nativeQuery = true)
    List<Object[]> reportOpenByIndustry();


}
