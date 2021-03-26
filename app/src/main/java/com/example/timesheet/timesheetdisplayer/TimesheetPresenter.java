package com.example.timesheet.timesheetdisplayer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.timesheet.Home.HomeActivity;
import com.example.timesheet.database.embeddedobjects.TimesheetWithWorkDays;
import com.example.timesheet.database.repository.TimesheetRepository;
import com.example.timesheet.model.Timesheet;
import com.example.timesheet.model.WorkDay;

import java.sql.Time;
import java.util.List;
import java.util.UUID;

public class TimesheetPresenter {

    private final ITimesheetDisplayerScreen screen;
    private UUID userId;
    private Timesheet timesheet;
    private WorkDay monday;
    private WorkDay tuesday;
    private WorkDay wednesday;
    private WorkDay thursday;
    private WorkDay friday;
    private WorkDay saturday;
    private WorkDay sunday;

    public TimesheetPresenter(final ITimesheetDisplayerScreen screen, final UUID userId) {
        this.screen = screen;
        this.userId = userId;
    }

    public void loadTimesheet(UUID timesheetId) {
        Log.d("PRESENTER", "LOAD TIMESHEET");
        TimesheetRepository.getInstance().getTimesheet(timesheetId).observeForever(new Observer<Timesheet>() {
            @Override
            public void onChanged(Timesheet timesheet) {

                if (timesheet != null) {
                    TimesheetPresenter.this.timesheet = timesheet;

                    List<WorkDay> workDays = TimesheetPresenter.this.timesheet.getDays();
                    for (WorkDay workDay : workDays) {

                        switch (workDay.getName()) {
                            case "Monday":
                                TimesheetPresenter.this.monday = workDay;
                                break;
                            case "Tuesday":
                                TimesheetPresenter.this.tuesday = workDay;
                                break;
                            case "Wednesday":
                                TimesheetPresenter.this.wednesday = workDay;
                                break;
                            case "Thursday":
                                TimesheetPresenter.this.thursday = workDay;
                                break;
                            case "Friday":
                                TimesheetPresenter.this.friday = workDay;
                                break;
                            case "Saturday":
                                TimesheetPresenter.this.saturday = workDay;
                                break;
                            case "Sunday":
                                TimesheetPresenter.this.sunday = workDay;
                                break;
                        }
                    }
                    screen.showTimesheet(TimesheetPresenter.this.timesheet.getWbsDescription() + TimesheetPresenter.this.timesheet.getWbsCode(),
                            timesheet.getCountry(),
                            timesheet.getDate(),
                            timesheet.getStatus(),
                            monday.getStatus(),
                            Integer.toString(monday.getWorkingHours()),
                            Integer.toString(monday.getNotWorkingHours()),
                            tuesday.getStatus(),
                            Integer.toString(tuesday.getWorkingHours()),
                            Integer.toString(tuesday.getNotWorkingHours()),
                            wednesday.getStatus(),
                            Integer.toString(wednesday.getWorkingHours()),
                            Integer.toString(wednesday.getNotWorkingHours()),
                            thursday.getStatus(),
                            Integer.toString(thursday.getWorkingHours()),
                            Integer.toString(thursday.getNotWorkingHours()),
                            friday.getStatus(),
                            Integer.toString(friday.getWorkingHours()),
                            Integer.toString(friday.getNotWorkingHours()),
                            saturday.getStatus(),
                            Integer.toString(saturday.getWorkingHours()),
                            Integer.toString(saturday.getNotWorkingHours()),
                            sunday.getStatus(),
                            Integer.toString(sunday.getWorkingHours()),
                            Integer.toString(sunday.getNotWorkingHours()));
                }
            }
        });
    }

    public void initTimesheetSuppression(final Activity activity, final Context context) {
        if (timesheet.getStatus() == 2) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setCancelable(true);
            builder.setTitle("Unable to delete");
            builder.setMessage("This timesheet has been approved by a manager and cannot be deleted.");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setCancelable(true);
            builder.setTitle("Are you sure you want to delete this timesheet?");
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    TimesheetRepository.getInstance().deleteTimesheetAndWorkdays(timesheet.getTimesheetId());
                    Intent intent = new Intent(context, HomeActivity.class);
                    intent.putExtra("userId", userId.toString());
                    context.startActivity(intent);
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}
