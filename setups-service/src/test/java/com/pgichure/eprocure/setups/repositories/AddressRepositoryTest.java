package com.pgichure.eprocure.setups.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.pgichure.eprocure.setups.enums.AddressType;
import com.pgichure.eprocure.setups.models.Address;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


@DataJpaTest
public class AddressRepositoryTest{
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private AddressRepository repository;

	@Test
	public void should_find_no_records_if_repository_is_empty() {
	    Iterable list = repository.findAll();
	    assertThat(list).isEmpty();
	}
	
	@Test
	public void should_save() {
	    Address address = repository.save(Address.builder()
	    		.addressType(AddressType.ORDINARY)
	    		.building("Building 1")
	    		.city("City")
	    		.contact_person("John Doe")
	    		.email("gichurepaul@gmail.com")
	    		.mobileNumber("0700000000")
	    		.physical_address("Physical Address")
	    		.postal_address("Postal Address")
	    		.street("Street")
	    		.zip_code("001").build());
	    assertThat(address).hasFieldOrPropertyWithValue("building", "Building 1");
	    assertThat(address).hasFieldOrPropertyWithValue("email", "gichurepaul@gmail.com");
	    assertThat(address).hasFieldOrPropertyWithValue("mobileNumber", "0700000000");
	}
	
	  @Test
	  public void should_find_all_tutorials() {
	    Address address = Address.builder()
	    		.addressType(AddressType.ORDINARY)
	    		.building("Building 1")
	    		.city("City")
	    		.contact_person("John Doe")
	    		.email("gichurepaul@gmail.com")
	    		.mobileNumber("0700000000")
	    		.physical_address("Physical Address")
	    		.postal_address("Postal Address")
	    		.street("Street")
	    		.zip_code("001").build();
	    entityManager.persist(address);
	    Address address2 = Address.builder()
	    		.addressType(AddressType.ORDINARY)
	    		.building("Building 1")
	    		.city("City")
	    		.contact_person("John Doe")
	    		.email("gichurepaul@gmail.com")
	    		.mobileNumber("0700000000")
	    		.physical_address("Physical Address")
	    		.postal_address("Postal Address")
	    		.street("Street")
	    		.zip_code("001").build();
	    entityManager.persist(address2);
	    Address address3 = Address.builder()
	    		.addressType(AddressType.ORDINARY)
	    		.building("Building 1")
	    		.city("City")
	    		.contact_person("John Doe")
	    		.email("gichurepaul@gmail.com")
	    		.mobileNumber("0700000000")
	    		.physical_address("Physical Address")
	    		.postal_address("Postal Address")
	    		.street("Street")
	    		.zip_code("001").build();
	    entityManager.persist(address3);
	    List<Address> list = repository.findAll();
	    assertThat(list).hasSize(3).contains(address, address2, address3);
	  }
	  
	  
	  @Test
	  public void should_find_address_by_id() {
	    Address tut1 = Address.builder()
	    		.addressType(AddressType.ORDINARY)
	    		.building("Building 1")
	    		.city("City")
	    		.contact_person("John Doe")
	    		.email("gichurepaul@gmail.com")
	    		.mobileNumber("0700000000")
	    		.physical_address("Physical Address")
	    		.postal_address("Postal Address")
	    		.street("Street")
	    		.zip_code("001").build();
	    entityManager.persist(tut1);
	    Address tut2 = Address.builder()
	    		.addressType(AddressType.ORDINARY)
	    		.building("Building 1")
	    		.city("City")
	    		.contact_person("John Doe")
	    		.email("gichurepaul@gmail.com")
	    		.mobileNumber("0700000000")
	    		.physical_address("Physical Address")
	    		.postal_address("Postal Address")
	    		.street("Street")
	    		.zip_code("001").build();
	    entityManager.persist(tut2);
	    Address foundTutorial = repository.findById(tut2.getId()).get();
	    assertThat(foundTutorial).isEqualTo(tut2);
	  }
	  
	  
	  @Test
	  public void should_find_by_email() {
	    Address tut1 = Address.builder()
	    		.addressType(AddressType.ORDINARY)
	    		.building("Building 1")
	    		.city("City")
	    		.contact_person("John Doe")
	    		.email("gichurepaul@gmail.com")
	    		.mobileNumber("0700000000")
	    		.physical_address("Physical Address")
	    		.postal_address("Postal Address")
	    		.street("Street")
	    		.zip_code("001").build();
	    entityManager.persist(tut1);
	    Address tut2 = Address.builder()
	    		.addressType(AddressType.ORDINARY)
	    		.building("Building 1")
	    		.city("City")
	    		.contact_person("John Doe")
	    		.email("gichurepaul@gmail.com")
	    		.mobileNumber("0700000000")
	    		.physical_address("Physical Address")
	    		.postal_address("Postal Address")
	    		.street("Street")
	    		.zip_code("001").build();
	    entityManager.persist(tut2);
	    Address tut3 = Address.builder()
	    		.addressType(AddressType.ORDINARY)
	    		.building("Building 1")
	    		.city("City")
	    		.contact_person("John Doe")
	    		.email("gichurepaul@gmail.com")
	    		.mobileNumber("0700000000")
	    		.physical_address("Physical Address")
	    		.postal_address("Postal Address")
	    		.street("Street")
	    		.zip_code("001").build();
	    entityManager.persist(tut3);
	    Iterable addresses = repository.findAllByEmail("gichurepaul@gmail.com");
	    assertThat(addresses).hasSize(2).contains(tut1, tut3);
	  }
	  
	  
	  @Test
	  public void should_update_by_id() {
	    Address tut1 = Address.builder()
	    		.addressType(AddressType.ORDINARY)
	    		.building("Building 1")
	    		.city("City")
	    		.contact_person("John Doe")
	    		.email("gichurepaul@gmail.com")
	    		.mobileNumber("0700000000")
	    		.physical_address("Physical Address")
	    		.postal_address("Postal Address")
	    		.street("Street")
	    		.zip_code("001").build();
	    entityManager.persist(tut1);
	    Address tut2 = Address.builder()
	    		.addressType(AddressType.ORDINARY)
	    		.building("Building 1")
	    		.city("City")
	    		.contact_person("John Doe")
	    		.email("gichurepaul@gmail.com")
	    		.mobileNumber("0700000000")
	    		.physical_address("Physical Address")
	    		.postal_address("Postal Address")
	    		.street("Street")
	    		.zip_code("001").build();
	    entityManager.persist(tut2);
	    Address updatedTut = Address.builder()
	    		.addressType(AddressType.ORDINARY)
	    		.building("Building 1 Updated")
	    		.city("City Updated")
	    		.contact_person("John Doe")
	    		.email("gichurepaul@gmail.com")
	    		.mobileNumber("0700000000")
	    		.physical_address("Physical Address")
	    		.postal_address("Postal Address")
	    		.street("Street")
	    		.zip_code("001").build();
	    Address tut = repository.findById(tut2.getId()).get();
	    tut.setAddressType(updatedTut.getAddressType());
	    tut.setBuilding(updatedTut.getBuilding());
	    tut.setCity(updatedTut.getCity());
	    repository.save(tut);
	    Address checkTut = repository.findById(tut2.getId()).get();
	    
	    assertThat(checkTut.getId()).isEqualTo(tut2.getId());
	    assertThat(checkTut.getBuilding()).isEqualTo(updatedTut.getBuilding());
	    assertThat(checkTut.getCity()).isEqualTo(updatedTut.getCity());
	    assertThat(checkTut.getAddressType()).isEqualTo(updatedTut.getAddressType());
	  }
	  
	  
	  @Test
	  public void should_delete_address_by_id() {
	    Address tut1 = Address.builder()
	    		.addressType(AddressType.ORDINARY)
	    		.building("Building 1")
	    		.city("City")
	    		.contact_person("John Doe")
	    		.email("gichurepaul@gmail.com")
	    		.mobileNumber("0700000000")
	    		.physical_address("Physical Address")
	    		.postal_address("Postal Address")
	    		.street("Street")
	    		.zip_code("001").build();
	    entityManager.persist(tut1);
	    Address tut2 = Address.builder()
	    		.addressType(AddressType.ORDINARY)
	    		.building("Building 1")
	    		.city("City")
	    		.contact_person("John Doe")
	    		.email("gichurepaul@gmail.com")
	    		.mobileNumber("0700000000")
	    		.physical_address("Physical Address")
	    		.postal_address("Postal Address")
	    		.street("Street")
	    		.zip_code("001").build();
	    entityManager.persist(tut2);
	    Address tut3 = Address.builder()
	    		.addressType(AddressType.ORDINARY)
	    		.building("Building 1")
	    		.city("City")
	    		.contact_person("John Doe")
	    		.email("gichurepaul@gmail.com")
	    		.mobileNumber("0700000000")
	    		.physical_address("Physical Address")
	    		.postal_address("Postal Address")
	    		.street("Street")
	    		.zip_code("001").build();
	    entityManager.persist(tut3);
	    repository.deleteById(tut2.getId());
	    Iterable addresses = repository.findAll();
	    assertThat(addresses).hasSize(2).contains(tut1, tut3);
	  }
	  
	  
	  @Test
	  public void should_delete_all_address() {
	    entityManager.persist(Address.builder()
	    		.addressType(AddressType.ORDINARY)
	    		.building("Building 1")
	    		.city("City")
	    		.contact_person("John Doe")
	    		.email("gichurepaul@gmail.com")
	    		.mobileNumber("0700000000")
	    		.physical_address("Physical Address")
	    		.postal_address("Postal Address")
	    		.street("Street")
	    		.zip_code("001").build());
	    entityManager.persist(Address.builder()
	    		.addressType(AddressType.ORDINARY)
	    		.building("Building 1")
	    		.city("City")
	    		.contact_person("John Doe")
	    		.email("gichurepaul@gmail.com")
	    		.mobileNumber("0700000000")
	    		.physical_address("Physical Address")
	    		.postal_address("Postal Address")
	    		.street("Street")
	    		.zip_code("001").build());
	    repository.deleteAll();
	    assertThat(repository.findAll()).isEmpty();
	  }
}
