package com.example.timesheet;

import androidx.lifecycle.LiveData;

import com.example.timesheet.database.repository.TimesheetRepository;
import com.example.timesheet.model.User;

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
                if(user != null)
                    exists = true;
            }
        });

        return exists;
    }

    public void startDB() {
        repos.getAllUsers();
    }
}

