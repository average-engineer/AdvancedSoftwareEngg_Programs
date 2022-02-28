import org.junit.*;
import static org.junit.Assert.*;

// import SelfMade.Date; // Date class made by myself used
import rwth_aachen.ima.ase.lecture10.task2.Date; // Date class given by RWTH

public class DateTest {


    private Date date;
    public DateTest(int year, int month, int day){
        date = new Date(year, month, day);
    }

    @Test
    public void dateOPTest(){
        assertEquals("Test Failed","01-Feb-2020",date.toString());
    }

    public void nextDayTest(){
        date.nextDay(); // Next Day reached
        assertEquals("Test Failed","29-Feb-2020",date.toString());
    }

    public void multipleDayTest(){
        date.addDays(100); // adding multiple days
        assertEquals("Test Failed","22-Apr-2020",date.toString());
    }
    
}
