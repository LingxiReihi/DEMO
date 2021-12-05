package com.example.demo;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.InnerHolder> {
    @SuppressLint("ResourceType")
    private final ArrayList<picture> data;

    public adapter(ArrayList<picture> data) {
        this.data=data;
    }

    @SuppressLint("ResourceType")
    @NonNull
    @Override
    public adapter.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new InnerHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_rv,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull adapter.InnerHolder holder, int position) {
        holder.ivPicture.setImageResource(data.get(position).getPictureId());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class InnerHolder extends RecyclerView.ViewHolder{
        ImageView ivPicture;
        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            ivPicture = itemView.findViewById(R.id.iv_item_picture);
        }
    }
}

