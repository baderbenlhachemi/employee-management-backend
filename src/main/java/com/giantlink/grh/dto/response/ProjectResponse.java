package com.giantlink.grh.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectResponse {
    private Integer id;
    private String name;

    Set<JobResponse> jobs;

}
