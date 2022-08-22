package com.giantlink.grh.entities;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "tbl_company")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String email;
	private String address;
	private String phone;
	private String website;
	private String description;


	@OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
	@JsonManagedReference(value = "company-companyEntity")
	private Set<CompanyEntity> entities;

	@OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonManagedReference(value = "company-companyImage")
	private Set<CompanyImage> images;
}
