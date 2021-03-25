package com.example.timesheet.timesheetdisplayer;

import com.example.timesheet.database.repository.TimesheetRepository;
import com.example.timesheet.model.Timesheet;

import java.sql.Time;
import java.util.UUID;

public class TimesheetPresenter {

    private final ITimesheetDisplayerScreen screen;
    private Timesheet timesheet;

    public TimesheetPresenter(final ITimesheetDisplayerScreen screen) {
        this.screen = screen;
    }

    public void loadTimesheet(final UUID timesheetId) {
    }

}
