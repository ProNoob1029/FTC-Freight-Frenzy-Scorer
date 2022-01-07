package com.example.ftc_freight_frenzy_scorer;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "match")
public class Match {
    @PrimaryKey
    public int id;

    public String teamName;

    public String teamCode;
}
