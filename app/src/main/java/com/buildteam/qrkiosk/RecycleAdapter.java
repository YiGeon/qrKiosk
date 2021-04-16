package com.buildteam.qrkiosk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MenuViewHolder> {
    ArrayList<Menu> items = new ArrayList<>();
    private MenuViewHolder holder;
    private int position;

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext()); // 파라미터로 받은 ViewGroup의 context를 메모리에 로딩함
        View itemView = inflater.inflate(R.layout.item, parent, false); // 뷰그룹에 각 아이템들을 붙임
        return new MenuViewHolder(itemView); // 뷰 홀더 객체를 생성하면서 뷰 객체를 전달하고 그 뷰홀더 객체를 반환하기



    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        Menu menu = items.get(position);
        holder.setMenu(menu);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public void add(Menu menu){
        items.add(menu);
    }

    static class MenuViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.itemName);
        }

        public void setMenu(Menu menu) {
            text.setText(menu.getMenu());
        }
    }
}
