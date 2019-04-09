package fr.efrei.judotrackerpro.back.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(
        foreignKeys = {
                @ForeignKey(
                        entity = Statistiques.class,
                        parentColumns = "id_stats",
                        childColumns = "id_stats",
                        onDelete=CASCADE
                ),
                @ForeignKey(
                        entity = Adversaire.class,
                        parentColumns = "id_adversaire",
                        childColumns = "id_adversaire",
                        onDelete=CASCADE
                ),
                @ForeignKey(
                        entity = Competition.class,
                        parentColumns = "id_competition",
                        childColumns = "id_competition",
                        onDelete=CASCADE
                ),

        })
public class Match {
    @PrimaryKey(autoGenerate = true)
    private Integer id_match;

    private Integer id_stats;
    private Integer id_adversaire;
    private Integer id_competition;

    public Match(Integer id_match, Integer id_stats, Integer id_adversaire, Integer id_competition) {
        this.id_match = id_match;
        this.id_stats = id_stats;
        this.id_adversaire = id_adversaire;
        this.id_competition = id_competition;
    }

    @Ignore
    public Match(Integer id_stats, Integer id_adversaire, Integer id_competition) {
        this(null, id_stats, id_adversaire, id_competition);
    }

    @Ignore
    public Match(Competition compet) {
        this(null, null, null, compet.getId_competition());
    }

    @Ignore
    public Match(Competition compet, Adversaire adv) {
        this(null, null, adv.getId_adversaire(), compet.getId_competition());
    }

    @Ignore
    public Match(Competition compet, Adversaire adv, Statistiques statistiques) {
        this(null, statistiques.getId_stats(), adv.getId_adversaire(), compet.getId_competition());
    }

    @Ignore
    public Match(Competition compet, Statistiques statistiques) {
        this(null, statistiques.getId_stats(), null, compet.getId_competition());
    }

    @Ignore
    public Match() {
        this(null, null, null, null);
    }

    public Integer getId_match() {
        return id_match;
    }

    public Integer getId_stats() {
        return id_stats;
    }

    public Integer getId_adversaire() {
        return id_adversaire;
    }

    public Integer getId_competition() {
        return id_competition;
    }

    public void setStatistiques(Statistiques stats) {
        this.id_stats = stats.getId_stats();
    }

    public void setAdversaire(Adversaire adversaire) {
        this.id_adversaire = adversaire.getId_adversaire();
    }

    public void setCompetition(Competition competition) {
        this.id_competition = competition.getId_competition();
    }
}
