package com.example.timesheet.database;

import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

public class TimesheetTypeConverters {

    @TypeConverter
    public String temp(int a) {
        return "a";
    }

}
