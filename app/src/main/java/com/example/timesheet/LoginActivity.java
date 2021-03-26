package com.example.timesheet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.timesheet.Home.HomeActivity;
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
        /*TimesheetRepository.getInstance().insertUser(new User(UUID.fromString("473eab19-1ef9-467a-9e59-17ac78675d83"), "Emile", "Davignon", true,"emiledavignon@gmail.com", "123123"));
        TimesheetRepository.getInstance().insertUser(new User(UUID.fromString("bd963076-7a9f-4cfb-8f43-6f5509f9a922"), "Paul", "Basin", false, "paul.basin@gmail.com", "password"));*/
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.login_fragment_container);
        if(currentFragment == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.login_fragment_container, LoginFragment.getInstance()).commit();
        }
    }
}
