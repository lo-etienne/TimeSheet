package com.example.timesheet;

import android.app.Application;

import com.example.timesheet.database.TimesheetDatabase;

public class TimesheetApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TimesheetDatabase.initDatabase(getBaseContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        TimesheetDatabase.disconnectDatabase();
    }

}
