package com.example.timesheet.database.repository;

import androidx.lifecycle.LiveData;

import com.example.timesheet.database.TimesheetDatabase;
import com.example.timesheet.database.dao.TimesheetDao;
import com.example.timesheet.database.embeddedobjects.TimesheetWithWorkDays;
import com.example.timesheet.database.embeddedobjects.UserWithTimesheets;
import com.example.timesheet.model.Timesheet;
import com.example.timesheet.model.User;
import com.example.timesheet.model.WorkDay;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TimesheetRepository implements IRepository {

    public static TimesheetRepository instance;

    private final TimesheetDao timesheetDao = TimesheetDatabase.getInstance().timesheetDao();
    private final ExecutorService executor = Executors.newFixedThreadPool(10);

    public static TimesheetRepository getInstance() {
        if(instance == null) {
            instance = new TimesheetRepository();
        }
        return instance;
    }

    @Override
    public LiveData<User> getUser(UUID userId) {
        return instance.getUser(userId);
    }

    @Override
    public LiveData<UserWithTimesheets> getTimesheetsFrom(UUID userId) {
        return instance.getTimesheetsFrom(userId);
    }

    @Override
    public LiveData<TimesheetWithWorkDays> getWorkDaysFrom(UUID timesheetId) {
        return instance.getWorkDaysFrom(timesheetId);
    }

    @Override
    public void insertUser(User user) {
        instance.insertUser(user);
    }

    @Override
    public void insertTimesheet(Timesheet timesheet) {
        instance.insertTimesheet(timesheet);
    }

    @Override
    public void insertWorkday(WorkDay workDay) {
        instance.insertWorkday(workDay);
    }

    @Override
    public void updateUser(User user) {
        instance.updateUser(user);
    }

    @Override
    public void updateTimesheet(Timesheet timesheet) {
        instance.updateTimesheet(timesheet);
    }

    @Override
    public void updateWorkDays(WorkDay workDay) {
        instance.insertWorkday(workDay);
    }

    @Override
    public void deleteUser(User user) {
        instance.deleteUser(user);
    }

    @Override
    public void deleteTimesheet(Timesheet timesheet) {
        instance.deleteTimesheet(timesheet);
    }

    @Override
    public void deleteWorkDay(WorkDay workDay) {
        instance.deleteWorkDay(workDay);
    }

    @Override
    public void deleteTimesheetAndWorkdays(UUID timesheetId) {
        instance.deleteTimesheetAndWorkdays(timesheetId);
    }
}
