package fr.efrei.judotrackerpro.back.entities;

import java.util.UUID;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Categorie {
    @PrimaryKey(autoGenerate = true)
    private Integer id_categorie;

    private String sexe;
    private String nom;

    public Categorie(Integer id_categorie, String sexe, String nom) {
        this.id_categorie = id_categorie;
        this.sexe = sexe;
        this.nom = nom;
    }

    @Ignore
    public Categorie(String sexe, String nom) {
        this(null, sexe, nom);
    }

    public Integer getId_categorie() {
        return id_categorie;
    }

    public String getNom() {
        return nom;
    }

    public String getSexe() {
        return sexe;
    }

}
