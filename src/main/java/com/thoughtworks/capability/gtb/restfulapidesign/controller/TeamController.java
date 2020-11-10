package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.controller.dto.TeamUpdateDto;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.service.TeamService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<Team> groupingStudents() {
        return teamService.separateTeams();
    }

    @PatchMapping
    public void updateStudent(@RequestBody @Valid TeamUpdateDto teamUpdateDto) {
        teamService.updateTeam(teamUpdateDto.getId(), teamUpdateDto.getName());
    }
}