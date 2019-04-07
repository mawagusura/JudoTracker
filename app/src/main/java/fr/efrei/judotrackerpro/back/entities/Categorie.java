package fr.efrei.judotrackerpro.back.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Categorie {
    @PrimaryKey
    private int id_categorie;

    private String sexe;
    private String nom;

    public Categorie(int id_categorie, String sexe, String nom) {
        this.id_categorie = id_categorie;
        this.sexe = sexe;
        this.nom = nom;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public String getNom() {
        return nom;
    }

    public String getSexe() {
        return sexe;
    }

}
