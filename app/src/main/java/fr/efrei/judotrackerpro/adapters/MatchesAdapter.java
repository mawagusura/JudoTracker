package fr.efrei.judotrackerpro.adapters;

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
import fr.efrei.judotrackerpro.back.entities.Match;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.MatchViewHolder> {

    List<Match> list;

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
        holder.text.setText(list.get(position).getId_match());
        holder.id = list.get(position).getId_match();
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
