package fr.efrei.judotrackerpro.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Localisation {
    @PrimaryKey
    private int id_localisation;

    private double longitude;
    private double latitude;

    public Localisation(int idLocalisation, double longitude, double latitude) {
        this.id_localisation = idLocalisation;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getIdLocalisation() {
        return id_localisation;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
