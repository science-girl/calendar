package Test;

import model.Entry;
import model.Event;
import model.Meeting;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MeetingTest extends EventTest {

    private Meeting meeting1;
    private Meeting meeting2;
    private Meeting meeting3;

    @Before
    public void Setup()
    {
        entry1 = new Event(date1, time1, label1);
        entry2 = new Event(date2, time2, label2);
        entry3 = new Event(date3, time3, label3);

        event1 = new Event(date1, time1, label1);
        event2 = new Event(date2, time2, label2);

        meeting1 = new Meeting(date1, time1, label1);
        meeting2 = new Meeting(date2, time2, label2);
        meeting3 = new Meeting(date3, time3, label3);

        meeting2.addAttendee("Phoebe", "phoebe@centralperk.com");
        meeting2.addAttendee("Rachel", "rachel@centralperk.com");
        meeting2.addAttendee("Monica", "monica@centralperk.com");

        meeting3.addAttendee("Mulder", "fox@fbi.com");
        meeting3.addAttendee("Scully", "dana@fbi.com");
        meeting3.addAttendee("Skinner", "walter@fbi.com");
    }

    // test constructor values were set
    @Test
    public void testConstructor(){
        assertEquals(label1, meeting1.getLabel());
        assertEquals(date1, meeting1.getDate());
        assertEquals(time1, meeting1.getTime());
    }

    // test adding attendees
    @Test
    public void testAddAttendee(){
        this.meeting1.addAttendee("Britta", "britta@greendale.edu");
        this.meeting1.addAttendee("Jeff", "jeff@greendale.edu");
        this.meeting1.addAttendee("Abed", "abed@greendale.edu");

        ArrayList<String> attendees1 = this.meeting1.getAttendees();
        assertEquals("Britta", attendees1.get(0));
        assertEquals("Jeff", attendees1.get(1));
        assertEquals("Abed", attendees1.get(2));

        ArrayList<String> emails1 = this.meeting1.getEmails();
        assertEquals("britta@greendale.edu", emails1.get(0));
        assertEquals("jeff@greendale.edu", emails1.get(1));
        assertEquals("abed@greendale.edu", emails1.get(2));
    }

    // test removing attendees
    @Test
    public void testRemoveAttendees(){
        meeting2.removeAttendee("Phoebe");
        ArrayList<String> attendees2 = meeting2.getAttendees();
        ArrayList<String> emails2 = meeting2.getEmails();

        assertEquals(2, attendees2.size());
        assertEquals(2, emails2.size());

        meeting2.removeAttendee("Monica");
        attendees2 = meeting2.getAttendees();
        emails2 = meeting2.getEmails();
        assertEquals(1, attendees2.size());
        assertEquals(1, emails2.size());

        meeting2.removeAttendee("Rachel");
        attendees2 = meeting2.getAttendees();
        emails2 = meeting2.getEmails();
        assertEquals(0, attendees2.size());
        assertEquals(0, emails2.size());
    }

    // test removing an attendee and then adding another one
    @Test
    public void testRemoveAndAddAttendees(){
        ArrayList<String> attendees3 = meeting3.getAttendees();
        ArrayList<String> emails3 = meeting3.getEmails();
        assertEquals("Scully", attendees3.get(1));

        // remove an attendee
        meeting3.removeAttendee("Scully");
        attendees3 = meeting3.getAttendees();
        emails3 = meeting3.getEmails();
        assertNotEquals("Scully", attendees3.get(1));
        assertEquals(2, attendees3.size());
        assertEquals(2, emails3.size());

        // add another attendee
        meeting3.addAttendee("Krycek", "alex@fbi.com");
        attendees3 = meeting3.getAttendees();
        emails3 = meeting3.getEmails();
        assertEquals(3, attendees3.size());
        assertEquals(3, emails3.size());
        assertEquals("Krycek", attendees3.get(2));
        assertEquals("alex@fbi.com", emails3.get(2));
    }

    // test sending invites
    @Test
    public void testSendInvites(){
        System.out.println("EXPECTING: ");
        ArrayList<String> emails3 = meeting3.getEmails();
        for(int i = 0; i < emails3.size(); i++){
            System.out.println("Inviting: " + emails3.get(i));
        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        System.out.println("ACTUAL: ");
        meeting3.sendInvitations();
    }

}
