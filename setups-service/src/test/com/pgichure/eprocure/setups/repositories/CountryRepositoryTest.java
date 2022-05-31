package com.pgichure.eprocure.setups.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.pgichure.eprocure.setups.models.Country;
import com.pgichure.eprocure.setups.repositories.CountryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CountryRepositoryTest{

	@Autowired
	CountryRepository repository;

	@Test
	public void find_no_addresses_if_repo_is_empty() {
		Iterable<Country> llist = repository.findAll();

		assertThat(list).isEmpty();
	}
  
  @Test
	public void save_a_country() {

	}
  
 
}
