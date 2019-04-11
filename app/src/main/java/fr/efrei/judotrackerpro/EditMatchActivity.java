package fr.efrei.judotrackerpro;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import fr.efrei.judotrackerpro.back.bdd.LocalDatabase;
import fr.efrei.judotrackerpro.back.entities.Adversaire;
import fr.efrei.judotrackerpro.back.entities.Competition;
import fr.efrei.judotrackerpro.back.entities.Match;
import fr.efrei.judotrackerpro.back.entities.Statistiques;

import static java.lang.Math.toIntExact;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditMatchActivity extends AppCompatActivity {

    private Match match;
    private Competition competition;
    private LocalDatabase bdd;

    // Components
    private EditText nom_adv;
    private EditText prenom_adv;
    private EditText duree_match_min;
    private EditText duree_match_sec;
    private EditText ippons_adv;
    private EditText wazaaris_adv;
    private EditText yukos_adv;
    private EditText ippons_user;
    private EditText wazaaris_user;
    private EditText yukos_user;
    private EditText penalites_adv;
    private EditText penalites_user;
    private Button validate_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_match);

        this.bdd = LocalDatabase.getInstance(getApplicationContext());

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle!=null){
            Integer competId = bundle.getInt("id_competition");
            if (competId != null) {
                this.competition = bdd.getCompetition(competId);
            }
        }

        nom_adv = (EditText) findViewById(R.id.edit_name);
        prenom_adv = (EditText) findViewById(R.id.edit_name2);
        duree_match_min = (EditText) findViewById(R.id.time_minuts_input);
        duree_match_sec = (EditText) findViewById(R.id.time_seconds_input);
        ippons_adv = (EditText) findViewById(R.id.ippons_adv_input);
        wazaaris_adv = (EditText) findViewById(R.id.wazaaris_adv_input);
        yukos_adv = (EditText) findViewById(R.id.yukos_adv_input);
        ippons_user = (EditText) findViewById(R.id.ippons_user_input);
        wazaaris_user = (EditText) findViewById(R.id.wazaaris_user_input);
        yukos_user = (EditText) findViewById(R.id.yukos_user_input);
        penalites_adv = (EditText) findViewById(R.id.penalites_adv_input);
        penalites_user = (EditText) findViewById(R.id.penalites_user_input);

        validate_btn = findViewById(R.id.validate_btn);

        validate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (nom_adv.getText().toString().isEmpty() || prenom_adv.getText().toString().isEmpty() || duree_match_min.getText().toString().isEmpty()
                        || duree_match_min.getText().toString().isEmpty() || duree_match_sec.getText().toString().isEmpty()
                        || ippons_adv.getText().toString().isEmpty() || wazaaris_adv.getText().toString().isEmpty()
                        || yukos_adv.getText().toString().isEmpty() || ippons_user.getText().toString().isEmpty()
                        || wazaaris_user.getText().toString().isEmpty() || yukos_user.getText().toString().isEmpty()
                        || penalites_adv.getText().toString().isEmpty() || penalites_user.getText().toString().isEmpty()
                ) {
                    Toast.makeText(EditMatchActivity.this,"Veuillez rentrer tous les champs.", Toast.LENGTH_LONG).show();
                }
                else {

                    String nom_adversaire = nom_adv.getText().toString();
                    String prenom_adversaire = prenom_adv.getText().toString();

                    // Création de l'adversaire ou récupération si existe
                    Adversaire adversaire;
                    if (bdd.getAdversaireByNomPrenom(nom_adversaire, prenom_adversaire).isEmpty()) {
                        adversaire = new Adversaire(nom_adversaire, prenom_adversaire);
                        long id_adv = bdd.insertAdversaire(adversaire);
                    }
                    adversaire = bdd.getAdversaireByNomPrenom(nom_adversaire, prenom_adversaire).get(0);

                    // Création des statistiques du match

                    int duree = Integer.parseInt(duree_match_min.getText().toString()) * 60
                            + Integer.parseInt(duree_match_sec.getText().toString());
                    int ipponsUtilisateur = Integer.parseInt(ippons_user.getText().toString());
                    int wazaarisUtilisateur = Integer.parseInt(wazaaris_user.getText().toString());
                    int yukosUtilisateur = Integer.parseInt(yukos_user.getText().toString());
                    int ipponsAdv = Integer.parseInt(ippons_adv.getText().toString());
                    int wazaarisAdv = Integer.parseInt(wazaaris_adv.getText().toString());
                    int yukosAdv = Integer.parseInt(yukos_adv.getText().toString());
                    int penalitesUtilisateur = Integer.parseInt(penalites_user.getText().toString());
                    int penalitesAdv = Integer.parseInt(penalites_adv.getText().toString());

                    Statistiques statistiques = new Statistiques(duree, ipponsUtilisateur, wazaarisUtilisateur,
                            yukosUtilisateur, ipponsAdv, wazaarisAdv, yukosAdv, penalitesUtilisateur, penalitesAdv);
                    long id_statistiques = bdd.insertStatistiques(statistiques);
                    

                    // Création du match
                    Match match = new Match(EditMatchActivity.this.competition, adversaire, statistiques);
                    long idMatch = bdd.insertMatch(match);

                    // Lancement affichage match
                    Intent i = new Intent(EditMatchActivity.this, MatchActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("id_match", (int) idMatch);
                    i.putExtras(b);
                    finish();
                    startActivity(i);

                }
            }
        });

    }

}
