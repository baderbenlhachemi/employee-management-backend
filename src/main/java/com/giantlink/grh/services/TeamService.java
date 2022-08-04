package com.giantlink.grh.services;

import com.giantlink.grh.dto.request.TeamRequest;
import com.giantlink.grh.dto.response.TeamResponse;
import com.giantlink.grh.entities.Team;

import java.util.List;

public interface TeamService {

    TeamResponse add(TeamRequest teamRequest);

    TeamResponse update(Integer id, TeamRequest teamRequest);

    TeamResponse get(Integer id);

    TeamResponse get(String name);

    List<TeamResponse> get();

    void delete(Integer id);


}
