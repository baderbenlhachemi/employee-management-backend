package com.giantlink.grh.dto.request;

import com.giantlink.grh.entities.CompanyEntity;
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
public class DepartementRequest {
    @NotNull
    @Size(min = 3, max = 20)
    private String name;

    @NotNull
    private Date timestamp;

    @NotNull
    private CompanyEntity companyEntity;



}
