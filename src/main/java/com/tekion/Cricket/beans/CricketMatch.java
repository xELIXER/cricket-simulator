package com.tekion.Cricket.beans;

import lombok.Data;

import java.util.Date;

@Data
public class CricketMatch extends Match {
    private int overs;

    public CricketMatch(String name, String groundName, Date date, Team first, Team second, int overs) {
        super(name, groundName, date,first,second);
        this.overs = overs;
    }
}
