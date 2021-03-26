package com.example.timesheet.timesheetdisplayer;

import androidx.lifecycle.ViewModel;

import java.util.UUID;

public class TimesheetViewModel extends ViewModel {

    private UUID timesheetId;

    public UUID getTimesheetId() {
        return timesheetId;
    }

    public void setTimesheetId(final UUID timesheetId) {
        this.timesheetId = timesheetId;
    }
}
