package Test;

import org.junit.Before;
import org.junit.Test;
import util.Date;

import static org.junit.Assert.assertEquals;

public class DateTest {

    private Date date;
    private Date date1;
    private Date date2;
    private Date date3;
    private Date date4;

    @Before
    public void Setup(){
        date = new Date(1, 12, 2017);
        date1 = new Date(12, 22, 2019);
        date2 = new Date(1, 1, 2018);
        date3 = new Date(12, 12, 2018);
        date4 = new Date(11, 3, 2011);
    }

    // Test constructor
    // Test getters
    @Test
    public void testConstructorAndGetters(){
        assertEquals(1, date.getMonth());
        assertEquals(12, date.getDay());
        assertEquals(2017, date.getYear());
    }

    // Test setters
    @Test
    public void testSetters(){
        date.setDay(21);
        assertEquals(21, date.getDay());
        date.setMonth(11);
        assertEquals(11, date.getMonth());
        date.setYear(2019);
        assertEquals(2019, date.getYear());
    }

    // Test short form date
    @Test
    public void testShortFormDate(){
        assertEquals("01:12:2017", date.getShortFormDate());
        assertEquals("01:01:2018", date2.getShortFormDate());
        assertEquals("12:12:2018", date3.getShortFormDate());
    }

    // Test long form date
    @Test
    public void testLongFormDate(){
        assertEquals("January 12th, 2017", date.getLongFormDate());
        assertEquals("January 1st, 2018", date2.getLongFormDate());
        assertEquals("December 22nd, 2019", date1.getLongFormDate());
        assertEquals("November 3rd, 2011", date4.getLongFormDate());
    }
}
