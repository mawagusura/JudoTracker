package fr.efrei.judotrackerpro.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Categorie {
    @PrimaryKey
    private int id_categorie;

    private String sexe;
    private int poids_min;
    private int poids_max;

    public Categorie(int id_categorie, String sexe, int poids_min, int poids_max) {
        this.id_categorie = id_categorie;
        this.sexe = sexe;
        this.poids_min = poids_min;
        this.poids_max = poids_max;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public int getPoids_max() {
        return poids_max;
    }

    public String getSexe() {
        return sexe;
    }

    public int getPoids_min() {
        return poids_min;
    }
}
