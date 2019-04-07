package fr.efrei.judotrackerpro.back.entities;

import java.util.Date;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = Categorie.class,
            parentColumns = "id_categorie",
            childColumns = "id_competition"
        ),
        @ForeignKey(
            entity = Localisation.class,
            parentColumns = "id_localisation",
            childColumns = "id_competition"
        )
    })

public class Competition {
    @PrimaryKey
    private int id_competition;

    private int id_categorie;
    private int id_localisation;
    private Date date_competition;
    private String nom_competition;

    public Competition(int id_competition, String nom_competition, Categorie categorie, Localisation localisation, Date date_competition) {
        this.id_competition = id_competition;
        this.id_categorie = categorie.getId_categorie();
        this.id_localisation = localisation.getId_localisation();
        this.date_competition = date_competition;
        this.nom_competition = nom_competition;
    }

    public Competition(int id_competition, String nom_competition, int id_categorie, int id_localisation, Date date_competition) {
        this.id_competition = id_competition;
        this.nom_competition = nom_competition;
        this.id_categorie = id_categorie;
        this.id_localisation = id_localisation;
        this.date_competition = date_competition;
    }

    public Competition(String nom, Categorie categorie, Date date_competition) {
        this.nom_competition = nom;
        this.id_categorie = categorie.getId_categorie();
        this.date_competition = date_competition;
    }

    public Competition(String nom, int id_categorie, Date date_competition) {
        this.nom_competition = nom;
        this.id_categorie = id_categorie;
        this.date_competition = date_competition;
    }

    public int getId_competition() {
        return id_competition;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public int getId_localisation() {
        return id_localisation;
    }

    public Date getDate_competition() {
        return date_competition;
    }

    public String getNom_competition() {
        return nom_competition;
    }
}
