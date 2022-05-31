package com.pgichure.eprocure.setups.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pgichure.eprocure.setups.models.Address;

@DataJpaTest
public class AddressRepositoryTest{

	@Autowired
	AddressRepository repository;

	public void find_no_addresses_if_repo_is_empty() {
		Iterable<Address> addresses = repository.findAll();

		assertThat(addresses).isEmpty();
	}
  
	public void save_an_address() {

	}
  
 
}
