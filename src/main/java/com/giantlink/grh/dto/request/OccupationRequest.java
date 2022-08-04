package com.giantlink.grh.dto.request;

import com.giantlink.grh.entities.Employee;
import com.giantlink.grh.entities.Job;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OccupationRequest {
    @NotNull
    @Size(min = 3, max = 20)
    private String name;
    private Date dateOccupation;
    public boolean is_Current;


    @NotNull
    private Employee employee;

    @NotNull
    private Job job;
}
