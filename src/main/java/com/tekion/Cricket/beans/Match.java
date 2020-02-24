package com.tekion.Cricket.beans;

import lombok.Data;

import java.util.Date;

@Data
public abstract class Match {
    private String name;
    private String groundName;
    private Date date;
    private Team first;
    private Team second;

    public Match(String name, String groundName, Date date, Team first, Team second) {
        this.name = name;
        this.groundName = groundName;
        this.date = date;
        this.first = first;
        this.second = second;
    }
}
