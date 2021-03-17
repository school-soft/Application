package com.application.schoolsoft;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.FragmentManager;

public class ActivitateExercitii extends ActivityBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitate_exercitii);
        CreateBackButton();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_view_exercitii, ExercitiuAdunareSimplaFragment.class, null)
                .commit();
    }

    private void CreateBackButton(){
        ImageView BackBtn = findViewById(R.id.exercitiu_back_buton);
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}