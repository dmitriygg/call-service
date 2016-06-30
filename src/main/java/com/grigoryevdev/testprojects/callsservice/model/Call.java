package com.grigoryevdev.testprojects.callsservice.model;


import org.joda.time.DateTime;

public class Call {

    private String phoneNumber;
    private String firstName;
    private String lastName;
    private DateTime time;

    public Call() {
    }

    public Call(String phoneNumber, String firstName, String lastName, DateTime time) {
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.time = time;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DateTime getTime() {
        return time;
    }

    public void setTime(DateTime time) {
        this.time = time;
    }
}
