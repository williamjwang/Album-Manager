public class Album
{
    private String title;
    private String artist;
    private Genre genre; //enum class; Classical, Country, Jazz, Pop, Unknown
    private Date releaseDate;
    private boolean isAvailable;

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
        //Need to create Data class, create releaseDate.Date
        //isAvailable?

        String avail;
        if (isAvailable == true) avail = "is available";
        else {}

        return(title + "::" + artist + "::" + genre + "::" + releaseDate + "::" + isAvailable);
    }
}
