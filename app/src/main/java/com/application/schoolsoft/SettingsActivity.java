package com.application.schoolsoft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class SettingsActivity extends AppCompatActivity {
    private ImageView BackButton = null;
    private TextView LogOutBtn = null;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        mAuth = FirebaseAuth.getInstance();
        CreateBackButton();
        CreateLogOutButton();
    }

    private void CreateBackButton(){
        BackButton = findViewById(R.id.settings_back_button);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void CreateLogOutButton(){
        LogOutBtn = findViewById(R.id.log_out_btn);
        LogOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                OpenLogin();
            }
        });
    }
    private void OpenLogin(){
        Intent intent = new Intent(this, LoginPage.class);
        startActivity(intent);
    }

}