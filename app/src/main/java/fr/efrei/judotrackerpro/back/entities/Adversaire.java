package fr.efrei.judotrackerpro.back.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Adversaire {
    @PrimaryKey
    public int id_adversaire;

    public String nom_adversaire;
    public String prenom_adversaire;

    public Adversaire(int id_adversaire, String nom_adversaire, String prenom_adversaire) {
        this.id_adversaire = id_adversaire;
        this.nom_adversaire = nom_adversaire;
        this.prenom_adversaire = prenom_adversaire;
    }

    public int getId_adversaire() {
        return id_adversaire;
    }

    public String getNomAdversaire() {
        return nom_adversaire;
    }

    public String getPrenomAdversaire() {
        return prenom_adversaire;
    }
}
