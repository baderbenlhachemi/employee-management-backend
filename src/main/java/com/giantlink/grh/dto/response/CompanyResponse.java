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
    private String phone;
    private String website;
    private String description;

    Set<CompanyEntityResponse> entities;
    Set<CompanyImageResponse> images;
}
