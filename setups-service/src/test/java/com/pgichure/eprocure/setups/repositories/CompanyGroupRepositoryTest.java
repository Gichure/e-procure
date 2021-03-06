package com.pgichure.eprocure.setups.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.pgichure.eprocure.setups.enums.OpenStatus;
import com.pgichure.eprocure.setups.models.CompanyGroup;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


@DataJpaTest
public class CompanyGroupRepositoryTest{
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private CompanyGroupRepository repository;

	//@Test
	public void should_find_no_records_if_repository_is_empty() {
	    List<CompanyGroup> list = repository.findAll();
	    assertThat(list).isEmpty();
	}
	
	//@Test
	public void should_save() {
		CompanyGroup group = CompanyGroup.builder()
				  .code("G001")
				  .name("Group 1")
				  .status(OpenStatus.OPEN)
				  .taxIdentificationNumber("T001")
				  .build();
		  entityManager.persist(group);
		  
	    List<CompanyGroup> list = repository.findAll();
	    
	    assertThat(list).hasSize(1).contains(group);
	}
	
	//@Test
	public void should_find_all_records() {
		  CompanyGroup group = CompanyGroup.builder()
				  .code("G001")
				  .name("Group 1")
				  .status(OpenStatus.OPEN)
				  .taxIdentificationNumber("T001")
				  .build();
		  entityManager.persist(group);
		  
	    List<CompanyGroup> list = repository.findAll();
	    
	    assertThat(list).hasSize(1).contains(group);
	}
	  
	  
	  @Test
	  public void should_find_record_by_id() {
      
	  }
	   
	  
	  @Test
	  public void should_update_by_id() {
	    
	  }
	  
	  
	  @Test
	  public void should_delete_record_by_id() {
	    
	  }
	  
	  
	  //@Test
	  public void should_delete_all_records() {	    
	    repository.deleteAll();
	    assertThat(repository.findAll()).isEmpty();
	  }
}
