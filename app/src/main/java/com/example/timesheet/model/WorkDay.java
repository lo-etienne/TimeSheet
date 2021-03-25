package com.example.timesheet.model;

import androidx.room.Entity;

import java.util.Date;
import java.util.UUID;

@Entity
public class WorkDay extends Day {

    private int workingHours;
    private int notWorkingHours;
    private String status;

    private UUID timesheetId;

    public WorkDay(final UUID uuid,
                   final String name,
                   final Date date,
                   final int workingHours,
                   final int notWorkingHours,
                   final String status,
                   final UUID timesheetId) {
        super(uuid, name, date);
        this.workingHours = workingHours;
        this.notWorkingHours = notWorkingHours;
        this.status = status;
        this.timesheetId = timesheetId;
    }

    @Override
    public UUID getUuid() {
        return super.getUuid();
    }

    @Override
    public void setUuid(final UUID uuid) {
        super.setUuid(uuid);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(final String name) {
        super.setName(name);
    }

    @Override
    public Date getDate() {
        return super.getDate();
    }

    @Override
    public void setDate(final Date date) {
        super.setDate(date);
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(final int workingHours) {
        this.workingHours = workingHours;
    }

    public int getNotWorkingHours() {
        return notWorkingHours;
    }

    public void setNotWorkingHours(final int notWorkingHours) { this.notWorkingHours = notWorkingHours; }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public UUID getTimesheetId() { return timesheetId; }

    public void setTimesheetId(UUID timesheetId) { this.timesheetId = timesheetId; }
}
