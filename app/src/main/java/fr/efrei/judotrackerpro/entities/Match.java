package fr.efrei.judotrackerpro.entities;

import java.util.Date;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
        foreignKeys = {
                @ForeignKey(
                        entity = Statistiques.class,
                        parentColumns = "id_statistiques",
                        childColumns = "id_match"
                ),
                @ForeignKey(
                        entity = Adversaire.class,
                        parentColumns = "id_adversaire",
                        childColumns = "id_match"
                )
        })
public class Match {
    @PrimaryKey
    private int id_match;

    private int id_statistiques;
    private int id_adversaire;

    public Match(int id_match, int id_statistiques, int id_adversaire) {
        this.id_match = id_match;
        this.id_statistiques = id_statistiques;
        this.id_adversaire = id_adversaire;
    }

    public int getId_match() {
        return id_match;
    }

    public int getId_statistiques() {
        return id_statistiques;
    }

    public int getId_adversaire() {
        return id_adversaire;
    }
}
