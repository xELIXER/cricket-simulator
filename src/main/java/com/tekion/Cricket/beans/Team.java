package com.tekion.Cricket.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tekion.Cricket.helper.TeamUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.name = name;
        if(name.equals("INDIA"))
            this.players = TeamUtil.getTeam1Players();
        else
            this.players = TeamUtil.getTeam2Players();
    }
}
