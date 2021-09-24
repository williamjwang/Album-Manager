package albums;
import java.util.Calendar;

/**
 * This class defines the Date abstract data type with year, month and day.
 *
 * There are two methods in this class: isValid() and compareTo():
 * The isValid() method checks whether a given date is valid
 * The compareTo() method is an overridden method which compares two Date objects.
 *
 * @author William Wang, Joshua Sze
 */
public class Date implements Comparable<Date>
{
    private int year;
    private int month;
    private int day;

    /**
     * This method returns the year of the Date object
     * @return year of the Date object
     */
    public int getYear()
    {
        return year;
    }
    /**
     * This method returns the month of the Date object
     * @return month of the Date object
     */
    public int getMonth()
    {
        return month;
    }
    /**
     * This method returns the day of the Date object
     * @return day of the Date object
     */
    public int getDay()
    {
        return day;
    }

    /**
     * This method returns a Date object
     * @param date a String "mm/dd/yyyy"
     */
    public Date(String date)
    {
        String dateCopy[] = date.split("/", 0);
        this.month = Integer.parseInt(dateCopy[0]);
        this.day = Integer.parseInt(dateCopy[1]);
        this.year = Integer.parseInt(dateCopy[2]);
    }

    /**
     * This method returns a Date object with today's date
     */
    public Date()
    {
        Calendar today = Calendar.getInstance();
        this.year= today.get(Calendar.YEAR);
        this.month = today.get(Calendar.MONTH);
        this.day = today.get(Calendar.DAY_OF_MONTH);

        //We increment the month since the month is return as 0-11, i.e. Jan = 0
        this.month++;
    } //create an object with today’s date (see Calendar class)

    /**
     * This method checks whether a given year is a leap year
     * @param year an int yyyy
     * @return true if the input year is a leap year
     */
    private static boolean isLeapYear(int year)
    {
        final int QUADRENNIAL = 4;
        final int CENTENNIAL = 100;
        final int QUARTERCENTENNIAL = 400;

        if (year % QUADRENNIAL == 0)
        {
            if (year % CENTENNIAL == 0)
            {
                if (year % QUARTERCENTENNIAL == 0) return true;
                else return false;
            }
            else return true;
        }
        else return false;
    }

    /**
     * This method checks whether the day is invalid for the given month and year
     * @param year an integer yyyy
     * @param month an integer mm
     * @param day an integer dd
     * @return true if the date is valid for the given month mm and year yyyy
     */
    private static boolean isValidDay(int year, int month, int day)
    {
        final int Jan = 1;
        final int Feb = 2;
        final int Mar = 3;
        final int Apr = 4;
        final int May = 5;
        final int Jun = 6;
        final int Jul = 7;
        final int Aug = 8;
        final int Sep = 9;
        final int Oct = 10;
        final int Nov = 11;
        final int Dec = 12;

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

    /**
     * This method checks whether a given date is valid.
     *
     * @return true if the given date is valid
     */
    public boolean isValid()
    {
        final int THE_EIGHTYS = 1980;

        if (year < THE_EIGHTYS) { return false; }

        //Check if date is after today's date
        Calendar today = Calendar.getInstance();

        if (year > today.get(Calendar.YEAR))
        {
            return false;
        }
        if ((year == today.get(Calendar.YEAR)) && (month > today.get(Calendar.MONTH) + 1))
        {
            return false;
        }
        if ((year == today.get(Calendar.YEAR))
                && (month == today.get(Calendar.MONTH) + 1)
                    && (day > today.get(Calendar.DAY_OF_MONTH)))
        {
            return false;
        }

        //Check if the date is valid for the given year and month
        if (isValidDay(year, month, day) == false)
        {
            return false;
        }
        if (month < 1 || month > 12) return false;
        return true;
    }

    /**
     * This month compares two Date abstract data types
     * @param date a Date object
     * @return BEFORE, SAME_DATE, or AFTER if for date1.compareTo(date2), date1 occurs before date 2,
     *      date 1 is the same as date 2, or date1 occurs after date 2, respectively
     */
    @Override
    public int compareTo(Date date)
    {
        int BEFORE = -1;
        int SAME_DATE = 0;
        int AFTER = 1;

        if (this.year < date.year) return BEFORE;
        else if (this.year == date.year)
        {
            if (this.month > date.month) return AFTER;
            else if (this.month < date.month) return BEFORE;
            else
            {
                if (this.day > date.day) return AFTER;
                if (this.day < date.day) return BEFORE;
                if (this.day == date.day) return SAME_DATE;
            }
        }
        //we know this.year > date.year here, so we return AFTER
        return AFTER;
    }

    /**
     * Testbed main for Data class
     */
    public static void main(String[] args)
    {
        Date d1 = new Date("8/5/2021");
        System.out.println(String.valueOf(d1.month));
        System.out.println(String.valueOf(d1.day));
        System.out.println(String.valueOf(d1.year));
        if (d1.isValid() == true) System.out.println("d1 is a valid date!\n");
        else System.out.println("d1 is an invalid date\n");

        Date d2 = new Date();
        System.out.println(String.valueOf(d2.month));
        System.out.println(String.valueOf(d2.day));
        System.out.println(String.valueOf(d2.year));
        System.out.print("\n");
        System.out.println(String.valueOf(d1.compareTo(d2)));

        Date d3 = new Date("2/29/2020");
        Date d4 = new Date("2/29/2021");
        if (d3.isValid()) System.out.println("d3 is valid");
        else System.out.println("d3 is invalid");
        if (d4.isValid()) System.out.println("d4 is valid");
        else System.out.println("d4 is invalid");
    }
}