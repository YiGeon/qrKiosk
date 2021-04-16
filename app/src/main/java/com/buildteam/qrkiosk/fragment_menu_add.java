package com.buildteam.qrkiosk;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class fragment_menu_add extends Fragment {
    private ImageButton backButton, optionAddButton;
    private Button saveButton, loadImageButton;


    private ArrayList<com.buildteam.qrkiosk.MenuData> arrayList;
    private com.buildteam.qrkiosk.MenuAdapter menuAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_add, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);


        recyclerView = (RecyclerView)view.findViewById(R.id.addMenu_menuOption_rcv);
        linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        menuAdapter = new com.buildteam.qrkiosk.MenuAdapter(arrayList);
        recyclerView.setAdapter(menuAdapter);

        this.optionAddButton = view.findViewById(R.id.menuAddFragment_optionAddButton);
        this.optionAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                com.buildteam.qrkiosk.MenuData menuData = new com.buildteam.qrkiosk.MenuData(R.drawable.ic_baseline_horizontal_rule, "", "");
                arrayList.add(menuData);
                menuAdapter.notifyDataSetChanged();
            }
        });

        loadImageButton = view.findViewById(R.id.menuAddFragment_loadImageButton);
        loadImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 101);
            }
        });










        this.backButton = (ImageButton)view.findViewById(R.id.addMenu_backArrow_image);
        this.saveButton = (Button)view.findViewById(R.id.menuAddFragment_saveButton);

        this.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Navigation.findNavController(view).navigate(R.id.action_global_fragment_home);
            }
        });

        this.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Navigation.findNavController(view).navigate(R.id.action_global_fragment_home);
            }
        });
    }
}