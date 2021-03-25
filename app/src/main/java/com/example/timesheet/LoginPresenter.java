package com.example.timesheet;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.timesheet.database.repository.TimesheetRepository;
import com.example.timesheet.model.User;

import java.util.UUID;

public class LoginPresenter {

    private TimesheetRepository repos;
    private boolean exists = false;

    public LoginPresenter() {
        repos = TimesheetRepository.getInstance();
    }

    public void insertUsersInDB() {

    }

    public boolean areCredentialsValid(String mail, String pass) {
        LiveData<User> userLd = repos.getUserByMailAndPass(mail, pass);

        userLd.observeForever(new androidx.lifecycle.Observer<User>() {
            @Override
            public void onChanged(User user) {
                exists = true;
            }
        });

        return exists;
    }

    public void startDB() {
        repos.getAllUsers();
    }
}
