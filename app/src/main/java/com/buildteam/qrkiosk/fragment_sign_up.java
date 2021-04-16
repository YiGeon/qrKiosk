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

public class fragment_sign_up extends Fragment {

    private Button completeButton, TermsAndConditions01, TermsAndConditions02;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_sign_up, container, false)
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.completeButton = view.findViewById(R.id.signUpFragment_completeButton);
        /*
        this.TermsAndConditions01 = view.findViewById(R.id.TermsAndConditionsButton_01);
        this.TermsAndConditions02 = view.findViewById(R.id.TermsAndConditionsButton_02);
        */
        //회원가입 완료 버튼
        this.completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragment_sign_up_to_fragment_sign_up_complete);
            }
        });

        /*
        //이용약관 보기버튼
        this.TermsAndConditions01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragment_sign_up_to_fragment_TermsAndConditions_01);
            }
        });

        //개인정보취급약관 보기버튼
        this.TermsAndConditions02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragment_sign_up_to_fragment_TermsAndConditions_02);
            }
        });
         */
    }
}