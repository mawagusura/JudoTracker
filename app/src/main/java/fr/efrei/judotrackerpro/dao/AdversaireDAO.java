package fr.efrei.judotrackerpro.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import fr.efrei.judotrackerpro.entities.Adversaire;

@Dao
public interface AdversaireDAO {
    @Query("SELECT * FROM adversaire")
    List<Adversaire> getAll();

    @Query("SELECT * FROM adversaire WHERE id_adversaire LIKE :id")
    Adversaire getById(int id);

    @Query("SELECT * FROM adversaire WHERE nom_adversaire LIKE :nom")
    List<Adversaire> getByNom(String nom);

    @Query("SELECT * FROM adversaire WHERE prenom_adversaire LIKE :prenom")
    List<Adversaire> getByPrenom(String prenom);

    @Insert
    void insert(Adversaire adversaire);

    @Update
    void update(Adversaire adversaire);

    @Insert
    void insertAll(Adversaire... adversaires);

    @Update
    void updateAll(Adversaire... adversaires);

    @Delete
    void delete(Adversaire adversaire);
}
