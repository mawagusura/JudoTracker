package fr.efrei.judotrackerpro;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import fr.efrei.judotrackerpro.back.bdd.LocalDatabase;
import fr.efrei.judotrackerpro.back.entities.Competition;
import fr.efrei.judotrackerpro.back.entities.Localisation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap map;
    private MapView mapView;
    private Marker actualMarker;

    private TextView lat;
    private TextView lon;

    private Competition competition;

    public MapFragment() {
        // Required empty public constructor
    }

    public void setCompetition(Competition competition){
        this.competition = competition;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        mapView = view.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();

        try{
            MapsInitializer.initialize(getActivity().getApplicationContext());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        mapView.getMapAsync(this);

        lat = view.findViewById(R.id.map_lat);
        lon = view.findViewById(R.id.map_lon);


        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap){
        map = googleMap;

        if(competition!=null){
            if(actualMarker!=null){
                actualMarker.remove();
            }

            Localisation loc = LocalDatabase.getInstance(getContext()).getLocalisation(competition.getId_localisation());

            if(loc!=null) {
                actualMarker = map.addMarker(new MarkerOptions()
                        .position(new LatLng(loc.getLatitude(), loc.getLongitude()))
                        .title("lat :" + loc.getLatitude() + ", long :" + loc.getLongitude())
                );

                lat.setText(String.valueOf(loc.getLatitude()));
                lon.setText(String.valueOf(loc.getLongitude()));
            }
        }

        map.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                if(actualMarker!=null){
                    actualMarker.remove();
                }
                actualMarker = map.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("lat :"+latLng.latitude+", long :"+latLng.longitude)
                );

                lat.setText(String.valueOf(latLng.latitude));
                lon.setText(String.valueOf(latLng.longitude));


                LocalDatabase bdd = LocalDatabase.getInstance(getContext());

                Localisation loc = new Localisation(latLng.longitude, latLng.latitude);

                long id = bdd.insertLocalisation(loc);
                competition.setLocalisation(bdd.getLocalisation((int)id));
                LocalDatabase.getInstance(getContext()).updateCompetition(competition);
            }

        });
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
