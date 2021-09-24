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
        // Test case 1 - The method shall not accept any date with the year before 1980
        Date d1 = new Date("2/19/1965"); // accounted
        if (d1.isValid()) System.out.println("d1 is valid\n");
        else System.out.println("d1 is invalid\n");

        // Test case 2 - The method shall not accept any date with the year after current year
        Date d2 = new Date("2/19/2030"); // accounted
        if (d2.isValid()) System.out.println("d2 is valid\n");
        else System.out.println("d2 is invalid\n");

        // Test case 3 - Number of days in February for a non-leap year shall be 28
        Date d3 = new Date("2/29/2021");
        if (d3.isValid()) System.out.println("d3 is valid\n");
        else System.out.println("d3 is invalid\n");

        // Test case 4 - Number of days in February for a leap year shall be 29
        Date d4 = new Date("2/29/2020");
        if (d4.isValid()) System.out.println("d4 is valid\n");
        else System.out.println("d4 is invalid\n");

        // Test case 5 - Valid range for the month shall be 1-12
        Date d5 = new Date("0/19/2020"); // accounted
        if (d5.isValid()) System.out.println("d5 is valid\n");
        else System.out.println("d5 is invalid\n");

        // Test case 6 - Valid range for the month shall be 1-12
        Date d6 = new Date("13/19/2020"); // accounted
        if (d6.isValid()) System.out.println("d6 is valid\n");
        else System.out.println("d6 is invalid\n");

        // Test case 7 - Valid range for days in 30-day months shall be 1-30
        Date d7 = new Date("4/31/2020"); // accounted
        if (d7.isValid()) System.out.println("d7 is valid\n");
        else System.out.println("d7 is invalid\n");

        // Test case 8 - Valid range for any day shall be 1-(28, 29, 30, 31 depending on month)
        Date d8 = new Date("4/0/2020"); // accounted
        if (d8.isValid()) System.out.println("d8 is valid\n");
        else System.out.println("d8 is invalid\n");

        // Test case 9 - Valid range for days in February shall be 1-(28-29 depending on leap year)
        Date d9 = new Date("2/30/2020"); // accounted y
        if (d9.isValid()) System.out.println("d9 is valid\n");
        else System.out.println("d9 is invalid\n");

        // Test case 10 - Valid range for days in 31-day months shall be 1-31
        Date d10 = new Date("1/32/2020"); // accounted y
        if (d10.isValid()) System.out.println("d10 is valid\n");
        else System.out.println("d10 is invalid\n");

        // Test case 11 - Date with invalid values in day and month
        Date d11 = new Date("13/32/2020"); // accounted y
        if (d11.isValid()) System.out.println("d11 is valid\n");
        else System.out.println("d11 is invalid\n");

        // Test case 12 - Date with invalid values in month and year
        Date d12 = new Date("13/19/2030"); // accounted y
        if (d12.isValid()) System.out.println("d12 is valid\n");
        else System.out.println("d12 is invalid\n");

        // Test case 13 - Date with invalid values in day and year
        Date d13 = new Date("5/32/2030"); // accounted y
        if (d13.isValid()) System.out.println("d13 is valid\n");
        else System.out.println("d13 is invalid\n");

        // Test case 14 - Date with invalid values in day, month, and year
        Date d14 = new Date("314/159/265"); // accounted y
        if (d14.isValid()) System.out.println("d14 is valid\n");
        else System.out.println("d14 is invalid\n");

        // Test case 15 - Valid day
        Date d15 = new Date("8/5/2021");
        if (d15.isValid() == true) System.out.println("d15 is valid\n");
        else System.out.println("d15 is invalid\n");

        // Test case 16 - Valid day
        Date d16 = new Date("2/19/2001"); // accounted y
        if (d16.isValid()) System.out.println("d16 is valid\n");
        else System.out.println("d16 is invalid\n");

        // Test case 17 - Valid date with no date inputted (assumes today’s date)
        Date d17 = new Date();
        if (d17.isValid() == true) System.out.println("d17 is valid\n");
        else System.out.println("d17 is invalid\n");
    }
}