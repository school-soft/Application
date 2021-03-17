package com.application.schoolsoft;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ExercitiuAdunareSimplaFragment extends Fragment {
    private int rezultat;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_exercitiu_adunare_simpla, container, false);
        // Inflate the layout for this fragment
        CreateCalculTextView();
            CreateVerifButton();

        return view;
    }

    private void CreateCalculTextView(){
        int nr1 = (int)(Math.random() * 30)+1;
        int nr2 = (int)(Math.random() * 30)+1;
        rezultat = nr1 + nr2;
        TextView CalculTextView = view.findViewById(R.id.calcul_text_view);
        CalculTextView.setText(nr1 + " + " + nr2);
    }
    private void CreateVerifButton(){
        Button VerifBtn = view.findViewById(R.id.verif_btn);
        VerifBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VerificaRaspuns();
            }
        });
    }
    private void VerificaRaspuns(){
        EditText RaspunsEditText = view.findViewById(R.id.raspuns_adunare_simpla);
        int raspuns = Integer.parseInt(RaspunsEditText.getText().toString());
        if(raspuns == rezultat)
            Toast.makeText(this.getActivity(), "Raspuns corect", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this.getActivity(), "Raspuns gresit", Toast.LENGTH_SHORT).show();
        RaspunsEditText.setText("");
        CreateCalculTextView();
    }
}