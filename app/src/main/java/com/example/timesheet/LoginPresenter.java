package com.example.timesheet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.timesheet.database.repository.TimesheetRepository;
import com.example.timesheet.model.User;

import java.util.UUID;

public class LoginPresenter {

    private TimesheetRepository repos;
    private boolean exists = false;
    private UUID userId;
    private Boolean isManager;

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
                if(user != null){
                    exists = true;
                    userId = user.getUserId();
                    isManager = user.isApprover();
                }
            }
        });

        return exists;
    }

    public void startDB() {
        repos.getAllUsers();
    }

    public UUID getUserId() {
        return userId;
    }

    public Boolean getIsManager(){
        return isManager;
    }
}

