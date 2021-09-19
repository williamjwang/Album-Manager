//package albums;

/**
 * This class defines the Album abstract data type with title, artist, genre, releaseDate, and isAvailable.
 * ...
 * There are two methods in this class: equals() and toString():
 * The equals() method is an overridden method and compares two Album objects
 * The toString() method is an overridden method and returns a textual representation of a given Album object
 * ...
 * @author William Wang, Joshua Sze
 */
public class Album
{
    private String title;
    private String artist;
    private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown
    private Date releaseDate;
    private boolean isAvailable;

    /**
     * This method returns the title of the Album object
     * @return a String title of the Album object
     */
    public String getTitle()
    {
        return title;
    }
    /**
     * This method returns the artist of the Album object
     * @return a String artist of the Album object
     */
    public String getArtist()
    {
        return artist;
    }
    /**
     * This method returns the genre of the Album object
     * @return a Genre genre of the Album object
     */
    public Genre getGenre()
    {
        return genre;
    }
    /**
     * This method returns the release date of the Album object
     * @return a Date object releaseDate of the Album object
     */
    public Date getDate()
    {
        return releaseDate;
    }
    /**
     * This method returns the availability of the Album object
     * @return a boolean isAvailable of the Date object
     */
    public boolean getIsAvailable()
    {
        return isAvailable;
    }

    /**
     * This method compares two Album objects and checks if they have the same title and artist
     * @param obj an Album object
     * @return true if the two Album objects have the same title and artist
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Album)
        {

            if ((this.title.equals(((Album)obj).getTitle())) && (this.artist.equals(((Album)obj).getArtist())))
            {
                return true;
            }
            else return false;
        }
        return false;
    }

    /**
     * This method returns a textual representation of an album
     * @return a String in the format title::artist::genre::releaseDate::isAvailable
     */
    @Override
    public String toString()
    {
        int albumReleaseMonth = releaseDate.getMonth();
        int albumReleaseDay = releaseDate.getDay();
        int albumReleaseYear = releaseDate.getYear();
        String date = String.valueOf(albumReleaseMonth) + " " + String.valueOf(albumReleaseDay) + " " +
                String.valueOf(albumReleaseYear);

        String avail;
        if (isAvailable) avail = "is available";
        else avail = "not available";

        String splitColons = "::";

        //genre.name()
        return title + splitColons + artist + splitColons + genre.toString() + splitColons + date + splitColons + avail;
    }

    /**
     * Testbed main for Album class
     */
    public static void main(String[] args)
    {

    }
}
