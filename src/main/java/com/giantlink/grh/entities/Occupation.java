package com.giantlink.grh.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_occupation")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Occupation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private boolean is_Current;
    private Date dateOccupation;


    @ManyToOne
    @JsonBackReference(value = "employee-occupation")
    @JoinColumn(name = "employee_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Employee employee;

    @ManyToOne
    @JsonBackReference(value = "occupation-job")
    @JoinColumn(name = "job_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Job job;
}
