package com.giantlink.grh.controllers;

import com.giantlink.grh.entities.Team;
import com.giantlink.grh.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company/team")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("")
    public List<Team> get() {
        return teamService.get();
    }

    @GetMapping("/get/{id}")
    public Team get(@PathVariable Integer id) {
        return teamService.get(id);
    }

    @PostMapping("/add")
    public Team add(@RequestBody Team team) {
        return teamService.add(team);
    }

    @PutMapping("/update/{id}")
    public Team update(@PathVariable Integer id, @RequestBody Team team) {
        team.setId(id);
        return teamService.update(id, team);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        teamService.delete(id);
    }


}
