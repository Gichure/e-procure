/**
 * 
 */
package com.pgichure.eprocure.employees.models;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.repository.NoRepositoryBean;

import com.pgichure.eprocure.employees.enums.EmployementType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author pgichure
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
@Entity
public class Employee extends Auditable<String>{

	@ManyToOne
	@JoinColumn(name = "person_id", nullable = false)
	private Person person;
	
	@ManyToOne
	@JoinColumn(name = "supervisor_id")
	private Employee supervisor;
	
	@Column(name = "employement_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private EmployementType employementType;
	
	@Column(name = "employement_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private ZonedDateTime employementDate;
	
	@Column(name = "exit_date")
	@Temporal(TemporalType.DATE)
	private ZonedDateTime exitDate;
	
	@Column(name = "department_id", nullable = false)
	private Long departmentId;
	
	@Column(name = "designation_id", nullable = false)
	private Long designationId;
	
	@Column(name = "company_id", nullable = false)
	private Long companyId;
}
