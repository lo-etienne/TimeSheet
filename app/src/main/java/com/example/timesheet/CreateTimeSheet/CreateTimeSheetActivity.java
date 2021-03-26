package com.example.timesheet.CreateTimeSheet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.timesheet.R;

import java.util.UUID;

public class CreateTimeSheetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID userId = UUID.fromString(getIntent().getStringExtra("userId"));

        setContentView(R.layout.activity_create_time_sheet);
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.activity_create);

        if(currentFragment == null){
            getSupportFragmentManager().beginTransaction().add(R.id.activity_create, CreateTimeSheetFragment.newInstance(userId)).commit();
        }
    }

}