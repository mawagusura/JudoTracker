package fr.efrei.judotrackerpro.back.bdd;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import fr.efrei.judotrackerpro.back.dao.AdversaireDAO;
import fr.efrei.judotrackerpro.back.dao.CategorieDAO;
import fr.efrei.judotrackerpro.back.dao.CompetitionDAO;
import fr.efrei.judotrackerpro.back.dao.LocalisationDAO;
import fr.efrei.judotrackerpro.back.dao.MatchDAO;
import fr.efrei.judotrackerpro.back.dao.StatistiquesDAO;
import fr.efrei.judotrackerpro.back.entities.Adversaire;
import fr.efrei.judotrackerpro.back.entities.Categorie;
import fr.efrei.judotrackerpro.back.entities.Competition;
import fr.efrei.judotrackerpro.back.entities.Localisation;
import fr.efrei.judotrackerpro.back.entities.Match;
import fr.efrei.judotrackerpro.back.entities.Statistiques;
import fr.efrei.judotrackerpro.back.utilities.Converters;

@Database(entities = {Adversaire.class, Categorie.class, Competition.class, Localisation.class, Match.class, Statistiques.class}, version = 1,  exportSchema = false)
@TypeConverters({Converters.class})
public abstract class ConnectorDB extends RoomDatabase {

    public abstract AdversaireDAO adversaireDao();
    public abstract CategorieDAO categorieDao();
    public abstract CompetitionDAO competitionDao();
    public abstract LocalisationDAO localisationDao();
    public abstract MatchDAO matchDao();
    public abstract StatistiquesDAO statistiquesDao();

}

