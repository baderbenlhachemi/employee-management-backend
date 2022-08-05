package com.giantlink.grh.services;

import com.giantlink.grh.dto.request.TeamRequest;
import com.giantlink.grh.dto.response.TeamResponse;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.NotFoundException;

import java.util.List;

public interface TeamService {

    TeamResponse add(TeamRequest teamRequest) throws AlreadyExistsException;

    TeamResponse update(Integer id, TeamRequest teamRequest) throws AlreadyExistsException, NotFoundException;

    TeamResponse get(Integer id) throws NotFoundException;

    TeamResponse getByName(String name) throws NotFoundException;

    List<TeamResponse> get() throws NotFoundException;

    void delete(Integer id) throws NotFoundException;

}
