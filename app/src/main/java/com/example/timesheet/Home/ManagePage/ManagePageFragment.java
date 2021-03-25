package com.example.timesheet.Home.ManagePage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timesheet.Home.HomeViewModel;
import com.example.timesheet.Home.TimeSheetPage.ITimesheetsScreen;
import com.example.timesheet.Home.TimeSheetPage.TimesheetsPageFragment;
import com.example.timesheet.Home.TimeSheetPage.TimesheetsPagePresenter;
import com.example.timesheet.Home.TimeSheetPage.TimesheetsRecyclerViewAdapter;
import com.example.timesheet.R;

import java.util.UUID;

public class ManagePageFragment extends Fragment implements IManageScreen {

    private RecyclerView recyclerView;
    private ManagePagePresenter presenter;
    private HomeViewModel mViewModel;
    private UUID userId;

    public static Fragment newInstance(UUID userId) {
        ManagePageFragment managePageFragment = new ManagePageFragment();
        managePageFragment.userId = userId;
        return managePageFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manage_page, container, false);
        if(view instanceof RecyclerView){
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new ManageRecyclerViewAdapter(presenter));
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        if(mViewModel.getUserId() == null){
            mViewModel.setUserId(userId);
        }else{
            this.userId = mViewModel.getUserId();
        }
        presenter = new ManagePagePresenter(userId,this);
        presenter.loadTimesheets();
    }

    @Override
    public void loadView() {
        recyclerView.setAdapter(new ManageRecyclerViewAdapter(presenter));
    }
}
