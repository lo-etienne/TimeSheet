package com.example.timesheet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.timesheet.Home.HomeActivity;
import com.example.timesheet.Home.ManagedPage.ManagedPageFragment;
import com.example.timesheet.database.repository.TimesheetRepository;
import com.example.timesheet.model.Timesheet;
import com.example.timesheet.model.WorkDay;
import com.example.timesheet.timesheetdisplayer.TimesheetFragment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TimesheetDisplayerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity", "onCreate called");
        setContentView(R.layout.activity_main);
        UUID timesheetId = UUID.fromString("3019d03e-8da0-11eb-8dcd-0242ac130003");


        /*
        WorkDay monday = new WorkDay(UUID.randomUUID(), "Monday", new Date(), 6, 6, "Presence", timesheetId);
        WorkDay tuesday = new WorkDay(UUID.randomUUID(), "Tuesday", new Date(), 6, 6, "Homeworking", timesheetId);
        WorkDay wednesday = new WorkDay(UUID.randomUUID(), "Wednesday", new Date(), 6, 6, "Extraordinary leave", timesheetId);
        WorkDay thursday = new WorkDay(UUID.randomUUID(), "Thursday", new Date(), 6, 6, "Sick leave", timesheetId);
        WorkDay friday = new WorkDay(UUID.randomUUID(), "Friday", new Date(), 6, 6, "Child sick leave", timesheetId);
        WorkDay saturday = new WorkDay(UUID.randomUUID(), "Saturday", new Date(), 6, 6, "Recovery", timesheetId);
        WorkDay sunday = new WorkDay(UUID.randomUUID(), "Sunday", new Date(), 6, 6, "Vacation", timesheetId);

        List<WorkDay> workDayList  = new ArrayList<>();
        workDayList.add(monday);
        workDayList.add(tuesday);
        workDayList.add(wednesday);
        workDayList.add(thursday);
        workDayList.add(friday);
        workDayList.add(saturday);
        workDayList.add(sunday);

        TimesheetRepository.getInstance().insertWorkday(monday);
        TimesheetRepository.getInstance().insertWorkday(tuesday);
        TimesheetRepository.getInstance().insertWorkday(wednesday);
        TimesheetRepository.getInstance().insertWorkday(thursday);
        TimesheetRepository.getInstance().insertWorkday(friday);
        TimesheetRepository.getInstance().insertWorkday(saturday);
        TimesheetRepository.getInstance().insertWorkday(sunday);


        Timesheet timesheet = new Timesheet(timesheetId, "INT-1234", "Mobile Development", new Date(), 2, UUID.randomUUID(), workDayList);

        TimesheetRepository.getInstance().insertTimesheet(timesheet);



         */




        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            timesheetId = UUID.fromString(getIntent().getStringExtra("timesheetId"));
            UUID userId = UUID.fromString(getIntent().getStringExtra("userId"));
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, TimesheetFragment.newInstance(userId, timesheetId)).commit();
        }
    }

}