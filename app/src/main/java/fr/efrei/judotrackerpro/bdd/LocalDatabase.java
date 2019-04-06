package fr.efrei.judotrackerpro.bdd;

import android.content.Context;

import java.util.List;

import androidx.room.Room;
import fr.efrei.judotrackerpro.entities.Competition;

public class LocalDatabase {

    // J'implémenterai ici tout le nécessaire pour récupérer les données dans les vues (pour pas interagir avec le DAOs direct dans les activity)

    ConnectorDB bdd;

    public LocalDatabase(Context context) {
        this.bdd = Room.databaseBuilder(context, ConnectorDB.class, "judotracker").build();
    }

    public List<Competition> getAllCompetitions() {
        return bdd.competitionDao().getAll();
    }

}
