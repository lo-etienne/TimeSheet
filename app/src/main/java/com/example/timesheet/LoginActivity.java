package com.example.timesheet;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("LoginActivity", "onCreate called");

        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.login_fragment_container);
        if(currentFragment == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.login_fragment_container, LoginFragment.getInstance()).commit();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }
}
