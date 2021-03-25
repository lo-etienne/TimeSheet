package com.example.timesheet.timesheetdisplayer;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.timesheet.R;

import org.w3c.dom.Text;

import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TimesheetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimesheetFragment extends Fragment {

    private TimesheetPresenter timesheetPresenter;
    private UUID timesheetId;

    private TextView wbsData;
    private TextView date;
    private TextView status;

    // MONDAY

    private TextView mondayTitle;
    private TextView mondayStatus;
    private TextView mondayHoursWorked;
    private TextView mondayHoursNotWorked;

    // TUESDAY

    private TextView tuesdayTitle;
    private TextView tuesdayStatus;
    private TextView tuesdayHoursWorked;
    private TextView tuesdayHoursNotWorked;

    // WEDNESDAY

    private TextView wednesdayTitle;
    private TextView wednesdayStatus;
    private TextView wednesdayHoursWorked;
    private TextView wednesdayHoursNotWorked;

    // THURSDAY

    private TextView thursdayTitle;
    private TextView thursdayStatus;
    private TextView thursdayHoursWorked;
    private TextView thursdayHoursNotWorked;

    // FRIDAY

    private TextView fridayTitle;
    private TextView fridayStatus;
    private TextView fridayHoursWorked;
    private TextView fridayHoursNotWorked;

    // SATURDAY

    private TextView saturdayTitle;
    private TextView saturdayStatus;
    private TextView saturdayHoursWorked;
    private TextView saturdayHoursNotWorked;

    // SUNDAY

    private TextView sundayTitle;
    private TextView sundayStatus;
    private TextView sundayHoursWorked;
    private TextView sundayHoursNotWorked;


    public TimesheetFragment() {
        // Required empty public constructor
    }

    public static TimesheetFragment newInstance(final UUID timesheetId) {
        TimesheetFragment fragment = new TimesheetFragment();
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
        View view = inflater.inflate(R.layout.fragment_timesheet, container, false);

        this.wbsData = view.findViewById(R.id.wbs_data);
        this.date = view.findViewById(R.id.date);

        setStatus(view);
        setDays(view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //timesheetPresenter = new TimesheetPresenter();
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

        this.mondayStatus = view.findViewById(R.id.monday_status);
        setDayHours(view, this.mondayStatus, this.mondayHoursWorked, this.mondayHoursNotWorked);

        this.tuesdayStatus = view.findViewById(R.id.tuesday_status);
        setDayHours(view, this.tuesdayStatus, this.tuesdayHoursWorked, this.tuesdayHoursNotWorked);

        this.wednesdayStatus = view.findViewById(R.id.wednesday_status);
        setDayHours(view, this.wednesdayStatus, this.wednesdayHoursWorked, this.wednesdayHoursNotWorked);

        this.thursdayStatus = view.findViewById(R.id.thursday_status);
        setDayHours(view, this.thursdayStatus, this.thursdayHoursWorked, this.thursdayHoursNotWorked);

        this.fridayStatus = view.findViewById(R.id.friday_status);
        setDayHours(view, this.fridayStatus, this.fridayHoursWorked, this.fridayHoursNotWorked);

        this.saturdayStatus = view.findViewById(R.id.saturday_status);
        setDayHours(view, this.saturdayStatus, this.saturdayHoursWorked, this.saturdayHoursNotWorked);

        this.sundayStatus = view.findViewById(R.id.sunday_status);
        setDayHours(view, this.sundayStatus, this.sundayHoursWorked, this.saturdayHoursNotWorked);



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
            case "Child sick leave":
            case "Extraordinary leave":
                hoursWorked.setVisibility(View.VISIBLE);
                hoursNotWorked.setVisibility(View.VISIBLE);
                break;


        }
    }
}