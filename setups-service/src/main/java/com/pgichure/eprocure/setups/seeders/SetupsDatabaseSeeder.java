package com.pgichure.eprocure.setups.seeders;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Paul
 * https://gitlab.com/pgichure/straight-through-payments-and-settlement/-/commit/81e30a2ff45d573a91bca1e9c94706828633e7a5
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DatabaseSeeder {
  
  
  @EventListener
	public void seed(ContextRefreshedEvent event) throws Exception {
	    seedCountriesTable();
	    seedCurrenciesTable();
      seedCompanyGroupsTable();
	    seedCompaniesTable();
	    seedDepartmentsTable();
      seedDesignationsTable();
      seedExchangeRatesTable();
	}
  
  private void seedCountriesTable() throws Exception {
      log.info("Seeding countries..");
  }
  
  private void seedCurrenciesTable() throws Exception  {
      log.info("Seeding currencies..");
  }
  
  private void seedCompanyGroupsTable() throws Exception  {
      log.info("Seeding company groups..");
  }
  
  private void seedCompaniesTable() throws Exception  {
      log.info("Seeding companies..");
  }
  
  private void seedDepartmentsTable() throws Exception  {
      log.info("Seeding departments..");
  }
  
  private void seedDesignationsTable() throws Exception  {
      log.info("Seeding designations..");
  }
  
  private void seedExchangeRatesTable() throws Exception  {
      log.info("Seeding exchange rates..");
  }
  
}
