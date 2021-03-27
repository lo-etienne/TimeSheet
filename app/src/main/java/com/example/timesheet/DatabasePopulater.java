package com.example.timesheet;

import com.example.timesheet.database.repository.TimesheetRepository;
import com.example.timesheet.model.Timesheet;
import com.example.timesheet.model.User;
import com.example.timesheet.model.WorkDay;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Cette classe permet de populer préalablement la base de données afin de pouvoir la tester
 */
public class DatabasePopulater {

    public static void populateDb() {
        List<User> users = insertUsers();
        List <WorkDay> workDays = insertWorkdays();
        List<Timesheet> timesheets = insertTimesheets(workDays);
        TimesheetRepository.getInstance().populateDatabase(users, workDays, timesheets);
    }

    public static List<User> insertUsers() {

        UUID userId1 = UUID.fromString("473eab19-1ef9-467a-9e59-17ac78675d83");
        UUID userId2 = UUID.fromString("bd963076-7a9f-4cfb-8f43-6f5509f9a922");
        UUID userId3 = UUID.fromString("bd963076-7a9f-4cfb-8f43-6f5509f9a562");
        UUID userId4 = UUID.fromString("bd963076-7a9f-4cfb-8f43-6f5509f9a456");

        User user1 = new User(userId1, "Emile", "Davignon", true,"emiledavignon@gmail.com", "123123");
        User user2 = new User(userId2, "Paul", "Basin", false, "paul.basin@gmail.com", "password");
        User user3 = new User(userId3, "Emile", "Davignon", false, "emiledavignon@gmail.com", "1234");
        User user4 = new User(userId4, "Paul", "Basin", false, "paul.basin@gmail.com", "passwords");

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

       return users;


    }
    public static List<WorkDay> insertWorkdays() {

        UUID mondayId = UUID.fromString("1019d03e-8da0-11eb-1dcd-0452ac131000");
        UUID tuesdayId = UUID.fromString("1019d03e-8da0-11eb-1dcd-0452ac131001");
        UUID wednesdayId = UUID.fromString("1019d03e-8da0-11eb-1dcd-0452ac131002");
        UUID thursdayId = UUID.fromString("1019d03e-8da0-11eb-1dcd-0452ac131003");
        UUID fridayId = UUID.fromString("1019d03e-8da0-11eb-1dcd-0452ac131004");
        UUID saturdayId = UUID.fromString("1019d03e-8da0-11eb-1dcd-0452ac131005");
        UUID sundayId = UUID.fromString("1019d03e-8da0-11eb-1dcd-0452ac131006");

        UUID timesheetId = UUID.fromString("3019d03e-8da0-11eb-8dcd-0452ac130000");
        UUID timesheetId1 = UUID.fromString("3019d03e-8da0-11eb-8dcd-7842ac130004");
        UUID timesheetId2 = UUID.fromString("3019d03e-8da0-11eb-8dcd-1242ac130005");
        UUID timesheetId3 = UUID.fromString("3019d03e-8da0-11eb-8dcd-0452ac130111");

        WorkDay monday = new WorkDay(mondayId, "Monday", new Date(), 6, 6, "Presence", timesheetId);
        WorkDay tuesday = new WorkDay(tuesdayId, "Tuesday", new Date(), 6, 6, "Homeworking", timesheetId);
        WorkDay wednesday = new WorkDay(wednesdayId, "Wednesday", new Date(), 6, 6, "Extraordinary leave", timesheetId);
        WorkDay thursday = new WorkDay(thursdayId, "Thursday", new Date(), 6, 6, "Sick leave", timesheetId);
        WorkDay friday = new WorkDay(fridayId, "Friday", new Date(), 6, 6, "Child sick leave", timesheetId);
        WorkDay saturday = new WorkDay(saturdayId, "Saturday", new Date(), 6, 6, "Recovery", timesheetId);
        WorkDay sunday = new WorkDay(sundayId, "Sunday", new Date(), 6, 6, "Vacation", timesheetId);

        List<WorkDay> workDayList  = new ArrayList<>();
        workDayList.add(monday);
        workDayList.add(tuesday);
        workDayList.add(wednesday);
        workDayList.add(thursday);
        workDayList.add(friday);
        workDayList.add(saturday);
        workDayList.add(sunday);


        return workDayList;

    }

    public static List<Timesheet> insertTimesheets(final List<WorkDay> workDayList) {

        UUID timesheetId = UUID.fromString("3019d03e-8da0-11eb-8dcd-0452ac130000");
        UUID timesheetId1 = UUID.fromString("3019d03e-8da0-11eb-8dcd-7842ac130004");
        UUID timesheetId2 = UUID.fromString("3019d03e-8da0-11eb-8dcd-1242ac130005");
        UUID timesheetId3 = UUID.fromString("3019d03e-8da0-11eb-8dcd-0452ac130111");

        Timesheet timesheet = new Timesheet(timesheetId, "INT-178", "Final sprint", "Belgium", new Date(), 0, UUID.fromString("bd963076-7a9f-4cfb-8f43-6f5509f9a922"), workDayList);
        Timesheet timesheet1 = new Timesheet(timesheetId1, "INT-12347", "Meeting with client", "France", new Date(), 2, UUID.fromString("bd963076-7a9f-4cfb-8f43-6f5509f9a922"), workDayList);
        Timesheet timesheet2 = new Timesheet(timesheetId2, "INT-1263", "Finish project","Belgium", new Date(), 2, UUID.fromString("bd963076-7a9f-4cfb-8f43-6f5509f9a922"), workDayList);
        Timesheet timesheet3 = new Timesheet(timesheetId3, "INT-12738", "Begin project","Belgium", new Date(), 1, UUID.fromString("bd963076-7a9f-4cfb-8f43-6f5509f9a922"), workDayList);

        List<Timesheet> timesheets = new ArrayList<>();

        timesheets.add(timesheet);
        timesheets.add(timesheet1);
        timesheets.add(timesheet2);
        timesheets.add(timesheet3);

        return timesheets;

    }



}
