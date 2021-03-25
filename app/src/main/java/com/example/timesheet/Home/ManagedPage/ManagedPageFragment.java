package com.example.timesheet.Home.ManagedPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.timesheet.Home.ManagePage.ManagePageFragment;
import com.example.timesheet.R;

public class ManagedPageFragment extends Fragment{
    public static Fragment newInstance() {
        return new ManagePageFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_managed_page, container, false);
    }
}
