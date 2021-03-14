package com.application.schoolsoft;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public abstract class ActivityBase extends AppCompatActivity {
    protected FirebaseAuth mAuth = FirebaseAuth.getInstance();
    protected FirebaseFirestore fStore = FirebaseFirestore.getInstance();

}
