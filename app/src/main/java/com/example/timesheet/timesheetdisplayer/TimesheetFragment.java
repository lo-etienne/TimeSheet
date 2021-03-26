package com.example.timesheet.timesheetdisplayer;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.timesheet.R;
import com.example.timesheet.model.Timesheet;

import org.w3c.dom.Text;

import java.util.Date;
import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TimesheetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimesheetFragment extends Fragment implements ITimesheetDisplayerScreen{

    private View view;

    private TimesheetPresenter timesheetPresenter;
    private UUID timesheetId;

    private TextView wbsData;
    private TextView country;
    private TextView date;
    private TextView status;

    // MONDAY

    private TextView mondayStatus;
    private TextView mondayHoursWorked;
    private TextView mondayHoursNotWorked;

    // TUESDAY

    private TextView tuesdayStatus;
    private TextView tuesdayHoursWorked;
    private TextView tuesdayHoursNotWorked;

    // WEDNESDAY

    private TextView wednesdayStatus;
    private TextView wednesdayHoursWorked;
    private TextView wednesdayHoursNotWorked;

    // THURSDAY

    private TextView thursdayStatus;
    private TextView thursdayHoursWorked;
    private TextView thursdayHoursNotWorked;

    // FRIDAY

    private TextView fridayStatus;
    private TextView fridayHoursWorked;
    private TextView fridayHoursNotWorked;

    // SATURDAY

    private TextView saturdayStatus;
    private TextView saturdayHoursWorked;
    private TextView saturdayHoursNotWorked;

    // SUNDAY

    private TextView sundayStatus;
    private TextView sundayHoursWorked;
    private TextView sundayHoursNotWorked;
    private UUID userId;


    public TimesheetFragment() {
        // Required empty public constructor
    }

    public static TimesheetFragment newInstance(final UUID userId, final UUID timesheetId) {
        TimesheetFragment fragment = new TimesheetFragment();
        fragment.userId = userId;
        fragment.timesheetId = timesheetId;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_timesheet, container, false);

        this.wbsData = view.findViewById(R.id.wbs_data);
        this.country = view.findViewById(R.id.country);
        this.date = view.findViewById(R.id.date);

        this.mondayStatus = view.findViewById(R.id.monday_status);
        this.mondayHoursWorked = view.findViewById(R.id.monday_hours_worked);
        this.mondayHoursNotWorked = view.findViewById(R.id.monday_hours_not_worked);

        this.tuesdayStatus = view.findViewById(R.id.tuesday_status);
        this.tuesdayHoursWorked = view.findViewById(R.id.tuesday_hours_worked);
        this.tuesdayHoursNotWorked = view.findViewById(R.id.tuesday_hours_not_worked);

        this.wednesdayStatus = view.findViewById(R.id.wednesday_status);
        this.wednesdayHoursWorked = view.findViewById(R.id.wednesday_hours_worked);
        this.wednesdayHoursNotWorked = view.findViewById(R.id.wednesday_hours_not_worked);

        this.thursdayStatus = view.findViewById(R.id.thursday_status);
        this.thursdayHoursWorked = view.findViewById(R.id.thursday_hours_worked);
        this.thursdayHoursNotWorked = view.findViewById(R.id.thursday_hours_not_worked);

        this.fridayStatus = view.findViewById(R.id.friday_status);
        this.fridayHoursWorked = view.findViewById(R.id.friday_hours_worked);
        this.fridayHoursNotWorked = view.findViewById(R.id.friday_hours_not_worked);

        this.saturdayStatus = view.findViewById(R.id.saturday_status);
        this.saturdayHoursWorked = view.findViewById(R.id.saturday_hours_worked);
        this.saturdayHoursNotWorked = view.findViewById(R.id.saturday_hours_not_worked);

        this.sundayStatus = view.findViewById(R.id.sunday_status);
        this.sundayHoursWorked = view.findViewById(R.id.sunday_hours_worked);
        this.sundayHoursNotWorked = view.findViewById(R.id.sunday_hours_not_worked);




        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TimesheetViewModel timesheetViewModel = new ViewModelProvider(this).get(TimesheetViewModel.class);
        if(timesheetViewModel.getTimesheetId() == null) {
            timesheetViewModel.setTimesheetId(timesheetId);
        } else {
            timesheetId = timesheetViewModel.getTimesheetId();
        }
        if(timesheetViewModel.getUserId() == null) {
            timesheetViewModel.setUserId(userId);
        } else {
            userId = timesheetViewModel.getUserId();
        }
        timesheetPresenter = new TimesheetPresenter(this, userId);
        timesheetPresenter.loadTimesheet(timesheetId);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.timesheet_displayer_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.delete_timesheet) {
            timesheetPresenter.initTimesheetSuppression(this.getActivity(), this.getContext());
        }
        return super.onOptionsItemSelected(item);
    }

    private void setStatus(final View view) {
        this.status = view.findViewById(R.id.status);
        if(status.getText().toString().equalsIgnoreCase("approved")) {
            this.status.setTextColor(Color.parseColor("#00FF00"));
        }
        if(status.getText().toString().equalsIgnoreCase("to be approved")) {
            this.status.setTextColor(Color.YELLOW);
        }
        if(status.getText().toString().equalsIgnoreCase("draft")) {
            this.status.setTextColor(Color.RED);
        }
    }

    private void setDays(final View view) {

        setDayHours(view, this.mondayStatus, this.mondayHoursWorked, this.mondayHoursNotWorked);

        setDayHours(view, this.tuesdayStatus, this.tuesdayHoursWorked, this.tuesdayHoursNotWorked);

        setDayHours(view, this.wednesdayStatus, this.wednesdayHoursWorked, this.wednesdayHoursNotWorked);

        setDayHours(view, this.thursdayStatus, this.thursdayHoursWorked, this.thursdayHoursNotWorked);

        setDayHours(view, this.fridayStatus, this.fridayHoursWorked, this.fridayHoursNotWorked);

        setDayHours(view, this.saturdayStatus, this.saturdayHoursWorked, this.saturdayHoursNotWorked);

        setDayHours(view, this.sundayStatus, this.sundayHoursWorked, this.sundayHoursNotWorked);



    }

    private void setDayHours(final View view, final TextView dayStatus, final TextView hoursWorked, final TextView hoursNotWorked) {
        switch (dayStatus.getText().toString()) {
            case "Presence":
            case "Homeworking":
                hoursWorked.setVisibility(View.VISIBLE);
                hoursNotWorked.setVisibility(View.GONE);
                break;
            case "Vacation":
            case "Recovery":
                hoursWorked.setVisibility(View.GONE);
                hoursNotWorked.setVisibility(View.GONE);
                break;
            case "Sick leave":
            case "Extraordinary leave":
            case "Child sick leave":
                hoursWorked.setVisibility(View.VISIBLE);
                hoursNotWorked.setVisibility(View.VISIBLE);
                break;


        }
    }

    @Override
    public void showTimesheet(String wbsData,
                              String country,
                              Date date,
                              int status,
                              String mondayStatus,
                              String mondayHoursWorked,
                              String mondayHoursNotWorked,
                              String tuesdayStatus,
                              String tuesdayHoursWorked,
                              String tuesdayHoursNotWorked,
                              String wednesdayStatus,
                              String wednesdayHoursWorked,
                              String wednesdayHoursNotWorked,
                              String thursdayStatus,
                              String thursdayHoursWorked,
                              String thursdayHoursNotWorked,
                              String fridayStatus,
                              String fridayHoursWorked,
                              String fridayHoursNotWorked,
                              String saturdayStatus,
                              String saturdayHoursWorked,
                              String saturdayHoursNotWorked,
                              String sundayStatus,
                              String sundayHoursWorked,
                              String sundayHoursNotWorked) {

        setStatus(view);

        this.wbsData.setText(wbsData);
        this.country.setText(country);
        switch (status) {
            case 0:
                this.status.setText("DRAFT");
                this.status.setTextColor(Color.parseColor("#DC0005"));
                break;
            case 1:
                this.status.setText("TO APPROVE");
                this.status.setTextColor(Color.parseColor("#FF6600"));
                break;
            case 2:
                this.status.setText("APPROVED");
                this.status.setTextColor(Color.parseColor("#43B02A"));
                break;
        }
        this.mondayStatus.setText(mondayStatus);
        this.mondayHoursWorked.setText(mondayHoursWorked + " hour('s) worked");
        this.mondayHoursNotWorked.setText(mondayHoursNotWorked  + " hour('s) not worked");
        this.tuesdayStatus.setText(tuesdayStatus);
        this.tuesdayHoursWorked.setText(tuesdayHoursWorked + " hour('s) worked");
        this.tuesdayHoursNotWorked.setText(tuesdayHoursNotWorked + " hour('s) not worked");
        this.wednesdayStatus.setText(wednesdayStatus);
        this.wednesdayHoursWorked.setText(wednesdayHoursWorked + " hour('s) worked");
        this.wednesdayHoursNotWorked.setText(wednesdayHoursNotWorked + " hour('s) not worked");
        this.thursdayStatus.setText(thursdayStatus);
        this.thursdayHoursWorked.setText(thursdayHoursWorked + " hour('s) worked");
        this.thursdayHoursNotWorked.setText(thursdayHoursNotWorked + " hour('s) not worked");
        this.fridayStatus.setText(fridayStatus);
        this.fridayHoursWorked.setText(fridayHoursWorked + " hour('s) worked");
        this.fridayHoursNotWorked.setText(fridayHoursNotWorked + " hour('s) not worked");
        this.saturdayStatus.setText(saturdayStatus);
        this.saturdayHoursWorked.setText(saturdayHoursWorked + " hour('s) worked");
        this.saturdayHoursNotWorked.setText(saturdayHoursNotWorked + " hour('s) not worked");
        this.sundayStatus.setText(sundayStatus);
        this.sundayHoursWorked.setText(sundayHoursWorked + " hour('s) worked");
        this.sundayHoursNotWorked.setText(sundayHoursNotWorked + " hour('s) not worked");


        setDays(view);

    }
}