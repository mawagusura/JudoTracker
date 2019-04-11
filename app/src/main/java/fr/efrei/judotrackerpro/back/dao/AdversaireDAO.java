package fr.efrei.judotrackerpro.back.dao;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import fr.efrei.judotrackerpro.back.entities.Adversaire;

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

    @Query("SELECT * FROM adversaire WHERE nom_adversaire LIKE :nom AND prenom_adversaire LIKE :prenom")
    List<Adversaire> getByNomPrenom(String nom, String prenom);

    @Insert
    long insert(Adversaire adversaire);

    @Update
    void update(Adversaire adversaire);

    @Insert
    long[] insertAll(List<Adversaire> adversaires);

    @Update
    void updateAll(List<Adversaire> adversaires);

    @Delete
    void delete(Adversaire adversaire);
}
