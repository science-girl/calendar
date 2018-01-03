package Test;

import model.Event;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public abstract class EventTest extends EntryTest{

    Event event1;
    Event event2;

    // test get/set reminder
    public void testGetAndSetReminder(){
        assertEquals(false, event1.getReminder());
        event1.setReminder(true);
        assertEquals(true, event1.getReminder());
    }

}
