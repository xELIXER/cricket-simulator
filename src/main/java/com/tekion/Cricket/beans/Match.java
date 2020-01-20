package com.tekion.Cricket.beans;

import com.tekion.Cricket.beans.Team;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Match {
    String name;
    String groundName;
    Date date;
    Team team1, team2, first, second;

    public String toString(){
        return "<p><b><center>" + name + "</center></b></p>" +
                "<p><b><center>" + groundName + "</center></b></p>" +
                "<p><b><center>" + date + "</center></b></p>";

    }

//    public String getName() { return name; }
//
//    public void setName(String name) { this.name = name; }
//
//    public String getGroundName() { return groundName; }
//
//    public void setGroundName(String groundName) { this.groundName = groundName; }
//
//    public Date getDate() { return date; }
//
//    public void setDate(Date date) { this.date = date; }
//
//    public Team getTeam1() { return team1; }
//
//    public void setTeam1(Team team1) { this.team1 = team1; }
//
//    public Team getTeam2() { return team2; }
//
//    public void setTeam2(Team team2) { this.team2 = team2; }

}
