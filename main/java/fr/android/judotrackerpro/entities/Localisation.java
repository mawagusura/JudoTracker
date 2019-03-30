package fr.android.judotrackerpro.entities;

public class Localisation {
    private int idLocalisation;
    private double longitude, latitude;

    public Localisation(int idLocalisation, double longitude, double latitude) {
        this.idLocalisation = idLocalisation;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getIdLocalisation() {
        return idLocalisation;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
