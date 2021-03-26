package com.example.timesheet.timesheetdisplayer;

import androidx.lifecycle.ViewModel;

import java.util.UUID;

public class TimesheetViewModel extends ViewModel {

    private UUID userId;
    private UUID timesheetId;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getTimesheetId() {
        return timesheetId;
    }

    public void setTimesheetId(final UUID timesheetId) {
        this.timesheetId = timesheetId;
    }
}
