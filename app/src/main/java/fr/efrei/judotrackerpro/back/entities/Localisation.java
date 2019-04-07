package fr.efrei.judotrackerpro.back.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Localisation {
    @PrimaryKey
    private int id_localisation;

    private double longitude;
    private double latitude;

    public Localisation(int id_localisation, double longitude, double latitude) {
        this.id_localisation = id_localisation;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getId_localisation() {
        return id_localisation;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
