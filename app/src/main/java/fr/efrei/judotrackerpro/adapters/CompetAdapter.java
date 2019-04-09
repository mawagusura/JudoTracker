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

public class CompetAdapter extends RecyclerView.Adapter<CompetAdapter.CompetViewHolder>{

    List<String> list;

    public CompetAdapter(List<String> list){
        this.list = list;
    }

    @NonNull
    @Override
    public CompetAdapter.CompetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_card, parent, false);
        CompetAdapter.CompetViewHolder mvh = new CompetAdapter.CompetViewHolder(view);

        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull CompetViewHolder holder, int position) {
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


    class CompetViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView text;

        CompetViewHolder(View itemView){
            super(itemView);
            text = itemView.findViewById(R.id.TEMP_id_card);
        }

        TextView getText(){
            return text;
        }
    }
}
