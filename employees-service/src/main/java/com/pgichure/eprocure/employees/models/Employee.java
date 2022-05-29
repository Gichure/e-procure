/**
 * 
 */
package com.pgichure.eprocure.employees.models;

import java.time.ZonedDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
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
	private Date employementDate;
	
	@Column(name = "exit_date")
	@Temporal(TemporalType.DATE)
	private Date exitDate;
	
	@Column(name = "department_id", nullable = false)
	private Long departmentId;
	
	@Column(name = "designation_id", nullable = false)
	private Long designationId;
	
	@Column(name = "company_id", nullable = false)
	private Long companyId;
	
}
