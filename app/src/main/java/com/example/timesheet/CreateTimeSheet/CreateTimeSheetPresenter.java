package com.example.timesheet.CreateTimeSheet;

import com.example.timesheet.database.repository.TimesheetRepository;
import com.example.timesheet.model.Day;
import com.example.timesheet.model.Timesheet;
import com.example.timesheet.model.WorkDay;

public class CreateTimeSheetPresenter {

    public CreateTimeSheetPresenter(){
    }

    public void addNewTimeSheet(Timesheet timeSheet){
        TimesheetRepository repository = new TimesheetRepository();
        repository.insertTimesheet(timeSheet);
    }

    public void addNewDay(WorkDay workDay){
        TimesheetRepository repository = new TimesheetRepository();
        repository.insertWorkday(workDay);
    }
}
