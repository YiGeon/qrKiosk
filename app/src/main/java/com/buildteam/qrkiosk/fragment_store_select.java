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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class fragment_store_select extends Fragment {


    private Button backButton, setEventButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_store_select, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView); // recyclerview 객체 생성
        RecycleAdapter adapter = new RecycleAdapter();   // recycleAdapter 객체 생성

        for(int i=0; i<100; i++){
            adapter.add(new Menu(String.valueOf(i+". ~~버블티"))); // 0~99까지의 텍스트 값을 임의로 찍음
        }
        //레이아웃의 모양을 설정하기 위한 레이아웃 매니저
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager); // recyclerview에 레이아웃매니저 적용
        recyclerView.setAdapter(adapter); //recyclerview에 어댑터 적용

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        this.backButton = view.findViewById(R.id.storeSelectFragment_backButton);
        this.setEventButton = view.findViewById(R.id.storeSelectFragment_setEventButton);


        this.backButton.setOnClickListener(v-> Navigation.findNavController(v).navigate(R.id.action_global_fragment_store_managing));
        this.setEventButton.setOnClickListener(v-> Navigation.findNavController(v).navigate(R.id.action_fragment_store_select_to_fragment_event_list));
    }


}