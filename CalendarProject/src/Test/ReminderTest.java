package Test;

import model.Reminder;
import org.junit.Before;
import org.junit.Test;
import util.Date;
import util.Time;

import static org.junit.Assert.assertEquals;

public class ReminderTest extends EntryTest {
    private Reminder reminder1;

    @Before
    public void Setup(){
        entry1 = new Reminder(date1, time1, label1);
        entry2 = new Reminder(date2, time2, label2);
        entry3 = new Reminder(date3, time3, label3);

        reminder1 = new Reminder(date1, time1, label1);
    }

    // test setting a note
    @Test
    public void testSetNote() {
        String note = "Lock the door using code 1234 when taking out garbage";
        reminder1.setNote(note);
        assertEquals(note, reminder1.getNote());
    }

}
