package fr.efrei.judotrackerpro;

import androidx.appcompat.app.AppCompatActivity;
import fr.efrei.judotrackerpro.back.bdd.LocalDatabase;
import fr.efrei.judotrackerpro.back.entities.Adversaire;
import fr.efrei.judotrackerpro.back.entities.Competition;
import fr.efrei.judotrackerpro.back.entities.Match;
import fr.efrei.judotrackerpro.back.entities.Statistiques;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {

    private Match match;
    private Competition competition;
    private LocalDatabase bdd;

    // Components
    private TextView nom_adv;
    private TextView prenom_adv;
    private TextView duree_match_min;
    private TextView duree_match_sec;
    private TextView ippons_adv;
    private TextView wazaaris_adv;
    private TextView yukos_adv;
    private TextView ippons_user;
    private TextView wazaaris_user;
    private TextView yukos_user;
    private TextView penalites_adv;
    private TextView penalites_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        this.bdd = LocalDatabase.getInstance(getApplicationContext());

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle!=null){
            Integer matchId = bundle.getInt("id_match");
            if (matchId != null) {
                this.match = bdd.getMatch(matchId);
            }
        }

        Adversaire adversaire = bdd.getAdversaire(match.getId_adversaire());
        Statistiques stats = bdd.getStatistiques(match);

        nom_adv = (TextView) findViewById(R.id.edit_name);
        prenom_adv = (TextView) findViewById(R.id.edit_name2);
        duree_match_min = (TextView) findViewById(R.id.time_minuts_input);
        duree_match_sec = (TextView) findViewById(R.id.time_seconds_input);
        ippons_adv = (TextView) findViewById(R.id.ippons_adv_input);
        wazaaris_adv = (TextView) findViewById(R.id.wazaaris_adv_input);
        yukos_adv = (TextView) findViewById(R.id.yukos_adv_input);
        ippons_user = (TextView) findViewById(R.id.ippons_user_input);
        wazaaris_user = (TextView) findViewById(R.id.wazaaris_user_input);
        yukos_user = (TextView) findViewById(R.id.yukos_user_input);
        penalites_adv = (TextView) findViewById(R.id.penalites_adv_input);
        penalites_user = (TextView) findViewById(R.id.penalites_user_input);

        // Remplissage de tous les champs
        nom_adv.setText(adversaire.getNomAdversaire());
        prenom_adv.setText(adversaire.getPrenomAdversaire());
        duree_match_min.setText(stats.getDuree_match() / 60);
        duree_match_sec.setText(stats.getDuree_match() % 60);
        ippons_adv.setText(stats.getIpponsAdv());
        wazaaris_adv.setText(stats.getWazaariAdv());
        yukos_adv.setText(stats.getYukoAdv());
        ippons_user.setText(stats.getIpponsUtilisateur());
        wazaaris_user.setText(stats.getWazaariUtilisateur());
        yukos_user.setText(stats.getYukoUtilisateur());
        penalites_adv.setText(stats.getPenalitesAdv());
        penalites_user.setText(stats.getPenalitesUtilisateur());


    }
}
