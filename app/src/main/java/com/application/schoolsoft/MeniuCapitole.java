package com.application.schoolsoft;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MeniuCapitole extends AppCompatActivity {
    private int NumarClasa;
    private TextView NumeClasaText;
    private ImageView BackButton;
    private RecyclerView CapitoleRecyclerView;
    private ArrayList<String> ArrayCapitole = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meniu_capitole);

        NumeClasaText = findViewById(R.id.nume_clasa_text);
        BackButton = findViewById(R.id.clasa_back_button);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        NumarClasa = intent.getIntExtra(AlegeClasa.NUMAR_CLASA, 0);

        NumeClasaText.setText("Clasa " + NumarClasa);

        SetCapitole();
        CreateRecyclerViewCapitole();
    }

    private void SetCapitole(){
        switch (NumarClasa){
            case 1:
                ArrayCapitole.add("Numere naturale cuprinse intre 0-31");
                ArrayCapitole.add("Adunarea si scaderea numerelor intre 0-31,fara trecere peste ordin");
                ArrayCapitole.add("Adunarea si scaderea numerelor intre 0-20,cu trecere peste ordin");
                ArrayCapitole.add("Elemente de geometrie");
                break;
            case 2:
                ArrayCapitole.add("Numere naturale cuprinse intre 0-10 000");
                ArrayCapitole.add("Adunarea si scaderea numerelor intre 0-100, cu trecere peste ordin");
                ArrayCapitole.add("Inmultirea numerelor naturale");
                ArrayCapitole.add("Elemente de geometrie");
                break;
            case 3:
                ArrayCapitole.add("Numere naturale cuprinse intre 0-10 000");
                ArrayCapitole.add("Adunarea si scaderea numerelor in intervalul 0-10 000");
                ArrayCapitole.add("Inmultirea numerelor naturale 0-100");
                ArrayCapitole.add("Impartirea numerelor naturale 0-100");
                break;
            case 4:
                ArrayCapitole.add("Numere naturale cuprinse intre 0 - 1 000 000");
                ArrayCapitole.add("Adunarea si scaderea numerelor in intervalul 0-1 000 000");
                ArrayCapitole.add("Inmultirea numerelor naturale 0-1 000 000");
                ArrayCapitole.add("Impartirea numerelor naturale 0-1 000 000");
                break;
        }

    }

    private void CreateRecyclerViewCapitole(){

        CapitoleRecyclerView = findViewById(R.id.meniu_capitole_recycler_view);

        CapitoleRecyclerView.setAdapter(new CapitoleRecyclerViewAdaptor(ArrayCapitole));
        CapitoleRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}