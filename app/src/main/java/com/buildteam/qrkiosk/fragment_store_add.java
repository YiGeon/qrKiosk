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


public class fragment_store_add extends Fragment {
    private Button confirmButton, cancelButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_store_add, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.confirmButton = view.findViewById(R.id.storeAddFragment_confirmButton);
        this.cancelButton = view.findViewById(R.id.storeAddFragment_cancelButton);

        this.confirmButton.setOnClickListener(v-> {
            Navigation.findNavController(v).navigate(R.id.action_global_fragment_store_managing);
        });
        this.cancelButton.setOnClickListener(v->Navigation.findNavController(v).navigate(R.id.action_global_fragment_store_managing));
    }
}