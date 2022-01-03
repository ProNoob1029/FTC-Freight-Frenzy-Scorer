package com.example.ftc_freight_frenzy_scorer;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface MatchDao {
    @Query("SELECT * FROM `match`")
    List<Match> getAll();

    @Query("SELECT * FROM `match` WHERE id IN (:userIds)")
    List<Match> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM `match` WHERE teamName LIKE :name AND " +
            "teamCode LIKE :code LIMIT 1")
    Match findByName(String name, String code);

    @Insert
    void insertAll(Match... matches);

    @Delete
    void delete(Match match);
}
