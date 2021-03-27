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




       /*

        TimesheetRepository.getInstance().insertWorkday(monday);
        TimesheetRepository.getInstance().insertWorkday(tuesday);
        TimesheetRepository.getInstance().insertWorkday(wednesday);
        TimesheetRepository.getInstance().insertWorkday(thursday);
        TimesheetRepository.getInstance().insertWorkday(friday);
        TimesheetRepository.getInstance().insertWorkday(saturday);
        TimesheetRepository.getInstance().insertWorkday(sunday);


        Timesheet timesheet = new Timesheet(timesheetId, "INT-178", "Final sprint", "Belgium", new Date(), 0, UUID.fromString("bd963076-7a9f-4cfb-8f43-6f5509f9a922"), workDayList);
        Timesheet timesheet1 = new Timesheet(timesheetId1, "INT-12347", "Meeting with client", "France", new Date(), 2, UUID.fromString("bd963076-7a9f-4cfb-8f43-6f5509f9a922"), workDayList);
        Timesheet timesheet2 = new Timesheet(timesheetId2, "INT-1263", "Finish project","Belgium", new Date(), 2, UUID.fromString("bd963076-7a9f-4cfb-8f43-6f5509f9a922"), workDayList);
        Timesheet timesheet3 = new Timesheet(timesheetId3, "INT-12738", "Begin project","Belgium", new Date(), 1, UUID.fromString("bd963076-7a9f-4cfb-8f43-6f5509f9a922"), workDayList);

        TimesheetRepository.getInstance().insertTimesheet(timesheet);
        TimesheetRepository.getInstance().insertTimesheet(timesheet1);
        TimesheetRepository.getInstance().insertTimesheet(timesheet2);
        TimesheetRepository.getInstance().insertTimesheet(timesheet3);
        
 */
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
