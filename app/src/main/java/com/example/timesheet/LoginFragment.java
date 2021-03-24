package com.example.timesheet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

public class LoginFragment extends Fragment {

    private TextInputLayout usernameEditText;
    private TextInputLayout passwordEditText;
    private Button loginButton; /* Changer en MaterialButton */

    public LoginFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        usernameEditText = view.findViewById(R.id.login_email);
        passwordEditText = view.findViewById(R.id.login_password);
        loginButton = view.findViewById(R.id.login_submit);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    public static LoginFragment getInstance() {
        return new LoginFragment();
    }
}
