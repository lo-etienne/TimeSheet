package com.example.timesheet.database.repository;

import androidx.lifecycle.LiveData;

import com.example.timesheet.database.embeddedobjects.TimesheetWithWorkDays;
import com.example.timesheet.database.embeddedobjects.UserWithTimesheets;
import com.example.timesheet.model.Timesheet;
import com.example.timesheet.model.User;
import com.example.timesheet.model.WorkDay;

import java.util.List;
import java.util.UUID;

public interface IRepository {

    LiveData<User> getUser(final UUID userId);
    LiveData<Timesheet> getTimesheet(final UUID timesheetId);
    Timesheet getTimesheetObject(final UUID timesheetId);
    LiveData<UserWithTimesheets> getTimesheetsFrom(final UUID userId);
    LiveData<TimesheetWithWorkDays> getWorkDaysFrom(final UUID timesheetId);
    LiveData<User> getUserByMailAndPass(final String mail, final String pass);
    LiveData<List<Timesheet>> getTimesheetToApprouveFrom(UUID userId);
    LiveData<List<Timesheet>> getTimesheetApprouvedFrom(UUID userId);

    void insertUser(final User user);
    void insertTimesheet(final Timesheet timesheet);
    void insertWorkday(final WorkDay workDay);

    void updateUser(final User user);
    void updateTimesheet(final Timesheet timesheet);
    void updateWorkDay(final WorkDay workDay);

    void deleteUser(final User user);
    void deleteTimesheet(final Timesheet timesheet);
    void deleteWorkDay(final WorkDay workDay);
    void deleteTimesheetAndWorkdays(final UUID timesheetId);
    void getAllUsers();

    void populateDatabase(final List<User> users, final List<WorkDay> workDays, final List<Timesheet> timesheets);

    /*
    int hasUser(final UUID userId);
    int hasTimesheet(final UUID timesheetId);
    int hasWorkday(final UUID workdayId);

     */
}
