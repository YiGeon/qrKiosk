package com.buildteam.qrkiosk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


public class fragment_store_managing extends Fragment {

    private Button addStoreButton, selectStoreButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_store_managing, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.addStoreButton = view.findViewById(R.id.managingStoreFragment_addStoreButton);
        this.selectStoreButton = view.findViewById(R.id.managingStoreFragment_selectStoreButton);

        this.addStoreButton.setOnClickListener(v->Navigation.findNavController(v).navigate(R.id.action_fragment_store_managing_to_fragment_store_add));
        this.selectStoreButton.setOnClickListener(v->Navigation.findNavController(v).navigate(R.id.action_fragment_store_managing_to_fragment_store_select));
    }
}