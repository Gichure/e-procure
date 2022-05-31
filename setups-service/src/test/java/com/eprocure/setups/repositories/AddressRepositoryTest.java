package com.pgichure.eprocure.setups.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.pgichure.eprocure.setups.models.Address;
import com.pgichure.eprocure.setups.repositories.AddressRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AddressRepositoryTest{

	@Autowired
	AddressRepository repository;

	@Test
	public void find_no_addresses_if_repo_is_empty() {
		Iterable<Address> addresses = repository.findAll();

		assertThat(addresses).isEmpty();
	}
  
  @Test
	public void save_an_address() {

	}
  
 
}
