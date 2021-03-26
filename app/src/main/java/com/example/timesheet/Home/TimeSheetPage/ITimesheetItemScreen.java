package com.example.timesheet.Home.TimeSheetPage;

import java.util.UUID;

public interface ITimesheetItemScreen {
    void showTimesheet(UUID timesheetId, String date, String code, String wps, int validate);
}
