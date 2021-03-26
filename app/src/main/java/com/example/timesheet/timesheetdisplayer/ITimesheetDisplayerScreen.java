package com.example.timesheet.timesheetdisplayer;

import com.example.timesheet.model.WorkDay;

import java.util.Date;

public interface ITimesheetDisplayerScreen {
    void showTimesheet(final String wbsData,
                       final Date date,
                       final int status,
                       final String mondayStatus,
                       final String mondayHoursWorked,
                       final String mondayHoursNotWorked,
                       final String tuesdayStatus,
                       final String tuesdayHoursWorked,
                       final String tuesdayHoursNotWorked,
                       final String wednesdayStatus,
                       final String wednesdayHoursWorked,
                       final String wednesdayHoursNotWorked,
                       final String thursdayStatus,
                       final String thursdayHoursWorked,
                       final String thursdayHoursNotWorked,
                       final String fridayStatus,
                       final String fridayHoursWorked,
                       final String fridayHoursNotWorked,
                       final String saturdayStatus,
                       final String saturdayHoursWorked,
                       final String saturdayHoursNotWorked,
                       final String sundayStatus,
                       final String sundayHoursWorked,
                       final String sundayHoursNotWorked);
}
