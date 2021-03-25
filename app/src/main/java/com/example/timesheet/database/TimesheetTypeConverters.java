package com.example.timesheet.database;

import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.example.timesheet.model.WorkDay;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TimesheetTypeConverters {

    @TypeConverter
    public String fromUUIDtoString(UUID uuid) {
        return uuid.toString();
    }

    @TypeConverter
    public UUID toUUID(String uuid) {
        return UUID.fromString(uuid);
    }

    @TypeConverter
    public long fromDate(Date date) { return date.getTime(); }

    @TypeConverter
    public Date toDate(long date) {
        return new Date(date);
    }

    @TypeConverter
    public static List<WorkDay> stringToSomeObjectList(String data) {
        Gson gson = new Gson();

        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<WorkDay>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String someObjectListToString(List<WorkDay> someObjects) {
        Gson gson = new Gson();

        return gson.toJson(someObjects);
    }

}
