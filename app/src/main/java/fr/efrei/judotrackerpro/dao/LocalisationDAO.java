package fr.efrei.judotrackerpro.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import fr.efrei.judotrackerpro.entities.Localisation;

@Dao
public interface LocalisationDAO {

    @Query("SELECT * FROM localisation")
    List<Localisation> getAll();

    @Query("SELECT * FROM localisation WHERE id_localisation = :id")
    Localisation getById(int id);

    @Insert
    void insertAll(Localisation... localisations);

    @Insert
    void insert(Localisation localisation);

    @Update
    void updateAll(Localisation... localisations);

    @Update
    void update(Localisation localisation);

    @Delete
    void delete(Localisation localisation);
}
