package model;

/*Our calendar is fairly simple: it has one constructor that takes a Date, which it sets as the current Date; it has one email that
        it’s associated with; it has getters for those fields; and it can add or remove Entries. You will definitely want at least one
        getter that returns every item in the collection. You may also want to add getters that return the soonest Entry, that return Entries
        by name, or that return only Meetings… this is up to you, and it depends on how you want to use
        your Calendar. You can always start with a simple specification and then expand your functionality once you get the type hierarchy working.*/

import com.oracle.jrockit.jfr.EventToken;
import util.Date;
import util.Time;

import java.util.ArrayList;

public class Calendar {

    private Date currentDate;
    private String userEmail;
    private ArrayList<Entry> entries;

    public Calendar(Date date, String email){
        currentDate = date;
        userEmail = email;
        entries = new ArrayList<Entry>();
    }

    // EFFECTS: Adds a new entry to this calendar
    public void addEntry(Entry entry){
        entries.add(entry);
    }

    public Date getDate(){
        return this.currentDate;
    }
    public void setDate(Date date){
        this.currentDate = date;
    }

    // EFFECTS: Returns all entries for this calendar
    public ArrayList<Entry> getAllEntries(){
        return entries;
    }

    // EFFECTS: Returns all entries for the current date
    public ArrayList<Entry> getEntriesForToday(){
        ArrayList<Entry> todaysEntries = new ArrayList<Entry>();

        for(int i = 0; i < entries.size(); i++){
            // compare the date of each entry with currentDate and add to
            // todaysEntries if the dates match
            if( entries.get(i).getDate().getShortFormDate().equals(currentDate.getShortFormDate())){
                todaysEntries.add(entries.get(i));
            }
        }
        return todaysEntries;
    }

    // REQUIRES: there are entries in the calendar
    // EFFECTS: Returns entries with a dates within range days to the current date
    public ArrayList<Entry> getMostRecentEntry(int range){
        if(entries.size() == 0){
            return null;
        }
        int rangeYear = currentDate.getYear();
        int rangeMonth = currentDate.getMonth();
        int rangeDay = currentDate.getDay();

        ArrayList<Entry> withinRange = new ArrayList<Entry>();

        for(int i = 0; i < entries.size(); i++) {

            // check if the year is the same:
            if( (entries.get(i).getDate().getYear() == rangeYear)  ){
                // check if adding range will put the current day into the next month:
                // need to include dates in the following month
                if( (rangeDay + range) > 30 ){
                    // assuming 30 days in a month
                    // find out the number of days in the next month to include:
                    int leftoverDays = Math.abs(30 - (rangeDay + range));
                    if( (rangeMonth + 1) == entries.get(i).getDate().getMonth() &&
                            entries.get(i).getDate().getDay() <= leftoverDays){
                        withinRange.add(entries.get(i));
                    }
                }
                // check if the date range would put us into the previous month
                else if( (rangeDay - range) < 0 ){
                    int leftoverDays = Math.abs(rangeDay - range);
                    if( (rangeMonth - 1) == entries.get(i).getDate().getMonth() &&
                            entries.get(i).getDate().getDay() >= (30 - leftoverDays)){
                        withinRange.add(entries.get(i));
                    }
                }

                // if this entry is in the same month and year, we next see if it falls within the date range
                if ((entries.get(i).getDate().getMonth() == rangeMonth)) {
                    if( Math.abs(rangeDay - entries.get(i).getDate().getDay()) <= range ){
                        withinRange.add(entries.get(i));
                    }
                }
            }
        }
        return  withinRange;
    }

    // EFFECTS: Returns all calendar entries matching the given label
    public ArrayList<Entry> getByLabel(String label){
        ArrayList<Entry> matchingLabelEntries = new ArrayList<Entry>();
        for(int i = 0; i < entries.size(); i++){
            if(entries.get(i).getLabel().equals(label)){
                matchingLabelEntries.add(entries.get(i));
            }
        }
        return matchingLabelEntries;
    }

    // EFFECTS: prints the details of the given list of calendar entries
    public void printEntry(ArrayList<Entry> entries){
        if (entries.size() == 0){
            System.out.println("Nothing :-)");
            return;
        }

        Entry e;
        for(int i = 0; i < entries.size(); i++){
            e = entries.get(i);
            System.out.println("===========================");
            System.out.println("Date: " + e.getDate().getShortFormDate());
            System.out.println("Time: " + e.getTime().get12HourTime());
            System.out.println("Label: " + e.getLabel());
        }
    }

    public static void main(String[] args) {
        Date todaysDate = new Date(01, 02, 2018);
        String email = "myemail@greendale.edu";
        Calendar c = new Calendar(todaysDate, email);

        Time time1 = new Time(23, 01);
        String label1 = "Birthday";
        Date date2 = new Date(01, 30, 2018);
        Time time2 = new Time(01, 10);
        String label2 = "Doctor's Appointment";
        Date date3 = new Date(02, 01, 2018);
        Time time3 = new Time(14, 25);
        String label3 = "Meeting";
        Date date4 = new Date(01, 02, 2018);
        Time time4 = new Time(12, 30);
        String label4 = "Return Library Book";

        Event entry1 = new Event(todaysDate, time1, label1);
        entry1.setReminder(true);
        c.addEntry(entry1);

        Event entry2 = new Event(date2, time2, label2);
        entry2.setReminder(true);
        entry2.setRepeated(true);
        entry2.setRepetitionInterval(10);
        c.addEntry(entry2);

        Meeting entry3 = new Meeting(date3, time3, label3);
        entry3.addAttendee("Britta", "britta@greendale.edu");
        entry3.addAttendee("Abed", "abed@greendale.edu");
        entry3.setRepeated(true);
        entry3.setRepeated(true);
        entry3.setRepetitionInterval(5);
        c.addEntry(entry3);

        Reminder entry4 = new Reminder(date4, time4, label4);
        entry4.setNote("Use the outdoor return slot.");
        c.addEntry(entry4);

        Meeting entry5 = new Meeting(date2, time2, label3);
        c.addEntry(entry5);

        System.out.println("===========================");
        System.out.println("===========================");
        System.out.println("ALL CALENDAR ENTRIES: ");
        c.printEntry(c.getAllEntries());

        System.out.println("===========================");
        System.out.println("===========================");
        System.out.println("TODAY'S ENTRIES: ");
        c.printEntry(c.getEntriesForToday());

        c.setDate(new Date(02, 01, 2018));
        System.out.println("===========================");
        System.out.println("===========================");
        System.out.println("TODAY'S ENTRIES (01/04/2018):" );
        c.printEntry(c.getEntriesForToday());

        System.out.println("===========================");
        System.out.println("===========================");
        System.out.println("ALL MEETING ENTRIES: ");
        c.printEntry(c.getByLabel("Meeting"));

        System.out.println("===========================");
        System.out.println("===========================");
        System.out.println("MOST RECENT ENTRIES: (within 5 days)");
        c.printEntry(c.getMostRecentEntry(5));

    }

}
