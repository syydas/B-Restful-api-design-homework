package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.dataservice.TeamDataService;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Team;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Data
public class TeamRepository {
    private final List<Team> teams = TeamDataService.teams;

    public List<Team> initTeams() {
        teams.forEach(team -> team.setStudents(new ArrayList<>()));
        return teams;
    }

    public void updateTeam(Team team, String name) {
        team.setName(name);
    }

    public Team findById(int id) {
        return teams.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
