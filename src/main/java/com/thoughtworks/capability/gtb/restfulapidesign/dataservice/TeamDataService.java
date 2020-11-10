package com.thoughtworks.capability.gtb.restfulapidesign.dataservice;

import com.thoughtworks.capability.gtb.restfulapidesign.model.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamDataService {
    public static List<Team> teams = new ArrayList<>();

    static {
        initTeam();
    }

    public static void initTeam() {
        int groupId;
        for (int i = 0; i < 6; i++) {
            groupId = i + 1;
            teams.add(new Team(groupId, String.format("Team %s", groupId), "", new ArrayList<>()));
        }
    }
}
