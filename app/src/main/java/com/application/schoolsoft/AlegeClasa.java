package com.application.schoolsoft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlegeClasa extends AppCompatActivity {
    public static final String NUMAR_CLASA = "com.application.schoolsoft.NUMAR_CLASA";
    private Button BtnClasa1 = null;
    private Button BtnClasa2 = null;
    private Button BtnClasa3 = null;
    private Button BtnClasa4 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alege_clasa);
        BtnClasa1 = findViewById(R.id.Btn_clasa1);
        BtnClasa2 = findViewById(R.id.Btn_clasa2);
        BtnClasa3 = findViewById(R.id.Btn_clasa3);
        BtnClasa4 = findViewById(R.id.Btn_clasa4);

        BtnClasa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Clasa 1", Toast.LENGTH_SHORT).show();
                OpenMeniuCapitole(1);
            }
        });

        BtnClasa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Clasa 2", Toast.LENGTH_SHORT).show();
                OpenMeniuCapitole(2);
            }
        });

        BtnClasa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Clasa 3", Toast.LENGTH_SHORT).show();
                OpenMeniuCapitole(3);
            }
        });

        BtnClasa4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "Clasa 4", Toast.LENGTH_SHORT).show();
                OpenMeniuCapitole(4);
            }
        });

    }

    private void OpenMeniuCapitole(int NrClasa){
        Intent intent = new Intent(this, MeniuCapitole.class);
        intent.putExtra(NUMAR_CLASA,NrClasa);
        startActivity(intent);
    }

}