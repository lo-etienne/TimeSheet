package com.example.timesheet.CreateTimeSheet;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

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

import java.util.UUID;

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
        //TODO
    }

    @Override
    public void onStart() {
        super.onStart();

        saveDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verifyData()){
                    //Ingredient ingredient = manageIngredients.createIngredient();
                    //ingredients.put(ingredient.getIngredientId(), ingredient);
                    addNewViewDay("Monday",5,createTimeSheetViewModel.getCurrentAttendanceDay());
                    //days.setVisibility(View.GONE);
                }else{
                    Toast.makeText(getActivity(), "Veuillez remplir tout les champs!", Toast.LENGTH_SHORT).show();
                }
            }
        });
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

    private void addNewViewDay(final String day, final int numberHours, final String attendanceDay){
        final View inflater = LayoutInflater.from(getView().getContext()).inflate(R.layout.day, null);
        TextView dayOfWeek = inflater.findViewById(R.id.new_day);
        dayOfWeek.setText(day);

        TextView nbHours = inflater.findViewById(R.id.new_day_nb_hours);
        nbHours.setText(Integer.toString(numberHours));

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
                        break;
                    case "Homeworking":
                        attendanceDayValue = "Homeworking";
                        break;
                    case "Vacation":
                        attendanceDayValue = "Vacation";
                    break;
                    case "Sick leave":
                        attendanceDayValue = "Sick leave";
                        break;
                    case "Recovery":
                        attendanceDayValue = "Recovery";
                        break;
                    case "Child sick leave":
                        attendanceDayValue = "Child sick leave";
                        break;
                    case "Extraordinary leave":
                        attendanceDayValue = "Extraordinary leave";
                        break;
                    default:
                        attendanceDayValue = "Presence";
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