package com.giantlink.grh.dto.request;

import com.giantlink.grh.entities.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntityRequest {
    @NotNull
    private String name;

    private Company company;
}
