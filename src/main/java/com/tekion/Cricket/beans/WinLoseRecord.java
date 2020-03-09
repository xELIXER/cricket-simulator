package com.tekion.Cricket.beans;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Data
@Document
public class WinLoseRecord {

    @Id
    private String teamName;
    private int won;
    private int lost;
    private int draw;

    public WinLoseRecord(String teamName, int won, int lost, int draw) {
        this.teamName = teamName;
        this.won = won;
        this.lost = lost;
        this.draw = draw;
    }

    public void incrementWins() {
        this.won++;
    }
    public void incrementDefeat() {
        this.lost++;
    }
    public void incrementDraw() {
        this.draw++;
    }
}
