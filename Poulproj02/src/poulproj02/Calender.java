/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poulproj02;

/*
 *ADT
 * Calender
 * =============================================================================
 * -day_:integer 
 * -month_:integer
 * -year_:integer
 * =============================================================================
 * + advanceByOneDay():void
 * +toStringNumeralsAndSlashes():string {querey}
 * +toStringMDYText():string {query}
 */
public class Calender {
    private int day_;
    private int month_;
    private int year_;
    
    public static final int JAN=1, FEB=2, MAR=3, APR=4, MAY=5, JUN=6, JUL=7, 
            AUG=8, SEPT=9, OCT=10, NOV=11, DEC=12;
    
    public Calender(int day, int month, int year)
    {
        //year may be negative to represent BC
        if(!(day >0 && month > 0))
        {
            throw new IllegalArgumentException("day and month must be positive")
                    ;
        }
        else if(month > DEC)
        {
            throw new IllegalArgumentException("month must be less than 13");
        }
        //check that day is not too high
        
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
    public void advanceByOneDay()
    {
        day_++;
        if(day_ > 31)
        {
            day_ = 1;
            month_++;
            if(month_ > 12)
            {
                year_++;
            }
        }
        else if(day_ > 30 && MonthHas30(month_))
        {
            day_ = 1;
            month_++;
            if(month_ > 12)
            {
                year_++;
            }
        }
        else if(day_ > 29 && LeapYear(year_) && (month_ == FEB))
        {
            day_ = 1;
            month_++;
            if(month_ > 12)
            {
                year_++;
            }
        }
        else if(day_ > 28 && !LeapYear(year_) && (month_ == FEB))
        {
            day_ = 1;
            month_++;
            if(month_ > 12)
            {
                year_++;
            }
        }
    }
    public String toStringNumeralsAndSlashes()
    {
        return month_ + "/" + day_ +"/"+year_;
    }
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
     * returns whether or not the parameter year is a leap year
     * based on http://www.timeanddate.com/date/leapyear.html
     * The year is evenly divisible by 4;
     * If the year can be evenly divided by 100, it is NOT a leap year, unless;
     * The year is also evenly divisible by 400. Then it is a leap year.
     */
    private boolean LeapYear(int year) 
    {
        return (((year % 4) == 0) && (!(year % 100 == 0))) || (year % 400 == 0);
    }
}
