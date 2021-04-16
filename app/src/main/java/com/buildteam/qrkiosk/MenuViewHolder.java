package com.buildteam.qrkiosk;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MenuViewHolder extends RecyclerView.ViewHolder{
    TextView itemName;

    //뷰 홀더 생성자로 전달되는 뷰 객체 참조하기
    public MenuViewHolder(@NonNull View itemView) {
        super(itemView);

        itemName = itemView.findViewById(R.id.itemName);
    }

    //아이템들에 각각 데이터를 set
    public void setItem(Menu menu){
        itemName.setText(menu.getMenu());
    }

}
