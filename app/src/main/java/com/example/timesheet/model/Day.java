package com.example.timesheet.model;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.UUID;


public abstract class Day {

    @PrimaryKey
    @NonNull
    private UUID uuid;
    private String name;
    private Date date;

    public Day(final UUID uuid, final String name, final Date date) {
        this.uuid = uuid;
        this.name = name;
        this.date = date;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(final UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }
}
