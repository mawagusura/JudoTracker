package fr.efrei.judotrackerpro.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import fr.efrei.judotrackerpro.entities.Competition;

@Dao
public interface CompetitionDAO {
    @Query("SELECT * FROM competition")
    List<Competition> getAll();

    @Query("SELECT * FROM competition WHERE id_competition = :id")
    Competition getById(int id);

    @Query("SELECT * FROM competition WHERE id_localisation = :id")
    List<Competition> getByIdLocalisation(int id);

    @Query("SELECT * FROM competition WHERE id_categorie = :id")
    List<Competition> getByIdCategorie(int id);

    @Insert
    void insertAll(Competition... competitions);

    @Insert
    void insert(Competition competition);

    @Update
    void updateAll(Competition... competition);

    @Update
    void update(Competition competition);

    @Delete
    void delete(Competition competition);

}
