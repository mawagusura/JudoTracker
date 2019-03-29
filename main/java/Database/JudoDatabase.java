package Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class JudoDatabase extends SQLiteOpenHelper {

    private static final String TABLE_MATCHS = "Matchs";
    private static final String COL_ID_MATCH = "match_id";
    private static final String COL_DATE_MATCH = "match_date";
    private static final String COL_FK_MATCH_LOCALISATION = "match_localisation";
    private static final String COL_FK_MATCH_STATS = "match_stats";
    private static final String COL_FK_MATCH_CATEGORIE = "match_categorie";
    private static final String COL_FK_MATCH_ADVERSAIRE = "match_adversaire";

    private static final String TABLE_LOCALISATIONS = "Localisations";
    private static final String COL_ID_LOCALISATION = "localisation_id";
    private static final String COL_LATITUDE = "latitude";
    private static final String COL_LONGITUDE = "longitude";

    private static final String TABLE_STATS = "Statistiques";
    private static final String COL_ID_STATS = "stats_id";
    private static final String COL_IPPONS_U = "ippons_u";
    private static final String COL_WAZAARI_U = "wazaari_u";
    private static final String COL_YUKO_U = "yuko_u";
    private static final String COL_IPPONS_ADV = "ippons_adv";
    private static final String COL_WAZAARI_ADV = "wazaari_adv";
    private static final String COL_YUKO_ADV = "yuko_adv";
    private static final String COL_PENALITES_U = "penalites_u";
    private static final String COL_PENALITES_ADV = "penalites_adv";

    private static final String TABLE_CATEGORIE = "Categories";
    private static final String COL_ID_CATEGORIE = "categorie_id";
    private static final String COL_SEXE_CATEGORIE = "categorie_sexe";
    private static final String COL_POIDS_MIN_CATEGORIE = "categorie_poids_min";
    private static final String COL_POIDS_MAX_CATEGORIE = "categorie_poids_max";

    private static final String TABLE_ADVERSAIRES = "Adversaires";
    private static final String COL_ID_ADVERSAIRE = "adversaire_id";
    private static final String COL_NOM_ADVERSAIRE = "adversaire_nom";
    private static final String COL_PRENOM_ADVERSAIRE = "adversaire_prenom";

    private static final String CREATE_TABLE_ADVERSAIRES = ""
            + "CREATE TABLE " + TABLE_ADVERSAIRES + " ("
            + COL_ID_ADVERSAIRE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_SEXE_CATEGORIE + " INTEGER NOT NULL, "
            + COL_NOM_ADVERSAIRE + " INTEGER NOT NULL, "
            + COL_PRENOM_ADVERSAIRE + " TEXT NOT NULL "
            + ");";

    private static final String CREATE_TABLE_CATEGORIE = ""
            + "CREATE TABLE " + TABLE_CATEGORIE + " ("
            + COL_ID_CATEGORIE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_SEXE_CATEGORIE + " INTEGER NOT NULL, "
            + COL_POIDS_MIN_CATEGORIE + " REAL NOT NULL, "
            + COL_POIDS_MAX_CATEGORIE + " REAL NOT NULL "
            + ");";

    private static final String CREATE_TABLE_STATS = ""
            + "CREATE TABLE " + TABLE_STATS + " ("
            + COL_ID_STATS + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_IPPONS_U + " INTEGER NOT NULL, "
            + COL_WAZAARI_U + " INTEGER NOT NULL "
            + COL_YUKO_U + " INTEGER NOT NULL, "
            + COL_IPPONS_ADV + " INTEGER NOT NULL, "
            + COL_WAZAARI_ADV + " INTEGER NOT NULL, "
            + COL_YUKO_ADV + " INTEGER NOT NULL"
            + COL_PENALITES_U + " INTEGER NOT NULL, "
            + COL_PENALITES_ADV + " INTEGER NOT NULL, "
            + ");";

    private static final String CREATE_TABLE_LOCALISATIONS = ""
            + "CREATE TABLE " + TABLE_LOCALISATIONS + " ("
            + COL_ID_STATS + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_LATITUDE + " REAL NOT NULL, "
            + COL_LONGITUDE + " REAL NOT NULL "
            + ");";

    private static final String CREATE_TABLE_MATCHS = "CREATE TABLE " + TABLE_MATCHS + " ("
            + COL_ID_MATCH + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_DATE_MATCH + " INTEGER NOT NULL, " // Pas de Date en SQLite, ce sera donc une date sous forme de timestamp
            + "FOREIGN KEY(" + COL_FK_MATCH_LOCALISATION + ") REFERENCES " +  TABLE_LOCALISATIONS +"(" + COL_ID_LOCALISATION + "), "
            + "FOREIGN KEY(" + COL_FK_MATCH_STATS + ") REFERENCES " + TABLE_STATS + "(" + COL_ID_STATS + "), "
            + "FOREIGN KEY(" + COL_FK_MATCH_CATEGORIE + ") REFERENCES " + TABLE_CATEGORIE + "(" + COL_ID_CATEGORIE + "), "
            + "FOREIGN KEY(" + COL_FK_MATCH_ADVERSAIRE + ") REFERENCES " + TABLE_ADVERSAIRES + "(" + COL_ID_ADVERSAIRE + ")"
            + ");"
            ;

    public JudoDatabase(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ADVERSAIRES);
        db.execSQL(CREATE_TABLE_CATEGORIE);
        db.execSQL(CREATE_TABLE_STATS);
        db.execSQL(CREATE_TABLE_LOCALISATIONS);
        db.execSQL(CREATE_TABLE_MATCHS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_ADVERSAIRES + ";");
        db.execSQL("DROP TABLE " + TABLE_CATEGORIE + ";");
        db.execSQL("DROP TABLE " + TABLE_STATS + ";");
        db.execSQL("DROP TABLE " + TABLE_LOCALISATIONS + ";");
        db.execSQL("DROP TABLE " + TABLE_MATCHS + ";");
        onCreate(db);
    }
}
