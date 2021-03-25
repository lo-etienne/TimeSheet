package com.example.timesheet.CreateTimeSheet;

import androidx.lifecycle.ViewModel;


public class CreateTimeSheetViewModel extends ViewModel {

    private String[] days ={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    private int currentIndex = 0;
    private String code;
    private String description;
    private String country;
    private String currentAttendanceDay;
    private int currentNumberHour;
    private int currentNumberHourNoPrested;


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

    public void setCurrentNumberHour(int numberHour){this.currentNumberHour = numberHour;}

    public int getCurrentNumberHour(){return currentNumberHour;}


    public void setCurrentNumberHourNoPrested(int numberHour){this.currentNumberHourNoPrested = numberHour;}

    public int getCurrentNumberHourNoPrested(){return currentNumberHourNoPrested;}

    public void nextDay(){
        if(currentIndex < 7){
            currentIndex +=1;
        }
    }

    public Boolean isADayHill(){
        if(currentAttendanceDay.equals("Sick leave") || currentAttendanceDay.equals("Child sick leave")|| currentAttendanceDay.equals("Extraordinary leave")){
            return true;
        }

        return false;
    }
    public String getCurrentDay(){
        return days[currentIndex];
    }
    public boolean lastDay(){
        return (currentIndex == 7)? true : false;
    }

    public boolean isAHolidayHill() {
        if(currentAttendanceDay.equals("Vacation") || currentAttendanceDay.equals("Recovery")|| currentAttendanceDay.equals("Extraordinary leave")){
            return true;
        }
        return false;
    }

}
