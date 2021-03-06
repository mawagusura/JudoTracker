package fr.efrei.judotrackerpro.back.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import fr.efrei.judotrackerpro.back.entities.Categorie;

@Dao
public interface CategorieDAO {
    @Query("SELECT * FROM categorie")
    List<Categorie> getAll();

    @Query("SELECT * FROM categorie WHERE id_categorie LIKE :id")
    Categorie getById(Integer id);

    @Query("SELECT * FROM categorie WHERE sexe LIKE :sexe")
    List<Categorie> getBySexe(String sexe);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertAll(List<Categorie> categories);

    @Insert
    long insert(Categorie categorie);

    @Update
    void updateAll(List<Categorie> categorie);

    @Update
    void update(Categorie categorie);

    @Delete
    void delete(Categorie categorie);
}
