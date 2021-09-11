import java.util.Calendar;

public class Date implements Comparable<Date>
{
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUARTERCENTENNIAL = 400;
    public static final int THE_EIGHTYS = 1980;

    public static final int Jan = 1;
    public static final int Feb = 2;
    public static final int Mar = 3;
    public static final int Apr = 4;
    public static final int May = 5;
    public static final int Jun = 6;
    public static final int Jul = 7;
    public static final int Aug = 8;
    public static final int Sep = 9;
    public static final int Oct = 10;
    public static final int Nov = 11;
    public static final int Dec = 12;


    private int year;
    private int month;
    private int day;

    public Date(String date)
    {
        String dateCopy[] = date.split("/", 0);

        this.month = Integer.parseInt(dateCopy[0]);
        this.day = Integer.parseInt(dateCopy[1]);
        this.year = Integer.parseInt(dateCopy[2]);
    } //take “mm/dd/yyyy” and create a Date object


    public Date()
    {
        this.month = month;
        this.day = day;
        this.year = year;
    } //create an object with today’s date (see Calendar class)

    public static boolean isLeapYear(int year)
    {
        if (year % QUADRENNIAL == 0)
        {
            if (year % CENTENNIAL == 0)
            {
                if (year % QUARTERCENTENNIAL == 0)
                {
                    return true;
                }
                else return false;

            }
            else return true;
        }
        else return false;
    }

    //Checks whether the day is invalid for the given month
    public static boolean isValidDay(int year, int month, int day)
    {
        //No months of the year have more than 31 days
        int maxDay = 31;
        //No months of the year have 0 or fewer days
        int minDay = 1;
        if ((day > maxDay) || (day < minDay)) return false;

        //If month is Apr, Jun, Sep, or Nov and day > 30, return false
        if ((month == Apr) || (month == Jun) || (month == Sep) || (month == Nov))
        {
            int thirtyDays = 30;
            if (day > thirtyDays) return false;
        }
        if (month == Feb)
        {
            int FebLeapYearDays = 29;
            int FebNonLeapYearDays = 28;

            if (isLeapYear(year) == true)
            {
                if (day > FebLeapYearDays) return false;
            }
            else //Otherwise, it is not a leap year
            {
                if (day > FebNonLeapYearDays) return false;
            }
        }
        return true;
    }

    public boolean isValid()
    {
        if (year < THE_EIGHTYS) return false;
        //need condition here to check if date is beyond today's date
        //check if date is beyond today's date
        //Calendar cal = Calendar.getInstance();

        if (isValidDay(year, month, day) == false) return false;
        return true;
    }

    @Override
    public int compareTo(Date date)
    {
        if (this.year != date.year) return 0;
        if (this.month != date.month) return 0;
        if (this.day != date.day) return 0;
        return 1;
    }
}
