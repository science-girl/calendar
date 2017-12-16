package Test;

import org.junit.Before;
import org.junit.Test;
import util.Time;

import static org.junit.Assert.assertEquals;

public class TimeTest {

    private Time time1;
    private Time time2;
    private Time time3;
    private Time time4;

    @Before
    public void Setup(){
        time1 = new Time(23, 00);
        time2 = new Time(12, 01);
        time3 = new Time(15, 59);
        time4 = new Time(8, 20);
    }

    // Test constructor and getters
    @Test
    public void testConstructorAndGetters(){
        assertEquals(23, time1.getHours());
        assertEquals(00, time1.getMinutes());
        assertEquals(12, time2.getHours());
        assertEquals(01, time2.getMinutes());
    }

    // Test setters
    @Test
    public void testSetters(){
        time1.setHours(10);
        assertEquals(10, time1.getHours());
        time1.setMinutes(24);
        assertEquals(24, time1.getMinutes());
    }

    // Test 12 Hour time
    @Test
    public void test12HourTime(){
        assertEquals("11:00PM", time1.get12HourTime());
        assertEquals("12:01PM", time2.get12HourTime());
        assertEquals("3:59PM", time3.get12HourTime());
        assertEquals("8:20AM", time4.get12HourTime());
    }

    // Test 24 Hour time
    @Test
    public void test24HourTime(){
        assertEquals("23:00", time1.get24HourTime());
        assertEquals("12:01", time2.get24HourTime());
        assertEquals("15:59", time3.get24HourTime());
        assertEquals("08:20", time4.get24HourTime());
    }
}
