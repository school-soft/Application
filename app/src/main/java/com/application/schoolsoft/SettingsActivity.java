package com.application.schoolsoft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SettingsActivity extends ActivityBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        CreateBackButton();
        CreateLogOutButton();
        CreateDeleteAccountButton();
    }

    private void CreateBackButton(){
        ImageView backButton = findViewById(R.id.settings_back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void CreateLogOutButton(){
        TextView logOutBtn = findViewById(R.id.log_out_btn);
        logOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                OpenLogin();
            }
        });
    }
    
    private void CreateDeleteAccountButton(){
        TextView DeleteAccountBtn = findViewById(R.id.delete_account_btn);
        DeleteAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SettingsActivity.this, "You Clicked Delete account", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void OpenLogin(){
        Intent intent = new Intent(this, LoginPage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}