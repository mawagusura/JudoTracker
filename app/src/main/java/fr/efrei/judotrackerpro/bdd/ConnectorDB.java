package fr.efrei.judotrackerpro.bdd;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import fr.efrei.judotrackerpro.dao.AdversaireDAO;
import fr.efrei.judotrackerpro.dao.CategorieDAO;
import fr.efrei.judotrackerpro.dao.CompetitionDAO;
import fr.efrei.judotrackerpro.dao.LocalisationDAO;
import fr.efrei.judotrackerpro.dao.MatchDAO;
import fr.efrei.judotrackerpro.dao.StatistiquesDAO;
import fr.efrei.judotrackerpro.entities.Adversaire;
import fr.efrei.judotrackerpro.entities.Categorie;
import fr.efrei.judotrackerpro.entities.Competition;
import fr.efrei.judotrackerpro.entities.Localisation;
import fr.efrei.judotrackerpro.entities.Match;
import fr.efrei.judotrackerpro.entities.Statistiques;
import fr.efrei.judotrackerpro.utilities.Converters;

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

