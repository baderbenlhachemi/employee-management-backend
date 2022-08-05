package com.giantlink.grh.services.impl;


import com.giantlink.grh.dto.mapper.TeamMapper;
import com.giantlink.grh.dto.request.TeamRequest;
import com.giantlink.grh.dto.response.TeamResponse;
import com.giantlink.grh.entities.Team;
import com.giantlink.grh.exceptions.AlreadyExistsException;
import com.giantlink.grh.exceptions.NotFoundException;
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
    public TeamResponse add(TeamRequest teamRequest) throws AlreadyExistsException {
        Team team = TeamMapper.MAPPER.fromRequestToEntity(teamRequest);
        if (teamRepository.findByName(team.getName())!=null) {
            throw new AlreadyExistsException("Team with name " + team.getName() + " already exists");
        }
        teamRepository.save(team);
        return TeamMapper.MAPPER.fromEntityToResponse(team);
    }

    @Override
    public TeamResponse update(Integer id, TeamRequest teamRequest) throws AlreadyExistsException, NotFoundException {
        Team team = TeamMapper.MAPPER.fromRequestToEntity(teamRequest);
        Team newTeam = teamRepository.findById(id).orElseThrow(() -> new NotFoundException("Team not found"));
        newTeam.setName(team.getName());
        teamRepository.save(newTeam);
        return TeamMapper.MAPPER.fromEntityToResponse(newTeam);

    }

    @Override
    public TeamResponse get(Integer id) throws NotFoundException{
        Optional<Team> team = teamRepository.findById(id);
    if (team.isPresent()) {
            return TeamMapper.MAPPER.fromEntityToResponse(team.get());
        } else {
            throw new NotFoundException("Team not found");
        }
    }

    @Override
    public TeamResponse getByName(String name) throws NotFoundException{
        if (teamRepository.findByName(name)!=null) {
            return TeamMapper.MAPPER.fromEntityToResponse(teamRepository.findByName(name));
        } else {
            throw new NotFoundException("Team not found");
        }
    }

    @Override
    public List<TeamResponse> get() throws NotFoundException{
        if (teamRepository.findAll().isEmpty()) {
            throw new NotFoundException("Team not found");
        }
        List<Team> team = teamRepository.findAll();
        return TeamMapper.MAPPER.fromEntityListToResponse(team);
    }



    @Override
    public void delete(Integer id) throws NotFoundException{
        if (teamRepository.findById(id).isPresent()) {
            teamRepository.deleteById(id);
        } else {
            throw new NotFoundException("Team not found");
        }
    }
}
