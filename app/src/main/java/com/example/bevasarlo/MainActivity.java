package com.example.bevasarlo;

import static java.lang.Integer.parseInt;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText nevEditText;
    private EditText mennyiegEditText;
    private Button hozzaadButton;
    private ListView listView;
    private ArrayList<Termekek> ujTermek;

    private TermekAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
        ujTermek=new ArrayList<>();
        adapter = new TermekAdapter(this, R.layout.listviewitem, ujTermek);
        listView.setAdapter(adapter);

        hozzaadButton.setOnClickListener(v -> {
            String nev=nevEditText.getText().toString();
            String mennyiseg=mennyiegEditText.getText().toString();
            if(nev.isEmpty() || mennyiseg.isEmpty()){
                AlertDialog.Builder alert=new AlertDialog.Builder(this);
                alert.setMessage("Hiányos");
                alert.show();
                return;
            }
            Termekek termek=new Termekek(nev, parseInt(mennyiseg));
            ujTermek.add(termek);
            adapter.notifyDataSetChanged();
        });
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Törli?");
            alert.setPositiveButton("Igen", (dialog, which) -> {
                ujTermek.remove(position);
                adapter.notifyDataSetChanged();
            });
            alert.setNegativeButton("Nem", (dialog, which) -> dialog.dismiss());
            alert.show();

            return true;
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Termekek termek = ujTermek.get(position);
            Log.d("MainActivity", "Termek name: " + termek.getNev() + ", quantity: " + termek.getMennyiseg());
            Intent intent = new Intent(this, ListOfTermekekActivity.class);
            intent.putExtra("nev", termek.getNev());
            intent.putExtra("mennyiseg", termek.getMennyiseg());
            startActivity(intent);
        });
    }

    public void init(){
        nevEditText=findViewById(R.id.nevEditText);
        mennyiegEditText=findViewById(R.id.mennyiegEditText);
        hozzaadButton=findViewById(R.id.hozzaadButton);
        listView=findViewById(R.id.listView);
    }
}