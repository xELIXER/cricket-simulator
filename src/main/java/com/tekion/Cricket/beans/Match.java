package com.tekion.Cricket.beans;

import com.tekion.Cricket.beans.Team;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Match {
    private String name;
    private String groundName;
    private Date date;
    private int overs;
    private Team first, second;
}
