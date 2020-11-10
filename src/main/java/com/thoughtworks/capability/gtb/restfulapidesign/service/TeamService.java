package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.model.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final StudentService studentService;

    public TeamService(TeamRepository teamRepository, StudentService studentService) {
        this.teamRepository = teamRepository;
        this.studentService = studentService;
    }

    public List<Team> initTeams() {
        return teamRepository.initTeams();
    }

    public List<Team> separateTeams() {
        List<Student> students = studentService.findAllStudents();
        Collections.shuffle(students);
        List<Team> teams = initTeams();
        for (int stuIndex = 0; stuIndex < students.size(); stuIndex++) {
            teams.get(stuIndex % teams.size()).getStudents().add(students.get(stuIndex));
        }
        return teams;
    }
}