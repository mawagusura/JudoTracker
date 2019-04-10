package fr.efrei.judotrackerpro.back.entities;

import java.util.Date;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = Categorie.class,
            parentColumns = "id_categorie",
            childColumns = "id_categorie",
                onDelete=CASCADE
        ),
        @ForeignKey(
            entity = Localisation.class,
            parentColumns = "id_localisation",
            childColumns = "id_localisation",
            onDelete=CASCADE
        )
    })

public class Competition {
    @PrimaryKey(autoGenerate = true)
    private Integer id_competition;

    private Integer id_categorie;
    private Integer id_localisation;
    private Date date_competition;
    private String nom_competition;

    public Competition(Integer id_competition, Integer id_categorie, Integer id_localisation, Date date_competition, String nom_competition) {
        this.id_competition = id_competition;
        this.id_categorie = id_categorie;
        this.id_localisation = id_localisation;
        this.date_competition = date_competition;
        this.nom_competition = nom_competition;
    }

    @Ignore
    public Competition(Integer id_categorie, Integer id_localisation, Date date_competition, String nom_competition) {
        this(null, id_categorie, id_localisation, date_competition, nom_competition);
    }

    @Ignore
    public Competition(String nom_competition, Date date_competition) {
        this(null, null, null, date_competition, nom_competition);
    }

    @Ignore
    public Competition(String nom_competition, Categorie categorie, Date date_competition) {
        this(null, categorie.getId_categorie(), null, date_competition, nom_competition);
    }

    @Ignore
    public Competition(String nom_competition, Categorie categorie, Localisation localisation, Date date_competition) {
        this(null, categorie.getId_categorie(), localisation.getId_localisation(), date_competition, nom_competition);
    }


    @Ignore
    public Competition(String nom_competition, Localisation localisation, Date date_competition) {
        this(null, localisation.getId_localisation(), localisation.getId_localisation(), date_competition, nom_competition);
    }

    public Integer getId_competition() {
        return id_competition;
    }

    public Integer getId_categorie() {
        return id_categorie;
    }

    public Integer getId_localisation() {
        return id_localisation;
    }

    public Date getDate_competition() {
        return date_competition;
    }

    public String getNom_competition() {
        return nom_competition;
    }

    public void setCategorie(Categorie categorie) {
        this.id_categorie = categorie.getId_categorie();
    }

    public void setLocalisation(Localisation localisation) {
        this.id_localisation = localisation.getId_localisation();
    }

    public void setNom_competition(String nom_competition){
        this.nom_competition = nom_competition;
    }

    public void setDate_competition(Date date_competition){
        this.date_competition = date_competition;
    }
}
