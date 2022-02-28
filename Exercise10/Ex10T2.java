// import SelfMade.Date; // Date class made by myself used
import rwth_aachen.ima.ase.lecture10.task2.Date; // Date class given by RWTH
public class Ex10T2 {

    public static void main(String[] args) {
        Date date = new Date(2021,2,27);
        date.nextDay();
        date.nextDay();
        System.out.println(date);

        Date date1 = new Date(2020,1,13);
        date1.addDays(100);
        System.out.println(date1);


        // Test Class for date
        DateTest testcase1 = new DateTest(2020,1,32);
        testcase1.dateOPTest();

        DateTest testcase2 = new DateTest(2020,2,28);
        testcase2.nextDayTest();

        DateTest testcase3 = new DateTest(2020,1,13);
        testcase3.multipleDayTest();

    }
    
}
