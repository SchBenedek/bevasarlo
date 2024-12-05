package com.example.bevasarlo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import java.util.List;

public class TermekAdapter extends ArrayAdapter<Termekek> {
    public TermekAdapter(Context context, int resource, List<Termekek> termekek) {
        super(context, resource, termekek);
    }

    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent){
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listviewitem, parent, false);
        }

        CardView cardView = convertView.findViewById(R.id.cardView);
        Termekek termek = getItem(position);
        TextView nev = convertView.findViewById(R.id.nev);
        TextView mennyieg = convertView.findViewById(R.id.mennyieg);

        if (termek != null) {
            nev.setText(termek.getNev());
            mennyieg.setText(String.valueOf(termek.getMennyiseg()));

            convertView.setOnClickListener(view -> {
                Intent adat = new Intent(getContext(), ListOfTermekekActivity.class);
                adat.putExtra("nev", termek.getNev());
                adat.putExtra("mennyiseg", termek.getMennyiseg());

                getContext().startActivity(adat);
            });
        }

        return convertView;

    }
}
