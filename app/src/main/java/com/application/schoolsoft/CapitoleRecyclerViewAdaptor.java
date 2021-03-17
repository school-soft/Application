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
    private OnCapitolListner mOnCapitolListner;

    public CapitoleRecyclerViewAdaptor(ArrayList<String> arraycapitole, OnCapitolListner onCapitolListner){
        this.mArrayCapitole = arraycapitole;
        this.mOnCapitolListner = onCapitolListner;
    }

    @NonNull
    @Override
    public CapitoleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.capitol_card_view, parent , false);
        return new CapitoleViewHolder(view,mOnCapitolListner);
    }

    @Override
    public void onBindViewHolder(@NonNull CapitoleViewHolder holder, int position) {
        holder.NumeCapitol.setText(mArrayCapitole.get(position));
    }

    @Override
    public int getItemCount() {
        return mArrayCapitole.size();
    }

    public static class CapitoleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView NumeCapitol;
        OnCapitolListner onCapitolListner;

        public CapitoleViewHolder(@NonNull View itemView ,OnCapitolListner onCapitolListner) {
            super(itemView);

            NumeCapitol = itemView.findViewById(R.id.nume_capitol_text_view);
            this.onCapitolListner = onCapitolListner;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onCapitolListner.onCapitolListner(getAdapterPosition());
        }
    }

    public interface OnCapitolListner {
        void onCapitolListner(int position);
    }

}
