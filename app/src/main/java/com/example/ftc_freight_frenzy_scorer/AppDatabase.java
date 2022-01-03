package com.example.ftc_freight_frenzy_scorer;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Match.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MatchDao matchDao();
}
