package com.example.timesheet.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.timesheet.database.dao.TimesheetDao;
import com.example.timesheet.model.Holiday;
import com.example.timesheet.model.Timesheet;
import com.example.timesheet.model.User;
import com.example.timesheet.model.WorkDay;

@Database(entities = {User.class, Timesheet.class, WorkDay.class, Holiday.class}, version=1, exportSchema = false)
@TypeConverters({TimesheetTypeConverters.class})
public abstract class TimesheetDatabase extends RoomDatabase {

    private static final String DB_NAME = "timesheet_database";
    private static TimesheetDatabase instance;

    public abstract TimesheetDao timesheetDao();

    public static void initDatabase(final Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), TimesheetDatabase.class, DB_NAME).build();
        }
    }

    public static TimesheetDatabase getInstance() {
        if(instance == null) {
            throw new IllegalStateException("Timesheet database must be initialized");
        }
        return instance;
    }

    public static void disconnectDatabase() {
        instance = null;
    }

}
