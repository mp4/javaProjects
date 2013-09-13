/*
 * containd the calender class which is designed to store, increment and print 
 * a date
 * by marsh poulson 9/12/2013
 */
package poulproj03;

/*
 * the calender class is designed to be able to store and modify any valid date
 */
public class Calender {
    private int day_;
    private int month_;
    private int year_;
    
    //using constants because enums are not represented as integers in java
    public static final int JAN=1, FEB=2, MAR=3, APR=4, MAY=5, JUN=6, JUL=7, 
            AUG=8, SEPT=9, OCT=10, NOV=11, DEC=12;
    /*
     * creates a calender staring at the give day, month and year
     */
    public Calender(int day, int month, int year)
    {
        //year can be negative to represent BC
       if(month > 12 || month < 1)
       {
           throw new IllegalArgumentException("the month must be between "+
                   "1 and 12");
       }
       if(day < 1 || day > numberOfDays(month, year))
       {
           throw new IllegalArgumentException("day must be in the month");
       }
        day_ = day;
        month_ = month;
        year_ = year;
    }
    /*
     * returns true if a given month has 30 days
     */
    private boolean MonthHas30(int month)
    {
        switch(month)
        {
            case APR:
            case JUN:
            case SEPT:
            case NOV:
            return true;
        }
        return false;
    }
    /*
     * advances the calender to the next day will increment year and month
     * properly as well
     */
    public void advanceByOneDay()
    {
        day_++;
        if(day_ > numberOfDays(month_, year_))
        {
            day_ = 1;
            month_++;
            if(month_ > 12)
            {
                year_++;
            }
        }
    }
    /*
     * returns the date as a string in form M/D/Y
     */
    public String toStringNumeralsAndSlashes()
    {
        return month_ + "/" + day_ + "/" + year_;
    }
    /*
     * returns the date as a string in form M D, Y where the month is printed
     */
    public String toStringMDYText()
    {
        String month = new String();
        switch(month_)
        {
            case JAN:
                month = "January";
                break;
            case FEB:
                month = "Febuary";
                break;
            case MAR:
                month = "March";
                break;
            case APR:
                month = "April";
                break;
            case MAY:
                month = "May";
                break;
            case JUN:
                month = "June";
                break;
            case JUL:
                month = "July";
                break;
            case AUG:
                month = "August";
                break;
            case SEPT:
                month = "September";
                break;
            case OCT:
                month = "October";
                break;
            case NOV:
                month = "November";
                break;
            case DEC:
                month = "December";
                break;             
        }
        return month + " " + day_+", " + year_;
    }

    /*
     * returns the number of days in a given month and year, returns 31 if month 
     * is out of bounds
     */
    public static int numberOfDays(int month, int year)
    {
        switch(month)
        {
            case APR:
            case JUN:
            case SEPT:
            case NOV:
                return 30;
            case FEB:
                if(LeapYear(year))
                    return 29;
                return 28;
            default:
                return 31;
        }
    }
    /*
     * returns whether or not the parameter year is a leap year
     * based on http://www.timeanddate.com/date/leapyear.html
     * The year is evenly divisible by 4;
     * If the year can be evenly divided by 100, it is NOT a leap year, unless;
     * The year is also evenly divisible by 400. Then it is a leap year.
     */
    private static boolean LeapYear(int year) 
    {
        return (((year % 4) == 0) && (!(year % 100 == 0))) || (year % 400 == 0);
    }
}
