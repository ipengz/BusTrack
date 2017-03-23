package com.example.ku.bustrack;

/**
 * Created by Ku on 23/3/2017.
 */

public class BusInfo {

    String busID;
    String busType;
    String busNo;
    String busCond;

    public BusInfo(){

    }

    public BusInfo(String busID, String busType, String busNo, String busCond) {
        this.busID = busID;
        this.busType = busType;
        this.busNo = busNo;
        this.busCond = busCond;
    }

    public String getBusID() {
        return busID;
    }

    public String getBusType() {
        return busType;
    }

    public String getBusNo() {
        return busNo;
    }

    public String getBusCond() {
        return busCond;
    }
}
