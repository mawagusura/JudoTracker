package fr.efrei.judotrackerpro;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.view.MenuItem;
import android.widget.TextView;

public class CompetitionActivity extends AppCompatActivity {

    private MapFragment mapFragment;
    private MatchesFragment matchesFragment;
    private PhotoFragment photoFragment;
    private CompetStatsFragment competStatsFragment;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition);

        mapFragment = new MapFragment();
        matchesFragment = new MatchesFragment();
        photoFragment = new PhotoFragment();
        competStatsFragment = new CompetStatsFragment();

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if(savedInstanceState == null){

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.frameCompet, competStatsFragment);
            ft.commit();
        }
    }

}
