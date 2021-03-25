package com.example.timesheet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.timesheet.database.repository.TimesheetRepository;
import com.example.timesheet.model.User;

import java.util.UUID;

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

        if(TimesheetRepository.getInstance().getUser(UUID.fromString("473eab19-1ef9-467a-9e59-17ac78675d83"))  == null) {
            TimesheetRepository.getInstance().insertUser(new User(UUID.fromString("473eab19-1ef9-467a-9e59-17ac78675d83"), "Emile", "Davignon", "emiledavignon@gmail.com", "123123", true));
            TimesheetRepository.getInstance().insertUser(new User(UUID.fromString("bd963076-7a9f-4cfb-8f43-6f5509f9a922"), "Paul", "Basin", "paul.basin@gmail.com", "password", false));
        }
    }

    public void onLogin() {
        Toast.makeText(getBaseContext(), "Connexion réussie. Redirection...", Toast.LENGTH_LONG).show();

        launchHomeActivity();
    }

    private void launchHomeActivity() {
        Intent switchActivityIntent = new Intent(this, HomeActivity.class);
        /* Utilisateur : Manager */
        switchActivityIntent.putExtra("userId", "473eab19-1ef9-467a-9e59-17ac78675d83");
        switchActivityIntent.putExtra("isApprover", "1");
        /* Utilisateur : Utilisateur Simple
        switchActivityIntent.putExtra("userId", "bd963076-7a9f-4cfb-8f43-6f5509f9a922");
        switchActivityIntent.putExtra("isApprover", "0"); */
        startActivity(switchActivityIntent);
    }
}
