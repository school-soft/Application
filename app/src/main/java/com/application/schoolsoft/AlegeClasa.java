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

public class AlegeClasa extends AppCompatActivity {
    public static final String NUMAR_CLASA = "com.application.schoolsoft.NUMAR_CLASA";
    private static final String KEY_CLASA = "Clasa";
    private FirebaseAuth mAuth;
    private FirebaseFirestore fStore;
    private Button BtnClasa1 = null;
    private Button BtnClasa2 = null;
    private Button BtnClasa3 = null;
    private Button BtnClasa4 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alege_clasa);
        SetStatusBarColor();

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();



        BtnClasa1 = findViewById(R.id.Btn_clasa1);
        BtnClasa2 = findViewById(R.id.Btn_clasa2);
        BtnClasa3 = findViewById(R.id.Btn_clasa3);
        BtnClasa4 = findViewById(R.id.Btn_clasa4);

        BtnClasa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetClasaBazaDeDate(1);
                OpenMeniuPrincipal();
            }
        });

        BtnClasa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetClasaBazaDeDate(2);
                OpenMeniuPrincipal();
            }
        });

        BtnClasa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetClasaBazaDeDate(3);
                OpenMeniuPrincipal();
            }
        });

        BtnClasa4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetClasaBazaDeDate(4);
                OpenMeniuPrincipal();
            }
        });

    }

    private void SetClasaBazaDeDate(int NrClasa){
        String UserID;
        UserID = mAuth.getUid();
        Map<String, Object> Data = new HashMap<>();
        Data.put(KEY_CLASA,NrClasa);
        fStore.collection("Users").document(UserID).set(Data).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(AlegeClasa.this, "Added clasa to firestore", Toast.LENGTH_SHORT).show();
                }
                else{

                    Toast.makeText(AlegeClasa.this, "Failed to add clasa to firestore", Toast.LENGTH_SHORT).show();
                }
            }
        });

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

    private void OpenMeniuPrincipal(){
        Intent intent = new Intent(this, MeniuPrincipal.class);
        startActivity(intent);
        finish();
    }

}