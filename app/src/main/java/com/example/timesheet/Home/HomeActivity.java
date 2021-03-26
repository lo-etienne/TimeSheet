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
        UUID timesheetId = UUID.fromString("3019d03e-8da0-11eb-8dcd-0242ac130000");
        UUID timesheetId1 = UUID.fromString("3019d03e-8da0-11eb-8dcd-0242ac130004");
        UUID timesheetId2 = UUID.fromString("3019d03e-8da0-11eb-8dcd-0242ac130005");
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


        Timesheet timesheet = new Timesheet(timesheetId, "INT-1", "Final", "Belgium", new Date(), 1, UUID.randomUUID(), workDayList);
        Timesheet timesheet2 = new Timesheet(timesheetId1, "INT-1234", "j'en ai marre", "Luxembourg", new Date(), 2, UUID.randomUUID(), workDayList);
        Timesheet timesheet3 = new Timesheet(timesheetId2, "INT-123", "c'est bientot fini","Belgium", new Date(), 2, UUID.randomUUID(), workDayList);

        TimesheetRepository.getInstance().insertTimesheet(timesheet);
        TimesheetRepository.getInstance().insertTimesheet(timesheet2);
        TimesheetRepository.getInstance().insertTimesheet(timesheet3);*/
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
