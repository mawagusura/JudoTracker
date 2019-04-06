package fr.efrei.judotrackerpro.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import fr.efrei.judotrackerpro.entities.Statistiques;

@Dao
public interface StatistiquesDAO {
        @Query("SELECT * FROM statistiques")
        List<Statistiques> getAll();

        @Query("SELECT * FROM statistiques WHERE id_stats = :id")
        Statistiques getById(int id);

        @Insert
        void insertAll(Statistiques... stats);

        @Insert
        void insert(Statistiques stats);

        @Update
        void updateAll(Statistiques... stats);

        @Update
        void update(Statistiques stats);

        @Delete
        void delete(Statistiques stats);
}
