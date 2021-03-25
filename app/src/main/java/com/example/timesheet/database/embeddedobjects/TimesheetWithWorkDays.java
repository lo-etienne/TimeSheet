package com.example.timesheet.database.embeddedobjects;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.timesheet.model.Timesheet;
import com.example.timesheet.model.WorkDay;

import java.util.ArrayList;
import java.util.List;

public class TimesheetWithWorkDays {

    @Embedded
    public Timesheet timesheet;
    @Relation(
            parentColumn = "timesheetId",
            entityColumn = "timesheetId"
    )

    private List<WorkDay> workDays = new ArrayList<WorkDay>();

    public List<WorkDay> getWorkDays() {
        return workDays;
    }

    public void setWorkDays(final List<WorkDay> workDays) {
        this.workDays.clear();
        this.workDays.addAll(workDays);
    }
}
