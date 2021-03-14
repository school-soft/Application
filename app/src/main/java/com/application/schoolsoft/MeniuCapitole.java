package com.application.schoolsoft;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MeniuCapitole extends ActivityBase {
    private int NumarClasa;
    private ArrayList<String> ArrayCapitole = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meniu_capitole);
        SetStatusBarColor();

        CreateBackButton();
        CreateTitle();
        SetCapitole();
        CreateRecyclerViewCapitole();
    }

    private void CreateTitle(){
        TextView numeClasaText = findViewById(R.id.nume_clasa_text);

        Intent intent = getIntent();
        NumarClasa = intent.getIntExtra(AlegeClasa.NUMAR_CLASA, 0);

        numeClasaText.setText("Clasa " + NumarClasa);

    }

    private void CreateBackButton(){
        ImageView backButton = findViewById(R.id.clasa_back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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

    public void SetStatusBarColor(){
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.medlightGreen));
        }

    }

    private void CreateRecyclerViewCapitole(){

        RecyclerView capitoleRecyclerView = findViewById(R.id.meniu_capitole_recycler_view);

        capitoleRecyclerView.setAdapter(new CapitoleRecyclerViewAdaptor(ArrayCapitole));
        capitoleRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}