package com.example.ku.bustrack;

/**
 * Created by Ku on 5/4/2017.
 */

public class BusSchedule {

    private String busSchedule;
    private String busType;
    private String busTime;
    private String scheduleID;

    public BusSchedule(){

    }

    public BusSchedule(String scheduleID, String BusSchedule, String BusType, String busTime){
        this.scheduleID = scheduleID;
        this.busSchedule = BusSchedule;
        this.busType = BusType;
        this.busTime = busTime;
    }
    public String getScheduleID(){ return scheduleID;}

    public String getBusSchedule(){
        return busSchedule;
    }

    public String getBusTime() {
        return busTime;
    }

    public String getBusType() {
        return busType;
    }

}
