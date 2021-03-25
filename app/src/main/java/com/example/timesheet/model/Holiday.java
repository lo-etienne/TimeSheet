package com.example.timesheet.model;

import androidx.room.Entity;

import java.util.Date;
import java.util.UUID;

@Entity
public class Holiday extends Day {

    public Holiday(final UUID uuid, final String name, final Date date) {
        super(uuid, name, date);
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
}
