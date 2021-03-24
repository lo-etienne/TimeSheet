package com.example.timesheet.CreateTimeSheet;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.timesheet.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateTimeSheetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateTimeSheetFragment extends Fragment {

    private EditText code;
    private EditText description;
    private Spinner country;
    private Spinner attendanceMonday;
    private Spinner attendanceTuesday;
    private Spinner attendanceWednesday;
    private Spinner attendanceThursday;
    private Spinner attendanceFriday;
    private Spinner attendanceSaturday;
    private Spinner attendanceSunday;
    private EditText hourMonday;
    private EditText hourTuesday;
    private EditText hourWednesday;
    private EditText hourThursday;
    private EditText hourFriday;
    private EditText hourSaturday;
    private EditText hourSunday;
    private EditText hourMondayIfHill;
    private EditText hourTuesdayIfHill;
    private EditText hourWednesdayIfHill;
    private EditText hourThursdayIfHill;
    private EditText hourFridayIfHill;
    private EditText hourSaturdayIfHill;
    private EditText hourSundayIfHill;
    private Button create;


    public CreateTimeSheetFragment() {

    }

    public static CreateTimeSheetFragment newInstance() {
        CreateTimeSheetFragment fragment = new CreateTimeSheetFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_time_sheet, container, false);
        code = view.findViewById(R.id.code);
        description = view.findViewById(R.id.description);
        country = view.findViewById(R.id.spinner_country);
        attendanceMonday = view.findViewById(R.id.spinner_attendance_type_monday);
        attendanceTuesday = view.findViewById(R.id.spinner_attendance_type_tuesday);
        attendanceWednesday = view.findViewById(R.id.spinner_attendance_type_wednesday);
        attendanceThursday = view.findViewById(R.id.spinner_attendance_type_thursday);
        attendanceFriday = view.findViewById(R.id.spinner_attendance_type_friday);
        attendanceSaturday = view.findViewById(R.id.spinner_attendance_type_saturday);
        attendanceSunday = view.findViewById(R.id.spinner_attendance_type_sunday);
        hourMonday = view.findViewById(R.id.nb_hour_monday);
        hourTuesday = view.findViewById(R.id.nb_hour_tuesday);
        hourWednesday= view.findViewById(R.id.nb_hour_wednesday);
        hourThursday = view.findViewById(R.id.nb_hour_thursday);
        hourFriday = view.findViewById(R.id.nb_hour_friday);
        hourSaturday = view.findViewById(R.id.nb_hour_saturday);
        hourSunday = view.findViewById(R.id.nb_hour_sunday);
        hourMondayIfHill = view.findViewById(R.id.nb_hour_monday2);
        hourTuesdayIfHill= view.findViewById(R.id.nb_hour_tuesday2);
        hourWednesdayIfHill= view.findViewById(R.id.nb_hour_wednesday2);
        hourThursdayIfHill = view.findViewById(R.id.nb_hour_thursday2);
        hourFridayIfHill = view.findViewById(R.id.nb_hour_friday2);
        hourSaturdayIfHill = view.findViewById(R.id.nb_hour_saturday2);
        hourSundayIfHill = view.findViewById(R.id.nb_hour_sunday2);
        create = view.findViewById(R.id.button_create);

        createSpinner(view);
        return view;
    }

    public void createSpinner(View view){
        ArrayAdapter<CharSequence> adapterCountry = ArrayAdapter.createFromResource(view.getContext(),R.array.spinner_country,android.R.layout.simple_spinner_item);
        adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        country.setAdapter(adapterCountry);
        //country.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapterMonday = ArrayAdapter.createFromResource(view.getContext(),R.array.spinner_attendance_type_monday,android.R.layout.simple_spinner_item);
        adapterMonday.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        attendanceMonday.setAdapter(adapterMonday);

        ArrayAdapter<CharSequence> adapterTuesday = ArrayAdapter.createFromResource(view.getContext(),R.array.spinner_attendance_type_tuesday,android.R.layout.simple_spinner_item);
        adapterTuesday.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        attendanceTuesday.setAdapter(adapterTuesday);

        ArrayAdapter<CharSequence> adapterWednesday = ArrayAdapter.createFromResource(view.getContext(),R.array.spinner_attendance_type_wednesday,android.R.layout.simple_spinner_item);
        adapterWednesday.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        attendanceWednesday.setAdapter(adapterWednesday);

        ArrayAdapter<CharSequence> adapterThursday = ArrayAdapter.createFromResource(view.getContext(),R.array.spinner_attendance_type_thursday,android.R.layout.simple_spinner_item);
        adapterThursday.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        attendanceThursday.setAdapter(adapterThursday);

        ArrayAdapter<CharSequence> adapterFriday = ArrayAdapter.createFromResource(view.getContext(),R.array.spinner_attendance_type_friday,android.R.layout.simple_spinner_item);
        adapterFriday.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        attendanceFriday.setAdapter(adapterFriday);

        ArrayAdapter<CharSequence> adapterSaturday = ArrayAdapter.createFromResource(view.getContext(),R.array.spinner_attendance_type_saturday,android.R.layout.simple_spinner_item);
        adapterSaturday.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        attendanceSaturday.setAdapter(adapterSaturday);

        ArrayAdapter<CharSequence> adapterSunday = ArrayAdapter.createFromResource(view.getContext(),R.array.spinner_attendance_type_sunday,android.R.layout.simple_spinner_item);
        adapterSunday.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        attendanceSunday.setAdapter(adapterSunday);

    }
}