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
import fr.efrei.judotrackerpro.R;
import fr.efrei.judotrackerpro.back.entities.Competition;

public class CompetAdapter extends RecyclerView.Adapter<CompetAdapter.CompetViewHolder>{

    List<Competition> list;


    public CompetAdapter(List<Competition> list){
        this.list = list;
    }

    @NonNull
    @Override
    public CompetAdapter.CompetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_card, parent, false);
        CompetAdapter.CompetViewHolder mvh = new CompetAdapter.CompetViewHolder(view);
        view.setOnClickListener(mvh);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CompetViewHolder holder, int position) {
        holder.text.setText(list.get(position).getNom_competition());
        holder.id = list.get(position).getId_competition();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    class CompetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView cv;
        TextView text;

        Integer id;

        CompetViewHolder(View itemView){
            super(itemView);
            text = itemView.findViewById(R.id.TEMP_id_card);
        }

        @Override
        public void onClick(View view) {
            Intent i = new Intent(view.getContext(), CompetitionActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("ID",id);
            i.putExtras(bundle);
            view.getContext().startActivity(i);
        }
    }

}
