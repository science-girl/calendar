package Test;

import model.Entry;
import org.junit.Test;
import util.Date;
import util.Time;

import static org.junit.Assert.assertEquals;

public abstract class EntryTest {

    Entry entry1;
    Entry entry2;
    Entry entry3;

    Date date1 = new Date(1, 02, 2018);
    Date date2 = new Date(12, 25, 2017);
    Date date3 = new Date(5, 13, 2016);
    Time time1 = new Time(23, 00);
    Time time2 = new Time(1, 00);
    Time time3 = new Time(12, 30);

    String label1 = "BIRTHDAY";
    String label2 = "WORK";
    String label3 = "GYM";

    // test constructor
    @Test
    public void testConstructor(){
        assertEquals(date1, entry1.getDate());
        assertEquals(time1, entry1.getTime());
        assertEquals(label1, entry1.getLabel());
    }

    // test setting repeat interval
    @Test
    public void testSetRepeatInterval(){
        entry1.setRepeated(true);
        entry1.setRepetitionInterval(10);
        assertEquals(true, entry1.getRepeated());
        assertEquals(10, entry1.getRepetitionInterval());

    }

    // test setting label
    @Test
    public void testSetLabel(){
        entry2.setLabel(label2);
        assertEquals(label2, entry2.getLabel());
    }

    // test setting date
    @Test
    public void testSetDate() {
        entry1.setDate(date2);
        assertEquals(date2, entry1.getDate());
    }

    // test setting time
    @Test
    public void testSetTime() {
        entry1.setTime(time2);
        assertEquals(time2, entry1.getTime());
    }

}
