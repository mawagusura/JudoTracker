package fr.efrei.judotrackerpro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import fr.efrei.judotrackerpro.back.bdd.LocalDatabase;
import fr.efrei.judotrackerpro.back.entities.Adversaire;
import fr.efrei.judotrackerpro.back.entities.Competition;
import fr.efrei.judotrackerpro.back.entities.Match;
import fr.efrei.judotrackerpro.back.entities.Statistiques;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        duree_match_min.setText(Integer.toString(stats.getDuree_match() / 60));
        duree_match_sec.setText(Integer.toString(stats.getDuree_match() % 60));
        ippons_adv.setText(Integer.toString(stats.getIpponsAdv()));
        wazaaris_adv.setText(Integer.toString(stats.getWazaariAdv()));
        yukos_adv.setText(Integer.toString(stats.getYukoAdv()));
        ippons_user.setText(Integer.toString(stats.getIpponsUtilisateur()));
        wazaaris_user.setText(Integer.toString(stats.getWazaariUtilisateur()));
        yukos_user.setText(Integer.toString(stats.getYukoUtilisateur()));
        penalites_adv.setText(Integer.toString(stats.getPenalitesAdv()));
        penalites_user.setText(Integer.toString(stats.getPenalitesUtilisateur()));

        Toolbar appBar = findViewById(R.id.bar_edit_match);
        setSupportActionBar(appBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.match_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.edit_match:
                Intent i = new Intent(MatchActivity.this, EditMatchActivity.class);
                Bundle b = new Bundle();
                b.putInt("id_match",match.getId_match());
                i.putExtras(b);
                finish();
                startActivity(i);
                return true;
            case R.id.del_match:
                LocalDatabase.getInstance(getApplicationContext()).deleteMatch(match);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
