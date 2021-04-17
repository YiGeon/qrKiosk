package com.buildteam.qrkiosk;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.Navigation;

import com.buildteam.qrkiosk.asset.AbstractFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class fragment_sign_in extends AbstractFragment {

    //Associate
    //View
    private EditText Login_Email_EditText, Login_Password_EditText;
    private Button Login_Login_Button;
    private TextView Login_FindID_TextView, Login_ResetPassword_TextView, Login_SignUp_TextView;
    //Model
    private FirebaseAuth mAuth;

    @Override
    protected int getViewId() {
        return R.layout.fragment_sign_in;
    }

    @Override
    protected void associate(View view) {
        this.Login_Email_EditText = view.findViewById(R.id.Login_Email_EditText);
        this.Login_Password_EditText = view.findViewById(R.id.Login_Password_EditText);
        this.Login_Login_Button = view.findViewById(R.id.Login_Login_Button);
        this.Login_FindID_TextView = view.findViewById(R.id.Login_FindID_TextView);
        this.Login_ResetPassword_TextView = view.findViewById(R.id.Login_ResetPassword_TextView);
        this.Login_SignUp_TextView = view.findViewById(R.id.Login_SignUp_TextView);

        this.mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void initialize() {
        this.Login_Login_Button.setOnClickListener(v -> this.login());
//        this.Login_FindID_TextView.setOnClickListener(v -> this.navigateTo(R.id.action_login_to_findId));
//        this.Login_ResetPassword_TextView.setOnClickListener(v -> this.navigateTo(R.id.action_login_to_resetPassword));
        this.Login_SignUp_TextView.setOnClickListener(v -> this.navigateTo(R.id.action_fragment_sign_in_to_fragment_sign_up));
    }

    private void login() {
        String email = this.Login_Email_EditText.getText().toString();
        String password = this.Login_Password_EditText.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this.getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();

                            LoginDirections.ActionLoginToMain action = LoginDirections.actionLoginToMain(email);
                            Navigation.findNavController(getView()).navigate(action);

                            Toast.makeText(getContext(), "Login Success", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getContext(), "Login Fail", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}