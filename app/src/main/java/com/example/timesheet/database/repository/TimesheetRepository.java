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
        return timesheetDao.getUser(userId);
    }

    @Override
    public LiveData<Timesheet> getTimesheet(UUID timesheetId) {
        return timesheetDao.getTimesheet(timesheetId);
    }

    @Override
    public Timesheet getTimesheetObject(UUID timesheetId) {
        return null;
    }

    @Override
    public LiveData<UserWithTimesheets> getTimesheetsFrom(UUID userId) {
        return timesheetDao.getTimesheetsFrom(userId);
    }

    @Override
    public LiveData<TimesheetWithWorkDays> getWorkDaysFrom(UUID timesheetId) {
        return timesheetDao.getWorkDaysFrom(timesheetId);
    }

    @Override
    public void insertUser(final User user) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                timesheetDao.insertUser(user);
            }
        });
    }

    @Override
    public void insertTimesheet(final Timesheet timesheet) {
       executor.execute(new Runnable() {
           @Override
           public void run() {
               timesheetDao.insertTimesheet(timesheet);
           }
       });

    }

    @Override
    public void insertWorkday(final WorkDay workDay) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                timesheetDao.insertWorkDay(workDay);
            }
        });
    }

    @Override
    public void updateUser(final User user) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                timesheetDao.updateUser(user);
            }
        });
    }

    @Override
    public void updateTimesheet(final Timesheet timesheet) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                timesheetDao.updateTimesheet(timesheet);
            }
        });

    }

    @Override
    public void updateWorkDay(final WorkDay workDay) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                timesheetDao.updateWorkDay(workDay);
            }
        });
    }

    @Override
    public LiveData<User> getUserByMailAndPass(String mail, String pass) { return timesheetDao.getUserByMailAndPass(mail, pass); }


    @Override
    public void deleteUser(final User user) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                timesheetDao.deleteUser(user);
            }
        });

    }

    @Override
    public void deleteTimesheet(final Timesheet timesheet) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                timesheetDao.deleteTimesheet(timesheet);
            }
        });

    }

    @Override
    public void deleteWorkDay(final WorkDay workDay) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                timesheetDao.deleteWorkDay(workDay);
            }
        });

    }

    @Override
    public void deleteTimesheetAndWorkdays(final UUID timesheetId) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                timesheetDao.deleteTimesheetAndWorkdays(timesheetId);
            }
        });
    }

    @Override
    public void getAllUsers() {
        timesheetDao.getAllUsers();
    }
}
