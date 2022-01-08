package com.example.ftc_freight_frenzy_scorer;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(tableName = "match")
public class Match {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String teamName;

    public String teamCode;

    public String createTime;

    public String teamColor;
}
