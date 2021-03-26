package com.example.timesheet.Home.ManagedPage;

import android.util.Log;

import androidx.lifecycle.Observer;


import com.example.timesheet.Home.ManagedPage.IManagedItemScreen;
import com.example.timesheet.Home.ManagedPage.IManagedScreen;
import com.example.timesheet.database.repository.TimesheetRepository;
import com.example.timesheet.model.Timesheet;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ManagedPagePresenter {
    private final UUID userId;
    private List<Timesheet> timesheets;

    private final IManagedScreen screen;

    public ManagedPagePresenter(final UUID userId, final IManagedScreen screen) {
        this.screen = screen;
        this.userId = userId;
    }

    public void loadTimesheets() {
        Log.d("TimeSheetPagePresenter", "LOADING TIMESHEETS");
        TimesheetRepository.getInstance().getTimesheetApprouvedFrom(userId).observeForever(new Observer<List<Timesheet>>() {
            @Override
            public void onChanged(List<Timesheet> timesheets) {
                ManagedPagePresenter.this.timesheets = timesheets;
                Collections.reverse(ManagedPagePresenter.this.timesheets);
                screen.loadView();
            }
        });
    }

    public void showTimesheetOn(IManagedItemScreen holder, final int postion) {
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
