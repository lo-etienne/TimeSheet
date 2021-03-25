package com.example.timesheet.Home;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.timesheet.R;
import com.google.android.material.tabs.TabLayout;

import java.util.UUID;

public class HomeCollectionFragment extends Fragment {

    private HomeViewModel mViewModel;
    private HomeCollectionAdapter collectionPagerAdapter;
    private Boolean isManager;
    private ViewPager viewPager;
    private UUID userId;

    public static HomeCollectionFragment newInstance(Boolean isManager, UUID userId){
        HomeCollectionFragment homeCollectionFragment = new HomeCollectionFragment();
        homeCollectionFragment.isManager = isManager;
        homeCollectionFragment.userId = userId;
        return homeCollectionFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_view_pager, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        if(mViewModel.getManager() == null) {
            mViewModel.setManager(isManager);
        } else {
            isManager = mViewModel.getManager();
        }

        if(mViewModel.getUserId() == null) {
            mViewModel.setUserId(userId);
        } else {
            userId = mViewModel.getUserId();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        collectionPagerAdapter = new HomeCollectionAdapter(getChildFragmentManager(), userId);
        viewPager = view.findViewById(R.id.pager);
        viewPager.setAdapter(collectionPagerAdapter);
        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}