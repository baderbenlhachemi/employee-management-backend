package com.giantlink.grh.entities;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_company_entity")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonBackReference(value = "company-companyEntity")
	@JoinColumn(name = "company_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Company company;

	@OneToMany(mappedBy = "companyEntity", fetch = FetchType.EAGER)
	@JsonManagedReference(value = "companyEntity-department")
	private Set<Departement> departements;
}
