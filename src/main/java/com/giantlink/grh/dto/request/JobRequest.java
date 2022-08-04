package com.giantlink.grh.dto.request;

import com.giantlink.grh.entities.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobRequest {
    @NotNull
    @Size(min = 3, max = 20)
    private String name;

    @NotNull
    private Project project;
}
