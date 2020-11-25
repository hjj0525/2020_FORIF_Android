package com.example.recycleview;

import android.content.Context;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    Context context; // 동일 안드로이드 스튜디오에서 사용하는 것임을 알려주기 위함
    String[] title;
    String[] description;
    int[] icon;

    // Constructor
    public MyAdapter(Context context, String[] title, String[] description, int[] icon){
        this.context = context;
        this.title = title;
        this.description = description;
        this.icon = icon;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.itemview,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(title[position]);
        holder.description.setText(description[position]);
        holder.icon.setImageResource(icon[position]);
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView description;
        ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.TV_title);
            description = itemView.findViewById(R.id.TV_desc);
            icon = itemView.findViewById(R.id.IV_icon);

        }
    }
}
