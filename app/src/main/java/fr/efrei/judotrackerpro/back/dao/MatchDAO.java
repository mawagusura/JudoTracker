package fr.efrei.judotrackerpro.back.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import fr.efrei.judotrackerpro.back.entities.Match;

@Dao
public interface MatchDAO {
    @Query("SELECT * FROM `match`")
    List<Match> getAll();

    @Query("SELECT * FROM `match` WHERE id_match = :id")
    Match getById(int id);

    @Query("SELECT * FROM `match` WHERE id_adversaire = :id")
    List<Match> getByIdAdversaire(int id);

    @Query("SELECT * FROM `match` WHERE id_stats = :id")
    Match getByIdStatistiques(int id);

    @Query("SELECT * FROM `match` WHERE id_competition = :id")
    List<Match> getByIdCompetition(int id);

    @Insert
    long[] insertAll(List<Match> matchs);

    @Insert
    long insert(Match match);

    @Update
    void updateAll(List<Match> matchs);

    @Update
    void update(Match match);

    @Delete
    void delete(Match match);

}
