package model;

import util.Date;
import util.Time;

public class Reminder extends Entry{

    private String note;

    // Constructor
    public Reminder(Date date, Time time, String label){
        super(date, time, label);
        note = "";
    }

    // Getters
    public String getNote(){
        return note;
    }

    // Setters
    public void setNote(String n){
        note = n;
    }
}
