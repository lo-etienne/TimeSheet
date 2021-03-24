package com.example.timesheet.Home;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.timesheet.Home.ManagePage.ManagePageFragment;
import com.example.timesheet.Home.ManagedPage.ManagedPageFragment;
import com.example.timesheet.Home.TimeSheetPage.TimeSheetPageFragment;

import java.util.UUID;

public class HomeCollectionAdapter extends FragmentStatePagerAdapter {
    private final UUID pageId;

    public HomeCollectionAdapter(FragmentManager fm, UUID pageId) {
        super(fm);
        this.pageId = pageId;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return TimeSheetPageFragment.newInstance();
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
