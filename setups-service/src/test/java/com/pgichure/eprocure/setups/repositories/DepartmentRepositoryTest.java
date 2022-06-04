package com.pgichure.eprocure.setups.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.pgichure.eprocure.setups.models.Department;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


@DataJpaTest
public class DepartmentRepositoryTest{
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private DepartmentRepository repository;

	//@Test
	public void should_find_no_records_if_repository_is_empty() {
	    List<Department> list = repository.findAll();
	    assertThat(list).isEmpty();
	}
	
	@Test
	public void should_save() {
	
	}
	
	 // @Test
	  public void should_find_all_records() {
	    List<Department> list = repository.findAll();
	    assertThat(list).hasSize(3);
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
	  
	  
	 // @Test
	  public void should_delete_all_records() {	    
	    repository.deleteAll();
	    assertThat(repository.findAll()).isEmpty();
	  }
}
