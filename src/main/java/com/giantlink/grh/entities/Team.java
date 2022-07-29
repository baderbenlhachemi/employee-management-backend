package com.giantlink.grh.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tbl_team")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    @ManyToOne
    @JsonBackReference(value = "department-team")
    @JoinColumn(name = "departement_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Departement departement;

    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    @JsonManagedReference(value = "team-employee")
    private Set<Employee> employees;


}
