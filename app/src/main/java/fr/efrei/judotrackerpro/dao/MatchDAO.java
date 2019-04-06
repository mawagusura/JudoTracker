package fr.efrei.judotrackerpro.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import fr.efrei.judotrackerpro.entities.Match;

@Dao
public interface MatchDAO {
    @Query("SELECT * FROM `match`")
    List<Match> getAll();

    @Query("SELECT * FROM `match` WHERE id_match = :id")
    Match getById(int id);

    @Query("SELECT * FROM `match` WHERE id_adversaire = :id")
    List<Match> getByIdAdversaire(int id);

    @Query("SELECT * FROM `match` WHERE id_statistiques = :id")
    List<Match> getByIdStatistiques(int id);

    @Insert
    void insertAll(Match... matchs);

    @Insert
    void insert(Match match);

    @Update
    void updateAll(Match... matchs);

    @Update
    void update(Match match);

    @Delete
    void delete(Match match);

}
