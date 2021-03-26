package com.example.timesheet.Home.ManagedPage;

import java.util.UUID;

public interface IManagedItemScreen {
    void showTimesheet(UUID timesheetId, String date, String code, String wps, int validate);
}
