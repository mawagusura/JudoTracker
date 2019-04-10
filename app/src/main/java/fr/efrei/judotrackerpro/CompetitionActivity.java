package fr.efrei.judotrackerpro;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import fr.efrei.judotrackerpro.back.bdd.LocalDatabase;
import fr.efrei.judotrackerpro.back.entities.Categorie;
import fr.efrei.judotrackerpro.back.entities.Competition;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

public class CompetitionActivity extends AppCompatActivity {

    private MapFragment mapFragment;
    private MatchesFragment matchesFragment;
    private PhotoFragment photoFragment;
    private CompetStatsFragment competStatsFragment;

    private Competition competition;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment nextFragment;

            switch (item.getItemId()) {
                case R.id.nav_home:
                    nextFragment = competStatsFragment;
                    break;
                case R.id.nav_matches:
                    nextFragment = matchesFragment;
                    break;
                case R.id.nav_location:
                    nextFragment = mapFragment;
                    break;
                case R.id.nav_photos:
                    nextFragment=photoFragment;
                    break;
                default:
                    return false;
            }

            Fragment currentFragment= getSupportFragmentManager().findFragmentById(R.id.frameCompet);

            if(!currentFragment.equals(nextFragment)){
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.remove(currentFragment);
                ft.commit();
                getSupportFragmentManager().executePendingTransactions();
                ft = getSupportFragmentManager().beginTransaction();
                ft.add(R.id.frameCompet, nextFragment);
                ft.commit();
            }

            return true;
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle!=null){
            Integer competID = bundle.getInt("ID");
            competition = LocalDatabase.getInstance(getApplicationContext()).getCompetition(competID);
            TextView name = findViewById(R.id.compet_name);
            name.setText(competition.getNom_competition());

        }

        mapFragment = new MapFragment();
        matchesFragment = new MatchesFragment();
        photoFragment = new PhotoFragment();
        competStatsFragment = new CompetStatsFragment();
        competStatsFragment.setCompet(competition);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if(savedInstanceState == null){

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.frameCompet, competStatsFragment);
            ft.commit();
        }

        Toolbar appBar = findViewById(R.id.compet_bar);
        setSupportActionBar(appBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.compet_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.edit_compet:
                Intent i = new Intent(CompetitionActivity.this, EditCompetActivity.class);
                Bundle b = new Bundle();
                b.putInt("ID",competition.getId_competition());
                i.putExtras(b);
                finish();
                startActivity(i);
                return true;
            case R.id.del_compet:
                LocalDatabase.getInstance(getApplicationContext()).deleteCompetition(competition);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
