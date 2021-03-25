package com.example.timesheet.Home;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.timesheet.Home.ManagePage.ManagePageFragment;
import com.example.timesheet.Home.ManagedPage.ManagedPageFragment;
import com.example.timesheet.Home.TimeSheetPage.TimesheetsPageFragment;

import java.util.UUID;

public class HomeCollectionAdapter extends FragmentStatePagerAdapter {
    private final UUID userId;

    public HomeCollectionAdapter(FragmentManager fm, UUID userId) {
        super(fm);
        this.userId = userId;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return TimesheetsPageFragment.newInstance(userId);
            case 1:
                return ManagePageFragment.newInstance();
            case 2:
                return ManagedPageFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "TimeSheet";
            case 1:
                return "Manage";
            case 2:
                return "Managed";
            default:
                return "Page";
        }
    }
}
