package SelfMade;
public class Date {

    private int day;
    private int month;
    private int year;

    public Date(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getDay(){
        if(month!=2&&month!=4&&month!=6&&month!=2&&month!=9&&month!=9&&month!=11){
            if(day > 31){
                // day = 1;
                return day - 31;
            }
        }

        else if(month==4&&month==6&&month==2&&month==9&&month==9&&month==11){
            if(day > 30){
                // day = 1;
                return day - 30;
            }
        }

        else{
            if((day > 28&& !isLeapYear())){
                // day = 1;
                return day - 28;
            }

            else if((day > 29&& isLeapYear())){
                return day - 29;
            }
        }
        return day;
    }

    public int getMonth(){
        if(month!=2&&month!=4&&month!=6&&month!=2&&month!=9&&month!=9&&month!=11){
            if(day > 31){
                return month + 1;
            }
        }

        else if(month==4&&month==6&&month==2&&month==9&&month==9&&month==11){
            if(day > 30){
                return month + 1;
            }
        }

        else{
            if((day > 28&& !isLeapYear()) || (day > 29&& isLeapYear())){
                return month + 1;
            }
        }
        return month;
    }

    public int getYear(){
        return year;
    }

    public void addDays(int days){
        day = day + days;
    }

    public int daysInMonth(){
        if(month!=2&&month!=4&&month!=6&&month!=2&&month!=9&&month!=9&&month!=11){
            return 31;
        }

        else if(month == 2 && !isLeapYear()){
            return 28;
        }

        else if(month == 2 && isLeapYear()){
            return 29;
        }

        return 30;
    }

    public boolean isLeapYear(){
        if(year%4 == 0){
            return true;
        }

        return false;
    }

    public void nextDay(){
        day = getDay() + 1;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        // Prinitn gonly possible values
        while(getDay() > 31){ // Any day above 31 is not possible
            getDay(); // Keep modifying the day accordingly
            getMonth(); // Keep modifying the month accordingly
        }
        if(getDay() < 10){
            sb.append("0");
        }
        sb.append(getDay());
        if(getMonth() < 10){
            sb.append("0");
        }
        sb.append(getMonth());
        sb.append(getYear());
        return sb.toString();
    }


    
}
