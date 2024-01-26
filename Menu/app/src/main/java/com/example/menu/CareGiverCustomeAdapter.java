package com.example.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CareGiverCustomeAdapter extends RecyclerView.Adapter<CareGiverCustomeAdapter.myViewHolder> {

    private Context context;
    private ArrayList<String> name,num,add;

    CareGiverCustomeAdapter(Context context, ArrayList name, ArrayList num,ArrayList add){
        this.context = context;
        this.name = name;
        this.num = num;
        this.add = add;

    }

    @NonNull
    @Override
    public CareGiverCustomeAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =  LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.caregiversrows,parent,false);
        return new CareGiverCustomeAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CareGiverCustomeAdapter.myViewHolder holder, int position) {
        holder.name.setText(String.valueOf(name.get(position)));
        holder.num.setText(String.valueOf(num.get(position)));
        holder.add.setText(String.valueOf(add.get(position)));

    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView name,num,add;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            num = itemView.findViewById(R.id.number);
            add = itemView.findViewById(R.id.address);

        }
    }
}
