package fr.efrei.judotrackerpro.entities;

import java.util.Date;

import androidx.room.ColumnInfo;
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
    @ColumnInfo(name = "id_competition")
    private int idCompet;

    @ColumnInfo(name = "id_categorie")
    private int idCategorie;

    @ColumnInfo(name = "id_localisation")
    private int idLocalisation;

    @ColumnInfo(name = "date_competition")
    private Date dateCompet;

    public Competition(int idCompet, Categorie categorie, Localisation localisation, Date dateCompet) {
        this.idCompet = idCompet;
        this.idLocalisation = categorie.getIdCategorie();
        this.idLocalisation = localisation.getIdLocalisation();
        this.dateCompet = dateCompet;
    }

    public int getIdCompet() {
        return idCompet;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public int getIdLocalisation() {
        return idLocalisation;
    }

    public Date getDateCompet() {
        return dateCompet;
    }
}
