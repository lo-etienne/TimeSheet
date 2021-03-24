package com.example.timesheet.Home;

import androidx.lifecycle.ViewModel;

import java.util.UUID;

public class HomeViewModel extends ViewModel {
    private UUID pageId;

    public UUID getPageId() {
        return pageId;
    }

    public void setPageId(UUID pageId) {
        this.pageId = pageId;
    }
}