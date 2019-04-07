package fr.efrei.judotrackerpro.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import fr.efrei.judotrackerpro.R;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.MatchViewHolder> {

    List<String> list;

    public MatchesAdapter(List<String> list){
        this.list = list;
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_card, parent, false);
        MatchViewHolder mvh = new MatchViewHolder(view);

        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        holder.getText().setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    class MatchViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView text;

        MatchViewHolder(View itemView){
            super(itemView);
            text = itemView.findViewById(R.id.TEMP_id_card);
        }

        TextView getText(){
            return text;
        }
    }
}
