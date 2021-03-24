package com.example.timesheet.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
public class Timesheet {

    @PrimaryKey
    private UUID timesheetId;
    private String wbsCode;
    private String wbsDescription;
    private Date date;
    private int status;

    private UUID userId;

    private List<WorkDay> days;

    public Timesheet(final UUID timesheetId,
                     final String wbsCode,
                     final String wbsDescroption,
                     final Date date,
                     final int status,
                     final UUID userId,
                     final List<WorkDay> days) {
        this.timesheetId = timesheetId;
        this.wbsCode = wbsCode;
        this.wbsDescription = wbsDescroption;
        this.date = date;
        this.userId = userId;
        this.days.addAll(days);
    }

    public UUID getTimesheetId() {
        return timesheetId;
    }

    public void setTimesheetId(final UUID timesheetId) {
        this.timesheetId = timesheetId;
    }

    public String getWbsCode() {
        return wbsCode;
    }

    public void setWbsCode(final String wbsCode) {
        this.wbsCode = wbsCode;
    }

    public String getWbsDescription() {
        return wbsDescription;
    }

    public void setWbsDescription(final String wbsDescription) {
        this.wbsDescription = wbsDescription;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(final int status) {
        this.status = status;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(final UUID userId) {
        this.userId = userId;
    }

    public List<WorkDay> getDays() {
        return days;
    }

    public void setDays(List<WorkDay> days) {
        this.days.clear();
        this.days.addAll(days);
    }

}
