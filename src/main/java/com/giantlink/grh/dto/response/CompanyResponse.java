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
public class CompanyResponse {
    private Integer id;
    private String name;
    private String email;
    private String address;

    Set<CompanyEntityResponse> entities;
}
