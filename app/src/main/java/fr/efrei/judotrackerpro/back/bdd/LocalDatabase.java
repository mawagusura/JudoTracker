package fr.efrei.judotrackerpro.back.bdd;

import android.content.Context;

import java.util.List;

import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
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
        this.bdd = Room.databaseBuilder(context, ConnectorDB.class, "judotracker").allowMainThreadQueries().addMigrations(this.MIGRATION_1_2).build();
    }

    public static LocalDatabase getInstance(Context context)
    {
        if (INSTANCE == null)
        {   INSTANCE = new LocalDatabase(context);
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

    public List<Adversaire> getAdversaireByPrenom(String nom, String prenom) {
        return bdd.adversaireDao().getByNomPrenom(nom, prenom);
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

    public Localisation getLocalisation(int idLocalisation){
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

    // UPDATERS --------------------------------------------------

    public void updateAdversaire(Adversaire adversaire) {
        bdd.adversaireDao().update(adversaire);
    }

    public void updateAdversaires(Adversaire... adversaire) {
        bdd.adversaireDao().updateAll(adversaire);
    }

    public void updateCategorie(Categorie categorie) {
        bdd.categorieDao().update(categorie);
    }

    public void updateCategories(Categorie... categorie) {
        bdd.categorieDao().updateAll(categorie);
    }

    public void updateCompetition(Competition competition) {
        bdd.competitionDao().update(competition);
    }

    public void updateCompetitions(Competition... competition) {
        bdd.competitionDao().updateAll(competition);
    }

    public void updateLocalisation(Localisation localisation) {
        bdd.localisationDao().update(localisation);
    }

    public void updateLocalisations(Localisation... localisation) {
        bdd.localisationDao().updateAll(localisation);
    }

    public void updateMatch(Match match) {
        bdd.matchDao().update(match);
    }

    public void updateMatchs(Match... match) {
        bdd.matchDao().updateAll(match);
    }

    public void updateStatistiques(Statistiques statistiques) {
        bdd.statistiquesDao().update(statistiques);
    }

    public void updateStatistiques(Statistiques... statistiques) {
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

    public void insertAdversaire(Adversaire adv) {
        bdd.adversaireDao().insert(adv);
    }

    public void insertAdversaireAll(Adversaire... adv) {
        bdd.adversaireDao().insertAll(adv);
    }

    public void insertCategorie(Categorie cat) {
        bdd.categorieDao().insert(cat);
    }

    public void insertCategorieAll(Categorie... cat) {
        bdd.categorieDao().insertAll(cat);
    }

    public void insertCompetition(Competition compet) {
        bdd.competitionDao().insert(compet);
    }

    public void insertCompetitionAll(Competition... compet) {
        bdd.competitionDao().insertAll(compet);
    }

    public void insertLocalisation(Localisation localisation) {
        bdd.localisationDao().insert(localisation);
    }

    public void insertLocalisationAll(Localisation... localisation) {
        bdd.localisationDao().insertAll(localisation);
    }

    public void insertMatch(Match match) {
        bdd.matchDao().insert(match);
    }

    public void insertMatchAll(Match... match) {
        bdd.matchDao().insertAll(match);
    }

    public void insertStatistiques(Statistiques stats) {
        bdd.statistiquesDao().insert(stats);
    }

    public void insertStatistiquesAll(Statistiques... stats) {
        bdd.statistiquesDao().insertAll(stats);
    }


    // Migrations

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE competition "
                    + " ADD COLUMN nom_competition TEXT");
        }
    };


}
