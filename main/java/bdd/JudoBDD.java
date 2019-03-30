package bdd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import judotrackerpro.*;


public class JudoBDD {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "judotracker";

    private SQLiteDatabase bdd;
    private SetupBDD setupBDD;

    public JudoBDD(Context context){
        //On crée la BDD et sa table
        setupBDD = new SetupBDD(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open(){
        //on ouvre la BDD en écriture
        bdd = setupBDD.getWritableDatabase();
    }

    public void close(){
        //on ferme l'accès à la BDD
        bdd.close();
    }

    public SQLiteDatabase getBDD(){
        return bdd;
    }

    public long insertMatch(Match match) {
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(setupBDD.COL_DATE_MATCH, match.getDateMatch().getTime());
        values.put(setupBDD.COL_FK_MATCH_LOCALISATION, match.getLocalisation().getIdLocalisation());
        values.put(setupBDD.COL_FK_MATCH_STATS, match.getStatistiques().getIdStats());
        values.put(setupBDD.COL_FK_MATCH_CATEGORIE, match.getCategorie().getIdCategorie());
        values.put(setupBDD.COL_FK_MATCH_ADVERSAIRE, match.getAdversaire().getIdAdversaire());
        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(setupBDD.TABLE_MATCHS, null, values);
    }

    public long insertLocalisation(Localisation localisation) {
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(setupBDD.COL_LATITUDE, localisation.getLatitude());
        values.put(setupBDD.COL_LONGITUDE, localisation.getLongitude());
        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(setupBDD.TABLE_LOCALISATIONS, null, values);
    }

    public long insertLocalisation(Statistiques statistiques) {
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(setupBDD.COL_IPPONS_U, statistiques.getIpponsUtilisateur());
        values.put(setupBDD.COL_WAZAARI_U, statistiques.getWazaariUtilisateur());
        values.put(setupBDD.COL_YUKO_U, statistiques.getYukoUtilisateur());
        values.put(setupBDD.COL_IPPONS_ADV, statistiques.getIpponsAdv());
        values.put(setupBDD.COL_WAZAARI_ADV, statistiques.getWazaartAdv());
        values.put(setupBDD.COL_YUKO_ADV, statistiques.getYukoAdv());
        values.put(setupBDD.COL_PENALITES_U, statistiques.getPenalitesUtilisateur());
        values.put(setupBDD.COL_PENALITES_ADV, statistiques.getPenalitesAdv());
        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(setupBDD.TABLE_LOCALISATIONS, null, values);
    }

    public long insertCategorie(Categorie categorie) {
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(setupBDD.COL_SEXE_CATEGORIE, categorie.getSexe().name());
        values.put(setupBDD.COL_POIDS_MIN_CATEGORIE, categorie.getPoidsMin());
        values.put(setupBDD.COL_POIDS_MAX_CATEGORIE, categorie.getPoidsMax());
        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(setupBDD.TABLE_CATEGORIE, null, values);
    }
}
