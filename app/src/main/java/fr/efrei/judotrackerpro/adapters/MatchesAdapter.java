package fr.efrei.judotrackerpro.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import fr.efrei.judotrackerpro.CompetitionActivity;
import fr.efrei.judotrackerpro.MatchActivity;
import fr.efrei.judotrackerpro.R;
import fr.efrei.judotrackerpro.back.bdd.LocalDatabase;
import fr.efrei.judotrackerpro.back.entities.Adversaire;
import fr.efrei.judotrackerpro.back.entities.Match;
import fr.efrei.judotrackerpro.back.entities.Statistiques;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.MatchViewHolder> {

    List<Match> list;

    public Context context;

    public MatchesAdapter(List<Match> list){
        this.list = list;
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_card, parent, false);
        MatchViewHolder mvh = new MatchViewHolder(view);
        view.setOnClickListener(mvh);

        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {

        Adversaire adv = LocalDatabase.getInstance(context).getAdversaire(list.get(position).getId_adversaire());
        holder.text.setText("Moi VS "+adv.prenom_adversaire+" "+adv.getNomAdversaire());
        holder.id = list.get(position).getId_match();
        Integer id_stats = list.get(position).getId_stats();
        Statistiques stats = LocalDatabase.getInstance(context).getStatistiques(id_stats);
        if(stats!=null ){
            int score_ut = stats.getIpponsUtilisateur()*100 + stats.getWazaariUtilisateur()*10+stats.getYukoUtilisateur();
            int score_adv = stats.getIpponsAdv()*100 + stats.getWazaariAdv()*10 + stats.getYukoAdv();

            if(score_adv>score_ut){

                holder.cv.setCardBackgroundColor(context.getResources().getColor(R.color.red));
                holder.text.setTextColor(context.getResources().getColor(R.color.common_google_signin_btn_text_light));
            }
            else{
                holder.cv.setCardBackgroundColor(context.getResources().getColor(R.color.green));
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    class MatchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cv;
        TextView text;

        Integer id;

        MatchViewHolder(View itemView){
            super(itemView);
            text = itemView.findViewById(R.id.TEMP_id_card);
            cv = itemView.findViewById(R.id.match_card);
        }

        @Override
        public void onClick(View view) {
            Intent i = new Intent(view.getContext(), MatchActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("id_match",id);
            i.putExtras(bundle);
            view.getContext().startActivity(i);
        }
    }
}
