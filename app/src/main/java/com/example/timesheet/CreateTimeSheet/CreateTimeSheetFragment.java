package com.example.timesheet.CreateTimeSheet;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.timesheet.R;

public class CreateTimeSheetFragment extends Fragment{

    private EditText code;
    private EditText description;
    private Spinner country;
    private String countryValue;
    private Spinner attendanceDay;
    private String attendanceDayValue;
    private EditText hourDay;
    private EditText hourDayIfHill;
    private Button create;
    private Button saveDay;
    private LinearLayout days;
    private TextView currentday;
    private LinearLayout day;
    private LinearLayout ifHill;
    private LinearLayout layoutHour;
    private TextView alarmText;
    private TextView alarmTextHill;

    private CreateTimeSheetPresenter createTimeSheetPresenter;
    private CreateTimeSheetViewModel createTimeSheetViewModel;

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
        attendanceDay = view.findViewById(R.id.spinner_attendance_type_day);
        hourDay = view.findViewById(R.id.nb_hour_day);
        hourDayIfHill = view.findViewById(R.id.nb_hour_day_hill);
        create = view.findViewById(R.id.button_create);
        saveDay = view.findViewById(R.id.button_save_day);
        days = view.findViewById(R.id.layout_days);
        currentday = view.findViewById(R.id.day);
        day = view.findViewById(R.id.layout_day);
        ifHill = view.findViewById(R.id.ifHill);
        layoutHour = view.findViewById(R.id.layout_hours);
        alarmText = view.findViewById(R.id.alarm_more_hours);
        alarmTextHill = view.findViewById(R.id.alarm_more_hours_hill);

        createSpinner(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        createTimeSheetViewModel = new ViewModelProvider(this).get(CreateTimeSheetViewModel.class);
        createTimeSheetViewModel.setCode(code.getText().toString());
        createTimeSheetViewModel.setDescription(description.getText().toString());
        createTimeSheetViewModel.setCurrentAttendanceDay(attendanceDayValue);

        if(countryValue != null){
            createTimeSheetViewModel.setCountry(countryValue);
        }

    }

    @Override
    public void onStart() {
        super.onStart();

        hourDay.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().equals("") && Integer.parseInt(s.toString()) > 10){
                    alarmText.setVisibility(View.VISIBLE);
                }else{
                    alarmText.setVisibility(View.GONE);
                }
            }
        });

        hourDayIfHill.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }
            @Override
            public void afterTextChanged(Editable s) {
                if(!s.toString().equals("") && Integer.parseInt(s.toString()) > 10){
                    alarmTextHill.setVisibility(View.VISIBLE);
                }else{
                    alarmTextHill.setVisibility(View.GONE);
                }
            }
        });


        saveDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!hourDay.getText().toString().equals("")){
                    createTimeSheetViewModel.setCurrentNumberHour(Integer.parseInt(hourDay.getText().toString()));
                }
                if(!hourDayIfHill.getText().toString().equals("")){
                    createTimeSheetViewModel.setCurrentNumberHourNoPrested(Integer.parseInt(hourDayIfHill.getText().toString()));
                }
                if(verifyData()){
                    //Ingredient ingredient = manageIngredients.createIngredient();
                    //ingredients.put(ingredient.getIngredientId(), ingredient);
                    if(createTimeSheetViewModel.isADayHill()) {
                        addNewViewDay(createTimeSheetViewModel.getCurrentDay(), createTimeSheetViewModel.getCurrentNumberHour(), createTimeSheetViewModel.getCurrentAttendanceDay(), createTimeSheetViewModel.getCurrentNumberHourNoPrested(), true,false);
                    }else if(createTimeSheetViewModel.isAHolidayHill()){
                        addNewViewDay(createTimeSheetViewModel.getCurrentDay(), createTimeSheetViewModel.getCurrentNumberHour(), createTimeSheetViewModel.getCurrentAttendanceDay(), createTimeSheetViewModel.getCurrentNumberHourNoPrested(), true,true);
                    }else{
                        addNewViewDay(createTimeSheetViewModel.getCurrentDay(),createTimeSheetViewModel.getCurrentNumberHour(),createTimeSheetViewModel.getCurrentAttendanceDay(),createTimeSheetViewModel.getCurrentNumberHourNoPrested(),false,false);
                    }
                }else{
                    Toast.makeText(getActivity(), "Veuillez remplir tout les champs!", Toast.LENGTH_SHORT).show();
                }
                createTimeSheetViewModel.nextDay();
                if(!createTimeSheetViewModel.lastDay()){
                    currentday.setText(createTimeSheetViewModel.getCurrentDay());
                }else{
                    day.setVisibility(View.GONE);
                }
                viderFormulaire();
            }
        });
    }

    public void viderFormulaire(){
        createTimeSheetViewModel.setCurrentNumberHourNoPrested(0);
        createTimeSheetViewModel.setCurrentNumberHour(0);
        hourDay.setText("");
        hourDayIfHill.setText("");
    }
    public boolean verifyData(){
        if(!attendanceDayValue.equals("")){
            //TODO
            /*if(Integer.parseInt(hourDay.getText().toString()) > 10){
                Toast.makeText(getActivity(), "Attention vous avez encoder un nombre d'eures supérieur à 10!", Toast.LENGTH_SHORT).show();
            }*/
            return true;
        }
        return false;
    }

    //public Day createIngredient(){
        //TODO créer un objet Day
    //}


    private void addNewViewDay(final String day, final int numberHours, final String attendanceDay, final int numberHoursHill, final boolean hill, final boolean vacation){
        final View inflater = LayoutInflater.from(getView().getContext()).inflate(R.layout.day, null);

        TextView currentDay = inflater.findViewById(R.id.new_day);
        currentDay.setText(day);

        TextView nbHours = inflater.findViewById(R.id.new_day_nb_hours);
        nbHours.setText(Integer.toString(numberHours));

        TextView nbHoursHill = inflater.findViewById(R.id.new_day_nb_hours_hill);
        nbHoursHill.setText(Integer.toString(numberHoursHill));

        if(!hill){
            nbHoursHill.setVisibility(View.GONE);
            inflater.findViewById(R.id.new_day_hour_hill).setVisibility(View.GONE);
        }
        if(vacation){
            nbHoursHill.setVisibility(View.GONE);
            nbHours.setVisibility(View.GONE);
            inflater.findViewById(R.id.new_day_hour_hill).setVisibility(View.GONE);
            inflater.findViewById(R.id.new_day_hour).setVisibility(View.GONE);
        }
        TextView attendance = inflater.findViewById(R.id.new_attendance_day);
        attendance.setText(attendanceDay);
        days.addView(inflater);
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public void createSpinner(View view){
        ArrayAdapter<CharSequence> adapterCountry = ArrayAdapter.createFromResource(view.getContext(),R.array.spinner_country,android.R.layout.simple_spinner_item);
        adapterCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        country.setAdapter(adapterCountry);
        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String text = parent.getItemAtPosition(position).toString();
                switch(text){
                    case "Belgium":
                        countryValue = "Belgium";
                        break;
                    case "England":
                        countryValue = "England";
                        break;
                    case "France":
                        countryValue = "France";
                        break;
                    case "Germany":
                        countryValue = "Germany";
                        break;
                    case "Luxembourg":
                        countryValue = "Luxembourg";
                        break;
                    case "Switzerland":
                        countryValue = "Switzerland";
                        break;
                    default:
                        countryValue = "Luxembourg";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }

        });

        ArrayAdapter<CharSequence> adapterMonday = ArrayAdapter.createFromResource(view.getContext(),R.array.spinner_attendance_type_day,android.R.layout.simple_spinner_item);
        adapterMonday.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        attendanceDay.setAdapter(adapterMonday);
        attendanceDay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String text = parent.getItemAtPosition(position).toString();
                switch(text){
                    case "Presence":
                        attendanceDayValue = "Presence";
                        ifHill.setVisibility(View.GONE);
                        layoutHour.setVisibility(View.VISIBLE);
                        break;
                    case "Homeworking":
                        attendanceDayValue = "Homeworking";
                        ifHill.setVisibility(View.GONE);
                        layoutHour.setVisibility(View.VISIBLE);
                        break;
                    case "Vacation":
                        attendanceDayValue = "Vacation";
                        ifHill.setVisibility(View.GONE);
                        layoutHour.setVisibility(View.GONE);
                        break;
                    case "Sick leave":
                        attendanceDayValue = "Sick leave";
                        ifHill.setVisibility(View.VISIBLE);
                        layoutHour.setVisibility(View.VISIBLE);
                        break;
                    case "Recovery":
                        attendanceDayValue = "Recovery";
                        ifHill.setVisibility(View.GONE);
                        layoutHour.setVisibility(View.GONE);
                        break;
                    case "Child sick leave":
                        attendanceDayValue = "Child sick leave";
                        ifHill.setVisibility(View.VISIBLE);
                        layoutHour.setVisibility(View.VISIBLE);
                        break;
                    case "Extraordinary leave":
                        attendanceDayValue = "Extraordinary leave";
                        ifHill.setVisibility(View.VISIBLE);
                        layoutHour.setVisibility(View.VISIBLE);
                        break;
                    default:
                        attendanceDayValue = "Presence";
                        ifHill.setVisibility(View.GONE);
                        layoutHour.setVisibility(View.VISIBLE);
                }
                createTimeSheetViewModel.setCurrentAttendanceDay(attendanceDayValue);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }

        });


    }
}