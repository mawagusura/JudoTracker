package fr.efrei.judotrackerpro;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import fr.efrei.judotrackerpro.adapters.CompetAdapter;
import fr.efrei.judotrackerpro.back.bdd.LocalDatabase;
import fr.efrei.judotrackerpro.back.entities.Adversaire;
import fr.efrei.judotrackerpro.back.entities.Categorie;
import fr.efrei.judotrackerpro.back.entities.Competition;
import fr.efrei.judotrackerpro.back.entities.Localisation;
import fr.efrei.judotrackerpro.back.entities.Match;
import fr.efrei.judotrackerpro.back.entities.Statistiques;

public class MainActivity extends AppCompatActivity {

    BottomAppBar bottomAppBar;
    FloatingActionButton floatingActionButton;

    private RecyclerView recycler;

    private LocalDatabase bdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomAppBar = findViewById(R.id.bottomAppBar);
        setSupportActionBar(bottomAppBar);

        floatingActionButton = findViewById(R.id.addCateButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MainActivity.this, CompetitionActivity.class);
                Intent intent = new Intent(MainActivity.this, EditCompetActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        recycler = findViewById(R.id.compet_recycler);

        LinearLayoutManager llm = new LinearLayoutManager(MainActivity.this);
        recycler.setLayoutManager(llm);

        bdd = LocalDatabase.getInstance(getApplicationContext());
        //populateDB();

        //tempInsertCates();

    }

    @Override
    protected void onStart() {
        super.onStart();

        List<Competition> compets = bdd.getAllCompetitions();
        if(!compets.isEmpty()){
            CompetAdapter adapter = new CompetAdapter(compets);
            recycler.setAdapter(adapter);
        }
        else{
            Toast.makeText(this, "Aucune compétition n'existe pour le moment.", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case android.R.id.home :
                BottomNavDrawerFragment b = new BottomNavDrawerFragment();
                b.show(getSupportFragmentManager(), b.getTag());

        }

        return super.onOptionsItemSelected(item);
    }

    private void populateDB(){
        if (bdd.getAllMatchs().isEmpty() && bdd.getAllStatistiques().isEmpty() && bdd.getAllAdversaires().isEmpty()) {
            // Categories
            List<Categorie> cates = new ArrayList<>();
            cates.add(new Categorie(1,"Femme","-48kg"));
            cates.add(new Categorie(2,"Femme","-52kg"));
            cates.add(new Categorie(3,"Femme","-57kg"));
            cates.add(new Categorie(4,"Femme","-63kg"));
            cates.add(new Categorie(5,"Femme","-70kg"));
            cates.add(new Categorie(6,"Femme","-78kg"));
            cates.add(new Categorie(7,"Femme","+78kg"));
            cates.add(new Categorie(8,"Homme","-60kg"));
            cates.add(new Categorie(9,"Homme","-66kg"));
            cates.add(new Categorie(10,"Homme","-73kg"));
            cates.add(new Categorie(11,"Homme","-81kg"));
            cates.add(new Categorie(12,"Homme","-90kg"));
            cates.add(new Categorie(13,"Homme","-100kg"));
            cates.add(new Categorie(14,"Homme","+100kg"));
            bdd.insertCategorieAll(cates);

            // Adversaires
            List<Adversaire> adversaires = new ArrayList<>();
            adversaires.add(new Adversaire(1, "Hakman", "Guy"));
            adversaires.add(new Adversaire(2, "Poeli", "Arnaud"));
            adversaires.add(new Adversaire(3, "Melio", "Jean"));
            adversaires.add(new Adversaire(4, "Guillot", "Arthur"));
            adversaires.add(new Adversaire(5, "Hanou", "Vincent"));
            bdd.insertAdversaireAll(adversaires);

            // Localisations
            List<Localisation> localisations = new ArrayList<>();
            localisations.add(new Localisation(1, 2.6705562, 49.0779972));
            localisations.add(new Localisation(2, 3.0706414, 50.6305089));
            bdd.insertLocalisationAll(localisations);

            // Competitions
            List<Competition> competitions = new ArrayList<>();
            competitions.add(new Competition(1, 13, 1, new Date(1554076800), "Tournoi Othis"));
            competitions.add(new Competition(2, 14, 2, new Date(1551139200), "Tournoi Lille"));
            bdd.insertCompetitionAll(competitions);

            // Statistiques
            List<Statistiques> statistiques = new ArrayList<>();
            statistiques.add(new Statistiques(1, 190, 0,2, 0, 0, 0, 1,
                    0, 1));
            statistiques.add(new Statistiques(2, 167, 1,0, 1, 0, 1, 1,
                    0, 0));
            statistiques.add(new Statistiques(3, 169, 1,0, 1, 0, 1, 1,
                    0, 0));
            statistiques.add(new Statistiques(4, 135, 0,0, 1, 1, 1, 1,
                    0, 0));
            statistiques.add(new Statistiques(5, 167, 0,1, 0, 1, 1, 1,
                    2, 1));
            bdd.insertStatistiquesAll(statistiques);

            // Matchs
            List<Match> matchs = new ArrayList<>();
            matchs.add(new Match(1, 1, 1, 1));
            matchs.add(new Match(2, 2, 2, 2));
            matchs.add(new Match(3, 3, 3, 3));
            matchs.add(new Match(4, 4, 4, 4));
            matchs.add(new Match(5, 5, 5, 5));


            bdd.insertMatchAll(matchs);
        }
    }

    private void tempInsertCates(){
        List<Categorie> cates = new ArrayList<>();
        cates.add(new Categorie(1,"Femme","-48kg"));
        cates.add(new Categorie(2,"Femme","-52kg"));
        cates.add(new Categorie(3,"Femme","-57kg"));
        cates.add(new Categorie(4,"Femme","-63kg"));
        cates.add(new Categorie(5,"Femme","-70kg"));
        cates.add(new Categorie(6,"Femme","-78kg"));
        cates.add(new Categorie(7,"Femme","+78kg"));
        cates.add(new Categorie(8,"Homme","-60kg"));
        cates.add(new Categorie(9,"Homme","-66kg"));
        cates.add(new Categorie(10,"Homme","-73kg"));
        cates.add(new Categorie(11,"Homme","-81kg"));
        cates.add(new Categorie(12,"Homme","-90kg"));
        cates.add(new Categorie(13,"Homme","-100kg"));
        cates.add(new Categorie(14,"Homme","+100kg"));
        bdd.insertCategorieAll(cates);
    }


}
