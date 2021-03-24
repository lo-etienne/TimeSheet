package com.example.timesheet.database.embeddedobjects;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.timesheet.model.Timesheet;
import com.example.timesheet.model.User;

import java.util.List;

public class UserWithTimesheets {

    @Embedded
    public User user;

    @Relation(
            parentColumn = "userId",
            entityColumn = "userId"
    )


    private List<Timesheet> timesheets;

    public List<Timesheet> getTimesheets() {
        return timesheets;
    }

    public void setTimesheets(final List<Timesheet> timesheets) {
        this.timesheets.clear();
        this.timesheets.addAll(timesheets);
    }
}
