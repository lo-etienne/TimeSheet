package com.example.timesheet.timesheetdisplayer;

import androidx.lifecycle.Observer;

import com.example.timesheet.database.repository.TimesheetRepository;
import com.example.timesheet.model.Timesheet;
import com.example.timesheet.model.WorkDay;

import java.sql.Time;
import java.util.List;
import java.util.UUID;

public class TimesheetPresenter {

    private final ITimesheetDisplayerScreen screen;
    private Timesheet timesheet;
    private WorkDay monday;
    private WorkDay tuesday;
    private WorkDay wednesday;
    private WorkDay thursday;
    private WorkDay friday;
    private WorkDay saturday;
    private WorkDay sunday;

    public TimesheetPresenter(final ITimesheetDisplayerScreen screen) {
        this.screen = screen;
    }

    public void loadTimesheet(final UUID timesheetId) {
        this.timesheet = TimesheetRepository.getInstance().getTimesheet(timesheetId).getValue();
        List<WorkDay> workDays = TimesheetRepository.getInstance().getWorkDaysFrom(timesheetId).getValue().getWorkDays();
        for (WorkDay workDay: workDays) {
            switch (workDay.getName()) {
                case "Monday":
                    break;
                case "Tuesday":
                    break;
                case "Wednesday":
                    break;
                case "Thursday":
                        break;
            }
        }
    }

}
