package judotrackerpro;

public class Adversaire {
    public int idAdversaire;
    public String nomAdversaire, prenomAdversaire;

    public Adversaire(int idAdversaire, String nomAdversaire, String prenomAdversaire) {
        this.idAdversaire = idAdversaire;
        this.nomAdversaire = nomAdversaire;
        this.prenomAdversaire = prenomAdversaire;
    }

    public int getIdAdversaire() {
        return idAdversaire;
    }

    public String getNomAdversaire() {
        return nomAdversaire;
    }

    public String getPrenomAdversaire() {
        return prenomAdversaire;
    }
}
