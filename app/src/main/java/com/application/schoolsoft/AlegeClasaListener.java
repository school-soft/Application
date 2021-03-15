package com.application.schoolsoft;

import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;

import java.util.HashMap;
import java.util.Map;

public class AlegeClasaListener implements View.OnClickListener{
    private int clasa;
    private ActivityBase activity;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseFirestore fStore = FirebaseFirestore.getInstance();

    public AlegeClasaListener(ActivityBase activity,int clasa){
        this.clasa = clasa;
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        SetClasaBazaDeDate(clasa);
        ActivityFactory.openMeniuPrincipal(activity);
    }

    private void SetClasaBazaDeDate(int NrClasa){
        String UserID;
        UserID = mAuth.getUid();
        Map<String, Object> Data = new HashMap<>();
        Data.put(AlegeClasa.KEY_CLASA,NrClasa);
        fStore.collection("Users").document(UserID).set(Data, SetOptions.merge()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(activity, "Added clasa to firestore", Toast.LENGTH_SHORT).show();
                }
                else{

                    Toast.makeText(activity, "Failed to add clasa to firestore", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
