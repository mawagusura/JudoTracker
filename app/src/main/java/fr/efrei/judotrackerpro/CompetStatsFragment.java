package fr.efrei.judotrackerpro;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import fr.efrei.judotrackerpro.back.bdd.LocalDatabase;
import fr.efrei.judotrackerpro.back.entities.Categorie;
import fr.efrei.judotrackerpro.back.entities.Competition;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class CompetStatsFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private Competition competition;

    public CompetStatsFragment() {
        // Required empty public constructor
    }

    public void setCompet(Competition compet){
        this.competition = compet;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_compet_stats, container, false);

        TextView date = view.findViewById(R.id.compet_date);
        TextView sex = view.findViewById(R.id.compet_sex);
        TextView cate = view.findViewById(R.id.compet_cate);


        Categorie categorie = LocalDatabase.getInstance(getContext()).getCategorie(competition.getId_categorie());
        if(cate!=null){
            cate.setText(categorie.getNom());
            sex.setText(categorie.getSexe());
        }
        date.setText(competition.getDate_competition().toString());


        return view;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
