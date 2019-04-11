package fr.efrei.judotrackerpro.back.bdd;

import android.content.Context;

import java.util.List;

import androidx.room.Room;
import fr.efrei.judotrackerpro.back.entities.Adversaire;
import fr.efrei.judotrackerpro.back.entities.Categorie;
import fr.efrei.judotrackerpro.back.entities.Competition;
import fr.efrei.judotrackerpro.back.entities.Localisation;
import fr.efrei.judotrackerpro.back.entities.Match;
import fr.efrei.judotrackerpro.back.entities.Statistiques;

public class LocalDatabase {

    private static ConnectorDB bdd;

    private static LocalDatabase INSTANCE = null;

    private LocalDatabase(Context context) {
        this.bdd = Room.databaseBuilder(context, ConnectorDB.class, "judotracker2").fallbackToDestructiveMigration().allowMainThreadQueries().build();
    }

    public static LocalDatabase getInstance(Context context)
    {
        if (INSTANCE == null)
        {
            INSTANCE = new LocalDatabase(context);
        }
        return INSTANCE;
    }

    // GETTERS --------------------------------------------------

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

    public List<Adversaire> getAdversaireByNom(String nom) {
        return bdd.adversaireDao().getByNom(nom);
    }

    public List<Adversaire> getAdversaireByPrenom(String prenom) {
        return bdd.adversaireDao().getByNom(prenom);
    }

    public List<Adversaire> getAdversaireByNomPrenom(String nom, String prenom) {
        return bdd.adversaireDao().getByNomPrenom(nom, prenom);
    }

    public Adversaire getAdversaireByMatch(Match match) {
        return bdd.adversaireDao().getById(match.getId_adversaire());
    }

    public Categorie getCategorie(Integer idCategorie) {
        return bdd.categorieDao().getById(idCategorie);
    }

    public List<Categorie> getCategorieBySexe(String sexe) {
        return bdd.categorieDao().getBySexe(sexe);
    }

    public Competition getCompetition(int idCompetition) {
        return bdd.competitionDao().getById(idCompetition);
    }

    public Competition getCompetitionByNom(String nom) {
        return bdd.competitionDao().getByNom(nom);
    }

    public List<Competition> getCompetitionsByLocalisation(Localisation localisation) {
        return bdd.competitionDao().getByIdLocalisation(localisation.getId_localisation());
    }

    public List<Competition> getCompetitionsByCategorie(Categorie categorie) {
        return bdd.competitionDao().getByIdCategorie(categorie.getId_categorie());
    }

    public Competition getCompetitionByMatch(Match match) {
        return bdd.competitionDao().getById(
                bdd.matchDao().getById(match.getId_match()).getId_competition()
        );
    }

    public Localisation getLocalisation(Integer idLocalisation){
        return bdd.localisationDao().getById(idLocalisation);
    }

    public Localisation getLocalisationCompetition(Competition compet){
        return bdd.localisationDao().getById(bdd.competitionDao().getById(compet.getId_competition()).getId_localisation());
    }

    public Match getMatch(int idMatch) {
        return bdd.matchDao().getById(idMatch);
    }

    public List<Match> getMatchByCompetition(Competition competition) {
        return bdd.matchDao().getByIdCompetition(competition.getId_competition());
    }

    public Match getMatchByStatistiques(Statistiques stats) {
        return bdd.matchDao().getByIdStatistiques(stats.getId_stats());
    }

    public Categorie getCategorieByMatch(Match match) {
        return bdd.categorieDao().getById(
                bdd.competitionDao().getById(
                        match.getId_competition()
                ).getId_categorie()
        );
    }

    public Statistiques getStatistiques(Match match) {
        return bdd.statistiquesDao().getById(match.getId_stats());
    }

    public Statistiques getStatistiques(Integer id_stats) {
        return bdd.statistiquesDao().getById(id_stats);
    }

    // UPDATERS --------------------------------------------------

    public void updateAdversaire(Adversaire adversaire) {
        bdd.adversaireDao().update(adversaire);
    }

    public void updateAdversaires(List<Adversaire> adversaire) {
        bdd.adversaireDao().updateAll(adversaire);
    }

    public void updateCategorie(Categorie categorie) {
        bdd.categorieDao().update(categorie);
    }

    public void updateCategories(List<Categorie> categorie) {
        bdd.categorieDao().updateAll(categorie);
    }

    public void updateCompetition(Competition competition) {
        bdd.competitionDao().update(competition);
    }

    public void updateCompetitions(List<Competition> competition) {
        bdd.competitionDao().updateAll(competition);
    }

    public void updateLocalisation(Localisation localisation) {
        bdd.localisationDao().update(localisation);
    }

    public void updateLocalisations(List<Localisation> localisation) {
        bdd.localisationDao().updateAll(localisation);
    }

    public void updateMatch(Match match) {
        bdd.matchDao().update(match);
    }

    public void updateMatchs(List<Match> match) {
        bdd.matchDao().updateAll(match);
    }

    public void updateStatistiques(Statistiques statistiques) {
        bdd.statistiquesDao().update(statistiques);
    }

    public void updateStatistiques(List<Statistiques> statistiques) {
        bdd.statistiquesDao().updateAll(statistiques);
    }

    // DELETERS ----------------------------------------------

    public void deleteMatch(Match match) {
        bdd.matchDao().delete(match);
    }

    public void deleteCompetition(Competition compet) {
        bdd.competitionDao().delete(compet);
    }

    // INSERTS -----------------------------------------------

    public long insertAdversaire(Adversaire adv) {
        return bdd.adversaireDao().insert(adv);
    }

    public long[] insertAdversaireAll(List<Adversaire> adv) {
        return bdd.adversaireDao().insertAll(adv);
    }

    public long insertCategorie(Categorie cat) {
        return bdd.categorieDao().insert(cat);
    }

    public long[] insertCategorieAll(List<Categorie> categories) {
        return bdd.categorieDao().insertAll(categories);
    }

    public long insertCompetition(Competition compet) {
        return bdd.competitionDao().insert(compet);
    }

    public long[] insertCompetitionAll(List<Competition> compet) {
        return bdd.competitionDao().insertAll(compet);
    }

    public long insertLocalisation(Localisation localisation) {
        return bdd.localisationDao().insert(localisation);
    }

    public long[] insertLocalisationAll(List<Localisation> localisation) {
        return bdd.localisationDao().insertAll(localisation);
    }

    public long insertMatch(Match match) {
        return bdd.matchDao().insert(match);
    }

    public long[] insertMatchAll(List<Match> match) {
        return bdd.matchDao().insertAll(match);
    }

    public long insertStatistiques(Statistiques stats) {
        return  bdd.statistiquesDao().insert(stats);
    }

    public long[] insertStatistiquesAll(List<Statistiques> stats) {
        return bdd.statistiquesDao().insertAll(stats);
    }


}
