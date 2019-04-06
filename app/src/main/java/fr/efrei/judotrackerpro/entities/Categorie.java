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

    public Categorie(int idCategorie, String sexe, int poids_min, int poidsMax) {
        this.id_categorie = idCategorie;
        this.sexe = sexe;
        this.poids_min = poids_min;
        this.poids_max = poidsMax;
    }

    public int getIdCategorie() {
        return id_categorie;
    }

    public String getSexe() {
        return sexe;
    }

    public int getPoids_min() {
        return poids_min;
    }

    public int getPoids_Max() {
        return poids_max;
    }
}
