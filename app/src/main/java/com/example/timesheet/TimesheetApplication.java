package com.example.timesheet;

import android.app.Application;
import android.util.Log;

import com.example.timesheet.database.TimesheetDatabase;

public class TimesheetApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("DataBase","Create called");
        TimesheetDatabase.initDatabase(getBaseContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        TimesheetDatabase.disconnectDatabase();
    }

}
