package albums;

/**
 * This class defines the Album abstract data type with title, artist, genre, releaseDate, and isAvailable.
 *
 * There are two methods in this class: equals() and toString():
 * The equals() method is an overridden method and compares two Album objects
 * The toString() method is an overridden method and returns a textual representation of a given Album object
 *
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
     * This method sets/changes the title of the Album object
     * @param title a String representing the title of Album object being changed to
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * This method sets/changes the artist of the Album object
     * @param artist a String representing the artist of Album object being changed to
     */
    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    /**
     * This method sets/changes the genre of the Album object
     * @param genre a Genre representing the genre of Album object being changed to
     */
    public void setGenre(Genre genre)
    {
        this.genre = genre;
    }

    /**
     * This method sets/changes the release date of the Album object
     * @param releaseDate a String representing the release date of Album object being changed to
     */
    public void setDate(Date releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    /**
     * This method sets/changes the availability of the Album object
     * @param isAvailable a boolean representing the availability of Album object being changed to
     */
    public void setIsAvailable(boolean isAvailable)
    {
        this.isAvailable = isAvailable;
    }

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
     * This method returns an Album object initialized with unknown parameters and today's date
     */
    public Album()
    {
        this.title = "UNKNOWN TITLE";
        this.artist = "UNKNOWN ARTIST";
        this.genre = Genre.unknown;
        this.releaseDate = new Date();
        this.isAvailable = true;
    }

    /**
     * This method returns an Album object initialiazed with given parameters
     * @param title A String title of the Album object
     * @param artist A String artist of the Album object
     */
    public Album(String title, String artist)
    {
        this.title = title;
        this.artist = artist;
        this.genre = Genre.unknown;
        this.releaseDate = new Date();
        this.isAvailable = true;
    }


    /**
     * This method returns an Album object initialized with given parameters
     * @param title a String title of the Album object
     * @param artist a String artist of the Album object
     * @param genre a Genre genre of the Album object
     * @param releaseDate a Date object releaseDate of the Album object
     * @param isAvailable a boolean isAvailable of the ALbum object
     */
    public Album(String title, String artist, Genre genre, Date releaseDate, boolean isAvailable)
    {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.isAvailable = isAvailable;
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
        String date = String.valueOf(albumReleaseMonth) + "/" + String.valueOf(albumReleaseDay) + "/" +
                String.valueOf(albumReleaseYear);

        String avail;
        if (isAvailable) avail = "is available";
        else avail = "is not available";

        String splitColons = "::";

        //genre.name()
        return title + splitColons + artist + splitColons + genre.toString() + splitColons + date + splitColons + avail;
    }

    /**
     * Testbed main for Album class
     */
    public static void main(String[] args)
    {
        Album a1 = new Album();
        System.out.println(a1.toString());

        Date d1 = new Date();
        Album a2 = new Album("Resonance", "Home", Genre.jazz, d1, true);
        System.out.println(a2.toString());

        if (a1.equals(a2)) System.out.println("a1 = a2");
        else System.out.println("a1 != a2");

        Album a3 = new Album("Resonance", "Home", Genre.unknown, d1, false);
        if (a2.equals(a3)) System.out.println("a2 = a3");
        else System.out.println("a2 != a3");

        System.out.println(a2.getTitle());
        System.out.println(a2.getArtist());
        System.out.println(a2.getGenre().toString());
    }
}
