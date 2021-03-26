package com.example.timesheet.Home.TimeSheetPage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timesheet.CreateTimeSheet.CreateTimeSheetActivity;
import com.example.timesheet.Home.HomeViewModel;
import com.example.timesheet.Home.ManagedPage.ManagedPageFragment;
import com.example.timesheet.R;
import com.example.timesheet.model.Timesheet;

import java.util.UUID;

public class TimesheetsPageFragment extends Fragment implements ITimesheetsScreen {

    private RecyclerView recyclerView;
    private TimesheetsPagePresenter presenter;
    private HomeViewModel mViewModel;
    private UUID userId;
    private ManagedPageFragment.ISelectedTimesheet callbacks;

    public static Fragment newInstance(UUID userId) {
        TimesheetsPageFragment timesheetsPageFragment = new TimesheetsPageFragment();
        timesheetsPageFragment.userId = userId;
        return timesheetsPageFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_time_sheet_page, container, false);
        if(view instanceof RecyclerView){
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new TimesheetsRecyclerViewAdapter(presenter, callbacks));
        }

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        callbacks = (ManagedPageFragment.ISelectedTimesheet) context;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.time_sheet_page_menu, menu);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        if(userId == null) {
            userId = mViewModel.getUserId();
        }
        presenter = new TimesheetsPagePresenter(userId,this);
        presenter.loadTimesheets();
    }

    @Override
    public void loadView() {
        recyclerView.setAdapter(new TimesheetsRecyclerViewAdapter(presenter, callbacks));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.add) {
            Intent intent = new Intent(getContext(), CreateTimeSheetActivity.class);
            intent.putExtra("userId", userId.toString());
            startActivity(intent);
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }
}
