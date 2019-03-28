package judotrackerpro;

class Localisation {
    private int idLocalisation;
    private String Ville;
    private double longitude, latitude;

    public Localisation(int idLocalisation, String ville, double longitude, double latitude) {
        this.idLocalisation = idLocalisation;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getIdLocalisation() {
        return idLocalisation;
    }

    public String getVille() {
        return Ville;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
