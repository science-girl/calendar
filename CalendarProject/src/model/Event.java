package model;

import util.Date;
import util.Time;

public class Event extends Entry{

    private boolean isRemindOn; //true if a reminder should be sent

    // Constructor
    public Event(Date date, Time time, String label){
        super(date, time, label);
        isRemindOn = false; //by default reminder is off
    }

    // Getters
     public boolean getReminder(){
        return this.isRemindOn;
     }

     // Setters
     public void setReminder(boolean remind){
         isRemindOn = remind;
     }


}
