/**
 * 
 */
package com.pgichure.eprocure.employees.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pgichure
 *
 */
@Entity
@Table(name = "persons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
	
	private Long id;

}
