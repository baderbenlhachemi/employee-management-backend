package com.giantlink.grh.dto.mapper;

import com.giantlink.grh.dto.request.TeamRequest;
import com.giantlink.grh.dto.response.TeamResponse;
import com.giantlink.grh.entities.Team;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    TeamMapper MAPPER = Mappers.getMapper(TeamMapper.class);
    Team fromRequestToEntity(TeamRequest teamRequest);
    TeamResponse fromEntityToResponse(Team team);
    List<TeamResponse> fromEntityListToResponse(List<Team> teams);
}
