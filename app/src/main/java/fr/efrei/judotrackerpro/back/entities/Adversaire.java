package fr.efrei.judotrackerpro.back.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Adversaire {
    @PrimaryKey(autoGenerate = true)
    public Integer id_adversaire;

    public String nom_adversaire;
    public String prenom_adversaire;

    public Adversaire(Integer id_adversaire, String nom_adversaire, String prenom_adversaire) {
        this.id_adversaire = id_adversaire;
        this.nom_adversaire = nom_adversaire;
        this.prenom_adversaire = prenom_adversaire;
    }

    @Ignore
    public Adversaire(String nom, String prenom) {
        this(null, nom, prenom);
    }

    public Integer getId_adversaire() {
        return id_adversaire;
    }

    public String getNomAdversaire() {
        return nom_adversaire;
    }

    public String getPrenomAdversaire() {
        return prenom_adversaire;
    }


}
