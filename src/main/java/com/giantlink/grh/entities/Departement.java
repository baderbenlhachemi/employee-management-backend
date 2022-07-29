package com.giantlink.grh.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "tbl_entity_departement")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Departement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	@ManyToOne
	@JsonBackReference(value = "companyEntity-department")
	@JoinColumn(name = "entity_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private CompanyEntity companyEntity;

	@OneToMany(mappedBy = "departement", fetch = FetchType.EAGER)
	@JsonManagedReference(value = "department-team")
	private Set<Team> teams;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date timestamp;

	@PrePersist
	private void onCreate() {
		this.timestamp = new Date();
	}


}
