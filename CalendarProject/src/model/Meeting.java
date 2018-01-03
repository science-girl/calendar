package model;

import util.Date;
import util.Time;

import java.util.ArrayList;

public class Meeting extends Event {

    private ArrayList<String> emails;
    private ArrayList<String> attendees;

    // Constructor
    public Meeting(Date date, Time time, String label){
        super(date, time, label);
        attendees = new ArrayList<String>();
        emails = new ArrayList<String>();
    }

    // EFFECTS: returns a list of emails for the meeting attendees
    public ArrayList<String> getEmails(){
        return emails; //emails.toString();
    }

    // EFFECTS: returns an ArrayList of attendees
    public ArrayList<String> getAttendees(){
        return attendees;
    }

    // REQUIRES: attendee does not already exist on the list
    // MODIFIES: adds an attendee to the list of meeting attendees
    public void addAttendee(String attendee, String email){
        attendees.add(attendee);
        emails.add(email);

    }

    // REQUIRES: attendee is on the list
    // MODIFIES: removes an attendee from the list of meeting attendees.
    public void removeAttendee(String attendee){
        for(int i = 0; i< attendees.size(); i++){
            if (attendees.get(i).equals(attendee)){
                attendees.remove(i);
                emails.remove(i);
                return;
            }
        }
    }

    // EFFECTS: sends an email inviting each of the attendees to this meeting
    public void sendInvitations(){
        for(int i = 0; i< emails.size(); i++){
            System.out.println("Inviting: " + emails.get(i));
        }

    }

}
