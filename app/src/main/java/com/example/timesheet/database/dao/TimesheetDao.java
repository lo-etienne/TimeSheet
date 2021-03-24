package com.example.timesheet.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.timesheet.database.embeddedobjects.TimesheetWithWorkDays;
import com.example.timesheet.database.embeddedobjects.UserWithTimesheets;
import com.example.timesheet.model.User;
import com.example.timesheet.model.Timesheet;
import com.example.timesheet.model.WorkDay;
import com.example.timesheet.model.Holiday;

import java.util.List;
import java.util.UUID;

@Dao
public abstract class TimesheetDao {

    // SELECT

    @Query("SELECT * FROM User WHERE userId = (:userId)")
    public abstract LiveData<User> getUser(final UUID userId);

    @Query("SELECT * FROM Timesheet WHERE userId = (:userId)")
    public abstract LiveData<UserWithTimesheets> getTimesheetsFrom(final UUID userId);

    @Query("SELECT * FROM WorkDay WHERE timesheetId = (:timesheetId)")
    public abstract LiveData<TimesheetWithWorkDays> getWordDaysFrom(final UUID timesheetId);

    // INSERT

    @Insert
    public abstract void insertUser(final User user);

    @Insert
    public abstract void insertTimesheet(final Timesheet timesheet);

    @Insert
    public abstract void insertWorkDays(final WorkDay workDay);

    // UPDATE

    @Update
    public abstract void updateUser(final User user);

    @Update
    public abstract void updateTimesheet(final Timesheet timesheet);

    @Update
    public abstract void updateWorkDays(final WorkDay workDay);

    // DELETE

    @Delete
    public abstract void deleteUser(final User user);

    @Delete
    public abstract void deleteTimesheet(final Timesheet timesheet);

    @Delete
    public abstract void deleteWorkDays(final WorkDay workDay);

    @Query("DELETE FROM WORKDAY WHERE timesheetId = (:timesheetId)")
    public abstract void deleteWorkdaysByTimesheetId(final UUID timesheetId);

    @Query("DELETE FROM Timesheet WHERE timesheetId = (:timesheetId)")
    public abstract void deleteTimesheetById(final UUID timesheetId);

    @Transaction
    public void deleteTimesheetAndWorkdays(final UUID timesheetId) {
        deleteWorkdaysByTimesheetId(timesheetId);
        deleteTimesheetById(timesheetId);
    }

}
