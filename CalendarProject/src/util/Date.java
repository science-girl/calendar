package util;

import com.sun.istack.internal.NotNull;

public class Date {
    private int month;
    private int day;
    private int year;

    private static final char SHORT_DATE_DELIM = ':';

    // Constructor
    // REQUIRES:
    //    - month is between 1 and 12
    //    - day is between 1 and 31
    //    - year is between 1900 and 30000
    public Date(int mm, int dd, int yy){
        month = mm;
        day = dd;
        year = yy;
    }

    // SETTERS
    // REQUIRES: month is between 1 and 12 (inclusive)
    public void setMonth(int mm){
        month = mm;
    }

    // REQUIRES: day is between 1 and 31 (inclusive)
    public void setDay(int day) {
        this.day = day;
    }

    // REQUIRES: year is between 1900 and 3000 (inclusive)
    public void setYear(int year) {
        this.year = year;
    }

    // GETTERS
    public int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }
    public int getYear() {
        return year;
    }

    // EFFECTS: returns the date as 'mm:dd:yyyy' (ie. 01:01:2018)
    public String getShortFormDate(){
        String shortDate = "";
        String mm = formatDateLessThanTen(this.month);
        String dd = formatDateLessThanTen(this.day);

        shortDate = mm + SHORT_DATE_DELIM +
        dd + SHORT_DATE_DELIM + Integer.toString(year);

        return shortDate;
    }

    // EFFECTS: returns the date as 'month-name day, year' (ie. January 1st, 2018)
    public String getLongFormDate(){
        String d = dayNumToString(this.day);
        String m = monthNumToString(this.month);

        return m + " " + d + ", " + Integer.toString(this.year);
    }

    // EFFECTS: returns a String version of i padded with a zero to the left (ie. 1 -> 01)
    private String formatDateLessThanTen(int i){
        if( i < 10 ){
            return String.format("%02d", i);
        }
        return Integer.toString(i);
    }

    // REQUIRES: i is a 1 or 2 digit number.
    // EFFECTS: returns the day with the correct suffix (ie. 5 returns 5th)
    @org.jetbrains.annotations.NotNull
    private String dayNumToString(int i){
        String dd = Integer.toString(i);
        // if i is 1 or ends in a 1, add suffix 'st'
        if(i==1 || i==21 || i==31){
            return dd + "st";
        }
        // if i is 2 or ends in a 2, add suffix 'nd'
        if(i==2 || i==22){
            return dd + "nd";
        }
        if(i==3 || i==23){
            return dd + "rd";
        }
        // otherwise add 'th'
        return dd + "th";
    }

    // EFFECTS: returns the string corresponding to the number of the month (ie. '05' returns May)
    private String monthNumToString(int i) {
        switch (i) {
            case 1:
                return MonthType.January.toString();
            case 2:
                return MonthType.February.toString();
            case 3:
                return MonthType.March.toString();
            case 4:
                return MonthType.April.toString();
            case 5:
                return MonthType.May.toString();
            case 6:
                return MonthType.June.toString();
            case 7:
                return MonthType.July.toString();
            case 8:
                return MonthType.August.toString();
            case 9:
                return MonthType.September.toString();
            case 10:
                return MonthType.October.toString();
            case 11:
                return MonthType.November.toString();
            case 12:
                return MonthType.December.toString();
        }
        return "";
    }
}
