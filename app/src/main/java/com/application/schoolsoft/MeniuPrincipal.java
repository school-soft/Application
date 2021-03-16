package com.application.schoolsoft;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.audiofx.BassBoost;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MeniuPrincipal extends ActivityBase {
    public static final String NUMAR_CLASA = "com.application.schoolsoft.NUMAR_CLASA";
    private static final String KEY_CLASA = "Clasa";
    private static final String KEY_USER = "Username";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meniu_principal);
        SetStatusBarColor();
        SetButtonCuprins();
        SetButtonAlegeClasa();
        SetButtonSettings();
        SetWelcomeText();
    }

    private void SetWelcomeText(){
        TextView WelcomeText = findViewById(R.id.welcome_text_view);
        String UserID = mAuth.getUid();
        fStore.collection("Users").document(UserID).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot document = task.getResult();
                    if(document.exists()){
                        String NumeUser = document.getString(KEY_USER);
                        WelcomeText.setText("Bun Venit  " + NumeUser);
                    }
                    else{
                        Toast.makeText(MeniuPrincipal.this, "Error", Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(MeniuPrincipal.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void SetButtonCuprins(){
        Button btnCuprins = findViewById(R.id.vezi_cuprins_button);
        btnCuprins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UserID = mAuth.getUid();
                fStore.collection("Users").document(UserID).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if(task.isSuccessful()){
                            DocumentSnapshot document = task.getResult();
                            if(document.exists()){
                                long NrClasa = document.getLong(KEY_CLASA);
                                OpenMeniuCapitole((int)NrClasa);
                            }
                            else{
                                Toast.makeText(MeniuPrincipal.this, "Error", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else{
                            Toast.makeText(MeniuPrincipal.this, "Error", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });
    }

    void SetButtonAlegeClasa(){
        ImageView btnAlegeClasa = findViewById(R.id.alege_clasa_btn);
        btnAlegeClasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenAlegeClasa();
            }
        });
    }

    void SetButtonSettings(){
        ImageView btnSettings = findViewById(R.id.settings_btn);
        ActivityBase activity = this;
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityFactory.openSettings(activity);
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

    private void OpenAlegeClasa(){
        Intent intent = new Intent(this, AlegeClasa.class);
        startActivity(intent);
    }
}