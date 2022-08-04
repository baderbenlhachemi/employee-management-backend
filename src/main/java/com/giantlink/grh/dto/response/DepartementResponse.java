package com.giantlink.grh.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartementResponse {
    private Integer id;
    private String name;
    private Date timestamp;

    Set<TeamResponse> teams;
    Set<EmployeeResponse> employees;
}
