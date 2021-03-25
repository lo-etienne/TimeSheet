package com.example.timesheet;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class LoginActivity extends AppCompatActivity implements LoginFragment.ILogIn {

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
    public void onLogin() {
        Toast.makeText(getBaseContext(), "Connexion réussie. Redirection...", Toast.LENGTH_LONG).show();

        launchHomeActivity();
    }

    private void launchHomeActivity() {
        /*Intent switchActivityIntent = new Intent(this, HomeActivity.class);
        switchActivityIntent.putExtra("userId", "473eab19-1ef9-467a-9e59-17ac78675d83");
        switchActivityIntent.putExtra("isApprover", "1");
        startActivity(switchActivityIntent);*/
    }
}
