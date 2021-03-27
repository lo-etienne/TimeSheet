package com.example.timesheet.Home;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.timesheet.Home.ManagedPage.ManagedPageFragment;
import com.example.timesheet.Home.TimeSheetPage.TimesheetsPageFragment;
import com.example.timesheet.TimesheetDisplayerActivity;
import com.example.timesheet.R;
import com.example.timesheet.database.repository.TimesheetRepository;
import com.example.timesheet.model.Timesheet;
import com.example.timesheet.model.WorkDay;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class HomeActivity extends AppCompatActivity implements ManagedPageFragment.ISelectedTimesheet {
    private UUID userId;
    private Boolean isManager = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Date date = new Date();
        date.setTime(System.currentTimeMillis());
        userId = UUID.fromString(getIntent().getStringExtra("userId"));
        isManager = getIntent().getBooleanExtra("isManager", false);

        setContentView(R.layout.activity_home);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.home_fragment_container);

        if(currentFragment == null) {
            if(isManager)
                getSupportFragmentManager().beginTransaction().add(R.id.home_fragment_container, HomeCollectionFragment.newInstance(true, userId)).commit();
            else
                getSupportFragmentManager().beginTransaction().add(R.id.home_fragment_container, TimesheetsPageFragment.newInstance(userId)).commit();
        }
    }

    @Override
    public void onSelectedTimesheet(UUID timesheetId) {
        Intent intent = new Intent(this, TimesheetDisplayerActivity.class);
        intent.putExtra("timesheetId", timesheetId.toString());
        intent.putExtra("userId", userId.toString());
        startActivity(intent);
    }
}
