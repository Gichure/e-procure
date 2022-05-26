/**
 * 
 */
package com.pgichure.eprocure.employees.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pgichure.eprocure.employees.models.Person;
/**
 * @author pgichure
 *
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
  
}
