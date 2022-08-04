package com.giantlink.grh.controllers;

import com.giantlink.grh.dto.request.TeamRequest;
import com.giantlink.grh.dto.response.TeamResponse;
import com.giantlink.grh.entities.Team;
import com.giantlink.grh.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<TeamResponse>> get() {
        return new ResponseEntity<List<TeamResponse>>(teamService.get(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TeamResponse> get(@PathVariable Integer id) {
        return new ResponseEntity<TeamResponse>(teamService.get(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TeamResponse> add(@RequestBody TeamRequest teamRequest) {
        return new ResponseEntity<TeamResponse>(teamService.add(teamRequest), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TeamResponse> update(@PathVariable Integer id, @RequestBody TeamRequest teamRequest) {
        return new ResponseEntity<TeamResponse>(teamService.update(id, teamRequest), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        teamService.delete(id);
    }


}
