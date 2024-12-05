package com.example.bevasarlo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListOfTermekekActivity extends AppCompatActivity {
    private TextView nevTextView;
    private TextView mennyisegTextView;
    private Button visszaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.termekekactivity);

        nevTextView = findViewById(R.id.nevTextView);
        mennyisegTextView = findViewById(R.id.mennyisegTextView);
        visszaButton = findViewById(R.id.visszaButton);

        // Retrieve data from intent
        String nev = getIntent().getStringExtra("nev");
        int mennyiseg = getIntent().getIntExtra("mennyiseg", 0);

        nevTextView.setText(nev);
        mennyisegTextView.setText(String.valueOf(mennyiseg));

        visszaButton.setOnClickListener(v -> finish());
    }
}
