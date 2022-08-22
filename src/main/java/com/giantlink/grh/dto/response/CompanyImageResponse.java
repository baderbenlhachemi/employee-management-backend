package com.giantlink.grh.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.giantlink.grh.entities.Company;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyImageResponse {
    private String id;
    private String imageName;
    private String imageLink;
    private String imageType;
    @JsonIgnore
    private Company company;

}
