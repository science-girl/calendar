package util;

public class Time {
    public int hours;
    public int minutes;

    // CONSTRUCTOR
    public Time(int hh, int mm){
        this.hours = hh;
        this.minutes = mm;
    }

    // SETTERS
    //REQUIRES: hours are between 00 and 24 (inclusive
    //  minutes are between 00 and 59 (inclusive)
    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    // GETTERS
    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    // EFFECTS: returns time in 12 hour representation (ie: 11:00AM)
    public String get12HourTime(){
        String h = Integer.toString(hours);
        String AMPM = "AM";
        if( hours > 12){
           h = Integer.toString(hours - 12);
           AMPM = "PM";
        }
        if( hours == 12){
            AMPM = "PM";
        }

        String m = padTime(this.minutes);

        return h + ":" + m + AMPM;
    }

    // EFFECTS: returns the time in 24 hour representation (ie: 1500)
    public String get24HourTime(){
        String h = padTime(this.hours);
        String m = padTime(this.minutes);

        return h + ":" + m;
    }

    // EFFECTS: returns minutes as a string with 2 digits
    private String padTime(int i){
        if(i < 10){

            return String.format("%02d", i);
        }

        return Integer.toString(i);
    }
}
