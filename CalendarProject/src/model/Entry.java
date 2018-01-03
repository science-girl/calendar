package model;

import util.Date;
import util.Time;

public abstract class Entry {

    private Date date;
    private Time time;
    private String label;
    private Boolean isRepeated;
    private int repetitionInterval; //number of days before entry is repeated

    // Constructor
    public Entry(Date d, Time t, String l){
        date = d;
        time = t;
        label = l;
        isRepeated = false;
        repetitionInterval = 0;
    }

    // GETTERS
    public Date getDate() {
        return date;
    }
    public String getLabel() {
        return label;
    }

    public Time getTime() {
        return time;
    }

    public Boolean getRepeated() {
        return isRepeated;
    }

    public int getRepetitionInterval() {
        return repetitionInterval;
    }

    // SETTERS
    public void setDate(Date date) {
        this.date = date;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setRepeated(Boolean repeated) {
        isRepeated = repeated;
    }

    public void setRepetitionInterval(int repetitionInterval) {
        this.repetitionInterval = repetitionInterval;
    }
}
