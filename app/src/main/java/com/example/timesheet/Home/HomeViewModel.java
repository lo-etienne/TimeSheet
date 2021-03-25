package com.example.timesheet.Home;

import androidx.lifecycle.ViewModel;

import java.util.UUID;

public class HomeViewModel extends ViewModel {
    private Boolean isManager;
    private UUID userId;

    public Boolean getManager() {
        return isManager;
    }

    public void setManager(Boolean manager) {
        isManager = manager;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}