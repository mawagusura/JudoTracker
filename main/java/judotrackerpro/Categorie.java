package judotrackerpro;

public class Categorie {
    private int idCategorie;
    private Sexe sexe;
    private int poidsMin, poidsMax;

    public Categorie(int idCategorie, String sexe, int poidsMin, int poidsMax) {
        this.idCategorie = idCategorie;
        this.sexe = Enum.valueOf(Sexe.class, sexe);
        this.poidsMin = poidsMin;
        this.poidsMax = poidsMax;
    }

    public int getIdCategorie() {
        return idCategorie;
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
