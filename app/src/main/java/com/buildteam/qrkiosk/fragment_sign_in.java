package com.buildteam.qrkiosk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class fragment_sign_in extends Fragment {
    private String loginId = "";
    private String loginPassword = "";

    private Button signInButton, signUpButton;

    public fragment_sign_in() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.signInButton = view.findViewById(R.id.signInFragment_signInButton);
        this.signUpButton = view.findViewById(R.id.signInFragment_signUpButton);


        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText idText = view.findViewById(R.id.signInFragment_loginId);
                loginId = idText.getText().toString();

                EditText passwordText = view.findViewById(R.id.signInFragment_loginPassword);
                loginPassword = passwordText.getText().toString();


                Navigation.findNavController(view).navigate(R.id.action_global_fragment_home);
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_fragment_sign_in_to_fragment_sign_up);
            }
        });
    }
}