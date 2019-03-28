package judotrackerpro;

import java.util.Date;

public class Match {
    private int idMatch;
    private Date dateMatch;

    private Localisation localisation;
    private Statistiques statistiques;
    private Adversaire adversaire;
    private Categorie categorie;

    public Match(int idMatch, Date dateMatch, Localisation localisation, Statistiques statistiques, Adversaire adversaire, Categorie categorie) {
        this.idMatch = idMatch;
        this.dateMatch = dateMatch;
        this.localisation = localisation;
        this.statistiques = statistiques;
        this.adversaire = adversaire;
        this.categorie = categorie;
    }

    public int getIdMatch() {
        return idMatch;
    }

    public Date getDateMatch() {
        return dateMatch;
    }

    public Localisation getLocalisation() {
        return localisation;
    }

    public Statistiques getStatistiques() {
        return statistiques;
    }

    public Adversaire getAdversaire() {
        return adversaire;
    }

    public Categorie getCategorie() {
        return categorie;
    }
}
