package com.giantlink.grh.services.impl;

import com.giantlink.grh.dto.mapper.TeamMapper;
import com.giantlink.grh.dto.request.TeamRequest;
import com.giantlink.grh.dto.response.TeamResponse;
import com.giantlink.grh.entities.Team;
import com.giantlink.grh.repositories.TeamRepository;
import com.giantlink.grh.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    @Override
    public TeamResponse add(TeamRequest teamRequest) {
        Team team = TeamMapper.MAPPER.fromRequestToEntity(teamRequest);
        teamRepository.save(team);
        return TeamMapper.MAPPER.fromEntityToResponse(team);
    }

    @Override
    public TeamResponse update(Integer id, TeamRequest teamRequest) {
        Team team = TeamMapper.MAPPER.fromRequestToEntity(teamRequest);
        team.setId(id);
        teamRepository.save(team);
        return TeamMapper.MAPPER.fromEntityToResponse(team);
    }

    @Override
    public TeamResponse get(Integer id) {
        Optional<Team> team = teamRepository.findById(id);
        return TeamMapper.MAPPER.fromEntityToResponse(team.get());
    }

    @Override
    public TeamResponse get(String name) {
        Optional<Team> team = teamRepository.findByName(name);
        return TeamMapper.MAPPER.fromEntityToResponse(team.get());
    }

    @Override
    public List<TeamResponse> get() {
        List<Team> team = teamRepository.findAll();
        return TeamMapper.MAPPER.fromEntityListToResponse(team);
        }


    @Override
    public void delete(Integer id) {
        teamRepository.deleteById(id);
    }
}
