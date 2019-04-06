package fr.efrei.judotrackerpro.bdd;

import android.content.Context;

import java.util.List;

import androidx.room.Room;
import fr.efrei.judotrackerpro.entities.Adversaire;
import fr.efrei.judotrackerpro.entities.Categorie;
import fr.efrei.judotrackerpro.entities.Competition;
import fr.efrei.judotrackerpro.entities.Localisation;
import fr.efrei.judotrackerpro.entities.Match;
import fr.efrei.judotrackerpro.entities.Statistiques;

public class LocalDatabase {

    private static ConnectorDB bdd;

    public LocalDatabase(Context context) {
        this.bdd = Room.databaseBuilder(context, ConnectorDB.class, "judotracker").build();
    }

    public List<Competition> getAllCompetitions() {
        return bdd.competitionDao().getAll();
    }

    public List<Adversaire> getAllAdversaires() {
        return bdd.adversaireDao().getAll();
    }

    public List<Categorie> getAllCategories() {
        return bdd.categorieDao().getAll();
    }

    public List<Localisation> getAllLocalisations() {
        return bdd.localisationDao().getAll();
    }

    public List<Match> getAllMatchs() {
        return bdd.matchDao().getAll();
    }

    public List<Statistiques> getAllStatistiques() {
        return bdd.statistiquesDao().getAll();
    }

    public Adversaire getAdversaire(int idAdversaire) {
        return bdd.adversaireDao().getById(idAdversaire);
    }

    public Adversaire getAdversaireByMatch(Match match) {
        return bdd.adversaireDao().getById(match.getId_adversaire());
    }

    public Categorie getCategorie(int idCategorie) {
        return bdd.categorieDao().getById(idCategorie);
    }

    public List<Categorie> getCategorieBySexe(String sexe) {
        return bdd.categorieDao().getBySexe(sexe);
    }

    public Competition getCompetition(int idCompetition) {
        return bdd.competitionDao().getById(idCompetition);
    }

    public List<Competition> getCompetitionsByLocalisation(Localisation localisation) {
        return bdd.competitionDao().getByIdLocalisation(localisation.getIdLocalisation());
    }

    public List<Competition> getCompetitionsByCategorie(Categorie categorie) {
        return bdd.competitionDao().getByIdCategorie(categorie.getIdCategorie());
    }
}
