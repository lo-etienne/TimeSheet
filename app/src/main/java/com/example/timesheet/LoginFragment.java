package com.example.timesheet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;

public class LoginFragment extends Fragment {

    private LoginPresenter presenter;

    private TextView errorMessage;
    private TextInputLayout usernameEditText;
    private TextInputLayout passwordEditText;
    private Button loginButton;

    public LoginFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new LoginPresenter();
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

        errorMessage = view.findViewById(R.id.login_error_message);
        usernameEditText = view.findViewById(R.id.login_email);
        passwordEditText = view.findViewById(R.id.login_password);
        loginButton = view.findViewById(R.id.login_submit);
    }

    @Override
    public void onStart() {
        super.onStart();

        presenter.startDB();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = usernameEditText.getEditText().getText().toString();
                String pass = passwordEditText.getEditText().getText().toString();

                if(presenter.areCredentialsValid(mail, pass)) {
                    ((LoginActivity)getActivity()).onLogin(/* Passer l'id de l'user + manager ou non */);
                } else {
                    errorMessage.setVisibility(View.VISIBLE);

                    errorMessage.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            errorMessage.setVisibility(View.GONE);
                        }
                    }, 5000);
                }
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        presenter.insertUsersInDB();
    }

    public static LoginFragment getInstance() {
        return new LoginFragment();
    }
}
