package com.pgichure.eprocure.setups.seeders;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.pgichure.eprocure.setups.dtos.AddressDto;
import com.pgichure.eprocure.setups.dtos.CompanyGroupDto;
import com.pgichure.eprocure.setups.dtos.CountryDto;
import com.pgichure.eprocure.setups.dtos.CurrencyDto;
import com.pgichure.eprocure.setups.enums.AddressType;
import com.pgichure.eprocure.setups.models.Country;
import com.pgichure.eprocure.setups.services.CompanyGroupServiceI;
import com.pgichure.eprocure.setups.services.CountryServiceI;
import com.pgichure.eprocure.setups.services.CurrencyServiceI;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Paul
 * https://gitlab.com/pgichure/straight-through-payments-and-settlement/-/commit/81e30a2ff45d573a91bca1e9c94706828633e7a5
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SetupsDatabaseSeeder {
	
	private final CountryServiceI countryService;
	
	private final CurrencyServiceI currencyService;
	
	private final CompanyGroupServiceI companyGroupService; 
  
  
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
      
      String[] locales = Locale.getISOCountries();
  		for (String countryCode : locales) {
  			Locale obj = new Locale("", countryCode);
  			List<Country> countries = countryService.findAllByCode(obj.getCountry());
  			if(countries.size() == 0)
  				countryService.save(CountryDto.builder()
  						.code(obj.getCountry())
  						.name(obj.getDisplayCountry())
  						.build());
  		}

  		log.info("Done");
      
  }
  
  private void seedCurrenciesTable() throws Exception  {
      log.info("Seeding currencies..");
      ArrayList<String> currencys = new ArrayList<String>();
      Locale[] locs = Locale.getAvailableLocales();

      for(Locale loc : locs) {
          try {
              String code = Currency.getInstance(loc).getCurrencyCode();
              String name = Currency.getInstance(loc).getDisplayName();
              if(!currencys.contains(code)) {
            	  currencys.add(code);
            	  
            	  List<CurrencyDto> list = currencyService.findAllByCode(code);
            	  if(list.size() == 0)
            		  currencyService.save(CurrencyDto.builder()
            				  .code(code)
            				  .name(name)
            				  .build());
            	  
            	  log.info("Added" + code + ", "+name);
              }
                  
          } catch(Exception exc){
        	  log.error(exc.getMessage());
          }
      }
  }
  
  private void seedCompanyGroupsTable() throws Exception  {
      log.info("Seeding company groups..");
      List<CompanyGroupDto> groups = companyGroupService.findAllByCode("CG01");
      if(groups.size() == 0)
    	  companyGroupService.save(CompanyGroupDto.builder()
    			  .address(AddressDto.builder()
    					  .addressType(AddressType.ORDINARY)
    					  .building("ABC Building")
    					  .city("Nairobi")
    					  .contact_person("Paul Gichure")
    					  .email("pg@gmail.com")
    					  .mobileNumber("0000000")
    					  .physicalAddress("4th Floor")
    					  .postalAddress("001")
    					  .zipCode("00100")
    					  .build())
    			  .code("CG01")
    			  .name("Company Group 1")
    			  .build());
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
