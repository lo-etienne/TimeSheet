package com.example.timesheet.Home.ManagedPage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timesheet.Home.HomeViewModel;
import com.example.timesheet.Home.ManagePage.IManageScreen;
import com.example.timesheet.Home.ManagePage.ManagePageFragment;
import com.example.timesheet.Home.ManagePage.ManagePagePresenter;
import com.example.timesheet.Home.ManagePage.ManageRecyclerViewAdapter;
import com.example.timesheet.R;

import java.util.UUID;

public class ManagedPageFragment extends Fragment implements IManagedScreen {

    private RecyclerView recyclerView;
    private ManagedPagePresenter presenter;
    private HomeViewModel mViewModel;
    private UUID userId;
    private ISelectedTimesheet callbacks;

    public interface ISelectedTimesheet{
        public void onSelectedTimesheet(UUID timesheetId);
    }

    public static Fragment newInstance(UUID userId) {
        ManagedPageFragment managedPageFragment = new ManagedPageFragment();
        managedPageFragment.userId = userId;
        return managedPageFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_managed_page, container, false);
        if(view instanceof RecyclerView){
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(new ManagedRecyclerViewAdapter(presenter, callbacks));
        }

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        callbacks = (ISelectedTimesheet) context;
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
        presenter = new ManagedPagePresenter(userId,this);
        presenter.loadTimesheets();
    }

    @Override
    public void loadView() {
        if(recyclerView != null){
            recyclerView.setAdapter(new ManagedRecyclerViewAdapter(presenter, callbacks));
        }
    }
}

