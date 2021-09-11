public class Album
{
    private String title;
    private String artist;
    // private enum Genre = {}; //enum class; Classical, Country, Jazz, Pop, Unknown
    private Date releaseDate;
    private boolean isAvailable;

    enum Genre
    {
        Classical,
        Country,
        Jazz,
        Pop,
        Unknown
    }

//    public Album()
//    {
//        this.title = title;
//        this.artist = artist;
//        this.genre = Genre.Unknown;
//        this.releaseDate = releaseDate;
//        this.isAvailable = isAvailable;
//    }

    public Album(String title, String artist, Genre genre, Date releaseDate, boolean isAvailable)
    {
        this.title = title;
        this.artist = artist;
        this.genre = Genre.Unknown;
        this.releaseDate = releaseDate;
        this.isAvailable = isAvailable;
    }

    @Override
    public boolean equals(Object obj)
    {
        if ((this.title == obj.title) && (this.artist == obj.artist)) return true;
        else return false;
    }

    @Override
    public String toString()
    {
        //Need to create genre class, create genre.type
        //isAvailable?

        String displayDate = (String)releaseDate.month + "/" + (String)releaseDate.day + "/" + (String)releaseDate.year;

        String avail;
        if (isAvailable == true) avail = "is available";
        else avail = "is not available";

        return(title + "::" + artist + "::" + genre + "::" + displayDate + "::" + avail);
    }
}
