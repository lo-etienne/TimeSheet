package com.example.timesheet.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Embedded;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.SkipQueryVerification;
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


    @Query("SELECT * FROM Timesheet WHERE timesheetId = (:timesheetId)")
    public abstract LiveData<Timesheet> getTimesheet(final UUID timesheetId);

    @Query("SELECT * FROM Timesheet WHERE timesheetId = (:timesheetId)")
    public abstract Timesheet getTimesheetObject(final UUID timesheetId);

    @Query("SELECT COUNT(timesheetId) FROM Timesheet WHERE timesheetId = (:timesheetId)")
    public abstract int hasTimesheet(final UUID timesheetId);

    @Query("SELECT COUNT(uuid) FROM WorkDay WHERE uuid = (:uuid)")
    public abstract int hasWorkday(final UUID uuid);

    @Query("SELECT COUNT(userId) FROM User WHERE userId = (:userId)")
    public abstract int hasUser(final UUID userId);


    @Transaction
    @Query("SELECT * FROM User WHERE userId = (:userId)")
    public abstract LiveData<UserWithTimesheets> getTimesheetsFrom(final UUID userId);

    @Transaction
    @Query("SELECT * FROM Timesheet WHERE timesheetId = (:timesheetId)")
    public abstract LiveData<TimesheetWithWorkDays> getWorkDaysFrom(final UUID timesheetId);

    @Query("SELECT * FROM Timesheet WHERE userId != (:userId) AND status = 1")
    public abstract LiveData<List<Timesheet>> getTimesheetToApprouveFrom(final UUID userId);

    @Query("SELECT * FROM Timesheet WHERE userId != (:userId) AND status = 2")
    public abstract LiveData<List<Timesheet>> getTimesheetApprouvedFrom(final UUID userId);

    @Query("SELECT * FROM User WHERE email = (:mail) AND password = (:pass)")
    public abstract LiveData<User> getUserByMailAndPass(final String mail, final String pass);

    @Query("SELECT * FROM User")
    public abstract LiveData<List<User>> getAllUsers();

    // INSERT
    @Insert
    public abstract void insertUser(final User user);

    @Insert
    public abstract void insertTimesheet(final Timesheet timesheet);

    @Insert
    public abstract void insertWorkDay(final WorkDay workDay);

    // UPDATE

    @Update
    public abstract void updateUser(final User user);

    @Update
    public abstract void updateTimesheet(final Timesheet timesheet);

    @Update
    public abstract void updateWorkDay(final WorkDay workDay);

    // DELETE

    @Delete
    public abstract void deleteUser(final User user);

    @Delete
    public abstract void deleteTimesheet(final Timesheet timesheet);

    @Delete
    public abstract void deleteWorkDay(final WorkDay workDay);

    @Query("DELETE FROM WORKDAY WHERE timesheetId = (:timesheetId)")
    public abstract void deleteWorkdaysByTimesheetId(final UUID timesheetId);

    @Query("DELETE FROM Timesheet WHERE timesheetId = (:timesheetId)")
    public abstract void deleteTimesheetById(final UUID timesheetId);



    @Transaction
    public void deleteTimesheetAndWorkdays(final UUID timesheetId) {
        deleteWorkdaysByTimesheetId(timesheetId);
        deleteTimesheetById(timesheetId);
    }

    @Transaction
    public void populateDatabse(List<User> users, List<WorkDay> workDays, List<Timesheet> timesheets) {
        for (User user: users) {
            if(hasUser(user.getUserId()) == 0) {
                insertUser(user);
            }
        }
        for (WorkDay day : workDays) {
            if(hasWorkday(day.getUuid()) == 0) {
                insertWorkDay(day);
            }
        }
        for (Timesheet timesheet : timesheets) {
            if(hasTimesheet(timesheet.getTimesheetId()) == 0) {
                insertTimesheet(timesheet);
            }
        }
    }
}
