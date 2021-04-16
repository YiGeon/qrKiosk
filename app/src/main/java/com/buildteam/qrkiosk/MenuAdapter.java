package com.buildteam.qrkiosk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<com.buildteam.qrkiosk.MenuAdapter.CustomViewHolder> {

    private ArrayList<com.buildteam.qrkiosk.MenuData> arrayList;

    public MenuAdapter(ArrayList<com.buildteam.qrkiosk.MenuData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.option_list,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.ib_profile.setImageResource(arrayList.get(position).getIb_profile());
        holder.et_name.setText(arrayList.get(position).getEt_name());
        holder.et_price.setText(arrayList.get(position).getEt_price());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String curName = holder.et_name.getText().toString();
                Toast.makeText(v.getContext(), curName, Toast.LENGTH_SHORT).show();
            }
        });

        holder.ib_profile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                remove(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public void remove(int position){
        try {
            arrayList.remove(position);
            notifyItemRemoved(position);
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageButton ib_profile;
        protected EditText et_name;
        protected EditText et_price;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.ib_profile = (ImageButton) itemView.findViewById(R.id.ib_profile);
            this.et_name = (EditText) itemView.findViewById(R.id.et_name);
            this.et_price = (EditText) itemView.findViewById(R.id.et_price);
        }
    }
}
