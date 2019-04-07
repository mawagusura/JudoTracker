package fr.efrei.judotrackerpro.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Set;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import fr.efrei.judotrackerpro.R;
import fr.efrei.judotrackerpro.back.entities.Categorie;

public class CateAdapter extends BaseAdapter {

    private List<Categorie> cates;

    LayoutInflater inflater;

    public CateAdapter(Context appContext, List<Categorie> categories){
        inflater = LayoutInflater.from(appContext);
        cates = categories;
    }

    @Override
    public long getItemId(int position) {
        return cates.get(position).getId_categorie();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return cates.get(position);
    }

    @Override
    public int getCount() {
        return cates.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = inflater.inflate(R.layout.custom_spinner,null);

        TextView name = view.findViewById(R.id.cate_spinner);
        name.setText(cates.get(position).getNom());

        return view;
    }
}
