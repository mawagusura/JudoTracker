package judotrackerpro;

class Categorie {
    private int idCategorie;

    private Sexe sexe;
    private int poidsMin, poidsMax;

    public Categorie(int idCategorie, Sexe sexe, int poidsMin, int poidsMax) {
        this.idCategorie = idCategorie;
        // 0 = Homme, 1 = Femme
        this.sexe = sexe;
        this.poidsMin = poidsMin;
        this.poidsMax = poidsMax;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public int getPoidsMin() {
        return poidsMin;
    }

    public int getPoidsMax() {
        return poidsMax;
    }
}
