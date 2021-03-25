package com.example.timesheet.Home;

import androidx.lifecycle.ViewModel;

import java.util.UUID;

public class HomeViewModel extends ViewModel {
    private Boolean isManager;

    public Boolean getIsManager() {
        return isManager;
    }

    public void setIsManager(Boolean isManager) {
        this.isManager = isManager;
    }
}