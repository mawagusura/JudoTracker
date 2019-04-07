package fr.efrei.judotrackerpro.back.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
        foreignKeys = {
                @ForeignKey(
                        entity = Statistiques.class,
                        parentColumns = "id_stats",
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

    private int id_stats;
    private int id_adversaire;

    public Match(int id_match, int id_stats, int id_adversaire) {
        this.id_match = id_match;
        this.id_stats = id_stats;
        this.id_adversaire = id_adversaire;
    }

    public int getId_match() {
        return id_match;
    }

    public int getId_stats() {
        return id_stats;
    }

    public int getId_adversaire() {
        return id_adversaire;
    }
}
