package com.example.timesheet.Home.TimeSheetPage;

import android.util.Log;

import androidx.lifecycle.Observer;

import com.example.timesheet.database.embeddedobjects.UserWithTimesheets;
import com.example.timesheet.database.repository.TimesheetRepository;
import com.example.timesheet.model.Timesheet;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class TimesheetsPagePresenter {

    private final UUID userId;
    private List<Timesheet> timesheets;

    private final ITimesheetsScreen screen;

    public TimesheetsPagePresenter(final UUID userId, final ITimesheetsScreen screen) {
        this.screen = screen;
        this.userId = userId;
    }

    public void loadTimesheets() {
        Log.d("TimeSheetPagePresenter", "LOADING TIMESHEETS");
        TimesheetRepository.getInstance().getTimesheetsFrom(userId).observeForever(new Observer<UserWithTimesheets>() {
            @Override
            public void onChanged(UserWithTimesheets userWithTimesheets) {
                TimesheetsPagePresenter.this.timesheets = userWithTimesheets.getTimesheets();
                Collections.reverse(TimesheetsPagePresenter.this.timesheets);
                screen.loadView();
            }
        });
    }

    public void showTimesheetOn(ITimesheetItemScreen holder, final int postion) {
        Timesheet timesheet = timesheets.get(postion);
        holder.showTimesheet(timesheet.getDate().toString(), timesheet.getWbsCode(), timesheet.getWbsDescription(), timesheet.getStatus());
    }

    public int getItemCount() {
        if(timesheets == null) {
            return 0;
        }
        return timesheets.size();
    }
}
