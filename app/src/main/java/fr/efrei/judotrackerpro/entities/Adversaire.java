package fr.efrei.judotrackerpro.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Adversaire {
    @PrimaryKey
    public int id_adversaire;

    public String nom_adversaire;
    public String prenom_adversaire;

    public Adversaire(int idAdversaire, String nomAdversaire, String prenomAdversaire) {
        this.id_adversaire = idAdversaire;
        this.nom_adversaire = nomAdversaire;
        this.prenom_adversaire = prenomAdversaire;
    }

    public int getIdAdversaire() {
        return id_adversaire;
    }

    public String getNomAdversaire() {
        return nom_adversaire;
    }

    public String getPrenomAdversaire() {
        return prenom_adversaire;
    }
}
