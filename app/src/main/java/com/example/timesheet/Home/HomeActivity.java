package com.example.timesheet.Home;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.timesheet.R;
import com.example.timesheet.database.repository.IRepository;
import com.example.timesheet.database.repository.TimesheetRepository;
import com.example.timesheet.model.Timesheet;
import com.example.timesheet.model.WorkDay;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Date date = new Date();
        date.setTime(System.currentTimeMillis());
        UUID userId = UUID.fromString(getIntent().getStringExtra("userId"));
        /*
        Timesheet timesheet = new Timesheet(UUID.randomUUID(), "INT-001016", "TM_CNS-Capital EndGame", date, 2, UUID.randomUUID(), new ArrayList<WorkDay>());
        Timesheet timesheet2 = new Timesheet(UUID.randomUUID(), "INT-001017", "TM_CNS-Capital Duel", date, 0, UUID.fromString("473eab19-1ef9-467a-9e59-17ac78675d83"), new ArrayList<WorkDay>());
        TimesheetRepository.getInstance().insertTimesheet(timesheet);
        TimesheetRepository.getInstance().insertTimesheet(timesheet2);*/
        setContentView(R.layout.activity_home);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.home_fragment_container);
        if(currentFragment == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.home_fragment_container, HomeCollectionFragment.newInstance(true, userId)).commit();
        }
    }
}
