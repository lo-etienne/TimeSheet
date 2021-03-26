package com.example.timesheet.Home.ManagePage;

import java.util.UUID;

public interface IManageItemScreen {
    void showTimesheet(UUID timesheetId, String date, String code, String wps, int validate);
}
