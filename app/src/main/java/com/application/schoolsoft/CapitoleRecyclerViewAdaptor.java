package com.application.schoolsoft;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CapitoleRecyclerViewAdaptor extends RecyclerView.Adapter<CapitoleRecyclerViewAdaptor.CapitoleViewHolder> {
    private ArrayList<String> mArrayCapitole;

    public CapitoleRecyclerViewAdaptor(ArrayList<String> arraycapitole){
        mArrayCapitole = arraycapitole;
    }

    @NonNull
    @Override
    public CapitoleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.capitol_card_view, parent , false);
        return new CapitoleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CapitoleViewHolder holder, int position) {
        holder.NumeCapitol.setText(mArrayCapitole.get(position));
    }

    @Override
    public int getItemCount() {
        return mArrayCapitole.size();
    }

    public static class CapitoleViewHolder extends RecyclerView.ViewHolder {
        public TextView NumeCapitol;

        public CapitoleViewHolder(@NonNull View itemView) {
            super(itemView);

            NumeCapitol = itemView.findViewById(R.id.nume_capitol_text_view);
        }
    }

}
