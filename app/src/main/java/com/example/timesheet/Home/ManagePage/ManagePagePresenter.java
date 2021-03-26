package com.example.timesheet.Home.ManagePage;

import android.util.Log;

import androidx.lifecycle.Observer;

import com.example.timesheet.Home.TimeSheetPage.ITimesheetItemScreen;
import com.example.timesheet.Home.TimeSheetPage.ITimesheetsScreen;
import com.example.timesheet.Home.TimeSheetPage.TimesheetsPagePresenter;
import com.example.timesheet.database.embeddedobjects.UserWithTimesheets;
import com.example.timesheet.database.repository.TimesheetRepository;
import com.example.timesheet.model.Timesheet;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ManagePagePresenter {
    private final UUID userId;
    private List<Timesheet> timesheets;

    private final IManageScreen screen;

    public ManagePagePresenter(final UUID userId, final IManageScreen screen) {
        this.screen = screen;
        this.userId = userId;
    }

    public void loadTimesheets() {
        Log.d("TimeSheetPagePresenter", "LOADING TIMESHEETS");
        TimesheetRepository.getInstance().getTimesheetToApprouveFrom(userId).observeForever(new Observer<List<Timesheet>>() {
            @Override
            public void onChanged(List<Timesheet> timesheets) {
                ManagePagePresenter.this.timesheets = timesheets;
                Collections.reverse(ManagePagePresenter.this.timesheets);
                screen.loadView();
            }
        });
    }

    public void showTimesheetOn(IManageItemScreen holder, final int postion) {
        Timesheet timesheet = timesheets.get(postion);
        SimpleDateFormat shortDateFormat = new SimpleDateFormat("dd/MM/yy");
        String dateString = shortDateFormat.format(timesheet.getDate());
        holder.showTimesheet(timesheet.getTimesheetId(), dateString, timesheet.getWbsCode(), timesheet.getWbsDescription(), timesheet.getStatus());
    }

    public int getItemCount() {
        if(timesheets == null) {
            return 0;
        }
        return timesheets.size();
    }
}
