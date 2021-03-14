package com.application.schoolsoft;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AlegeClasa extends ActivityBase {
    public static final String NUMAR_CLASA = "com.application.schoolsoft.NUMAR_CLASA";
    public static final String KEY_CLASA = "Clasa";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alege_clasa);
        SetStatusBarColor();

        Button btnClasa1 = findViewById(R.id.Btn_clasa1);
        Button btnClasa2 = findViewById(R.id.Btn_clasa2);
        Button BtnClasa3 = findViewById(R.id.Btn_clasa3);
        Button btnClasa4 = findViewById(R.id.Btn_clasa4);

        btnClasa1.setOnClickListener(new AlegeClasaListener(this,1));
        btnClasa2.setOnClickListener(new AlegeClasaListener(this,2));
        BtnClasa3.setOnClickListener(new AlegeClasaListener(this,3));
        btnClasa4.setOnClickListener(new AlegeClasaListener(this,4));

    }


    public void SetStatusBarColor(){
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.lightCyanBlue));
        }

    }

    private void OpenMeniuCapitole(int NrClasa){
        Intent intent = new Intent(this, MeniuCapitole.class);
        intent.putExtra(NUMAR_CLASA,NrClasa);
        startActivity(intent);
    }


}