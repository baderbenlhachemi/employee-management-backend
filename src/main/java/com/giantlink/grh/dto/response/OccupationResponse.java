package com.giantlink.grh.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OccupationResponse {
    private Integer id;
    private String name;
    private boolean is_Current;
    private Date dateOccupation;
}
