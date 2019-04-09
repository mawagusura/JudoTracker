package fr.efrei.judotrackerpro.back.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Localisation {
    @PrimaryKey(autoGenerate = true)
    private Integer id_localisation;

    private double longitude;
    private double latitude;

    public Localisation(Integer id_localisation, double longitude, double latitude) {
        this.id_localisation = id_localisation;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Ignore
    public Localisation(double longitude, double latitude) {
        this(null, longitude, latitude);
    }

    public Integer getId_localisation() {
        return id_localisation;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
