package com.giantlink.grh.dto.request;

import com.giantlink.grh.entities.Departement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TeamRequest {
    @NotNull
    private String name;

    @NotNull
    private Departement departement;
}
