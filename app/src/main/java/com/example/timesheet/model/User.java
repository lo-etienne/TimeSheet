package com.example.timesheet.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity
public class User {

    @PrimaryKey
    @NonNull
    private UUID userId;

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private boolean isApprover;

    public User(final UUID userId,
                final String firstName,
                final String lastName,
                final String email,
                final String password,
                final boolean isApprover) {

        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isApprover = isApprover;

    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(final UUID userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public boolean isApprover() {
        return isApprover;
    }

    public void setApprover(final boolean approver) {
        isApprover = approver;
    }
}
