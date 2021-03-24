package com.example.timesheet.Home;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.timesheet.R;

import java.util.UUID;

public class HomeCollectionFragment extends Fragment {

    private HomeViewModel mViewModel;
    private HomeCollectionAdapter collectionPagerAdapter;
    private UUID pageId;

    public static HomeCollectionFragment newInstance(UUID pageId){
        HomeCollectionFragment homeCollectionFragment = new HomeCollectionFragment();
        homeCollectionFragment.pageId = pageId;
        return homeCollectionFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        if(mViewModel.getPageId() == null) {
            mViewModel.setPageId(pageId);
        } else {
            pageId = mViewModel.getPageId();
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        collectionPagerAdapter = new HomeCollectionAdapter(getChildFragmentManager(), pageId);
    }
}