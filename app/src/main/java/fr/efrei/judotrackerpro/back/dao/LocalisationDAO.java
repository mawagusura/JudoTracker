package fr.efrei.judotrackerpro.back.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import fr.efrei.judotrackerpro.back.entities.Localisation;

@Dao
public interface LocalisationDAO {

    @Query("SELECT * FROM localisation")
    List<Localisation> getAll();

    @Query("SELECT * FROM localisation WHERE id_localisation = :id")
    Localisation getById(Integer id);

    @Insert
    long[] insertAll(List<Localisation> localisations);

    @Insert
    long insert(Localisation localisation);

    @Update
    void updateAll(List<Localisation> localisations);

    @Update
    void update(Localisation localisation);

    @Delete
    void delete(Localisation localisation);
}
