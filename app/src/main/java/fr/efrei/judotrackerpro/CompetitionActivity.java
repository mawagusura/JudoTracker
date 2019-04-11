package fr.efrei.judotrackerpro;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import fr.efrei.judotrackerpro.back.bdd.LocalDatabase;
import fr.efrei.judotrackerpro.back.entities.Competition;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.appcompat.widget.Toolbar;

public class CompetitionActivity extends AppCompatActivity {

    private MapFragment mapFragment;
    private MatchesFragment matchesFragment;
    private CompetStatsFragment competStatsFragment;

    private Competition competition;

    static final int REQUEST_IMAGE_CAPTURE = 1;


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
                    dispatchTakePictureIntent();
                    nextFragment = getSupportFragmentManager().findFragmentById(R.id.frameCompet);
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
        mapFragment.setCompetition(competition);
        matchesFragment = new MatchesFragment();
        matchesFragment.setCompetition(competition);
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

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }

    String currentPhotoPath;

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }



}
