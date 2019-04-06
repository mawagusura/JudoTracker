package fr.efrei.judotrackerpro.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import fr.efrei.judotrackerpro.entities.Categorie;

@Dao
public interface CategorieDAO {
    @Query("SELECT * FROM categorie")
    List<Categorie> getAll();

    @Query("SELECT * FROM categorie WHERE id_categorie LIKE :id")
    Categorie getById(int id);

    @Query("SELECT * FROM categorie WHERE sexe LIKE :sexe")
    List<Categorie> getBySexe(String sexe);

    @Insert
    void insertAll(Categorie... categorie);

    @Insert
    void insert(Categorie categorie);

    @Update
    void updateAll(Categorie... categorie);

    @Update
    void update(Categorie categorie);

    @Delete
    void delete(Categorie categorie);
}
