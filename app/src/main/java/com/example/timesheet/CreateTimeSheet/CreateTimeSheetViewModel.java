package com.example.timesheet.CreateTimeSheet;

import androidx.lifecycle.ViewModel;


public class CreateTimeSheetViewModel extends ViewModel {

    private String code;
    private String description;
    private String country;
    private String currentAttendanceDay;
    //private String status;
    //TODO Jour ainsi que les heures et les attendances pour chaque jour


    public void setCode(String code){
        this.code = code;
    }

    public String getCode(){
        return code;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public String getCountry(){
        return country;
    }

    public void setCurrentAttendanceDay(String attendance){
        this.currentAttendanceDay = attendance;
    }

    public String getCurrentAttendanceDay(){
        return currentAttendanceDay;
    }

    /* public void setStatus(){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }*/

}
