package com.giantlink.grh.services.impl;

import com.giantlink.grh.entities.Team;
import com.giantlink.grh.repositories.TeamRepository;
import com.giantlink.grh.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    @Override
    public Team add(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team update(Integer id, Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team get(Integer id) {
        return teamRepository.findById(id).get();
    }

    @Override
    public Team get(String name) {
        return teamRepository.findByName(name);
    }

    @Override
    public List<Team> get() {
        return teamRepository.findAll();
    }

    @Override
    public void delete(Integer id) {

    }
}
