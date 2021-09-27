package albums;

/**
 * This class defines the Collection data type.
 * @author William Wang, Joshua Sze
 */
public class Collection
{
    private Album[] albums;
    private int numAlbums; //number of albums currently in the collection

    private static final int NOT_FOUND = -1;

    /**
     * This method returns a Collection object.
     */
    public Collection()
    {
        int initialAlbumsSize = 4;
        this.albums = new Album[initialAlbumsSize];
        this.numAlbums = 0;
    }

    /**
     * This method returns the index of a given Album object if it is in the albums array, and NOT_FOUND otherwise.
     * @param album An Album object
     * @return index of given Album object or NOT_FOUND
     */
    private int find(Album album)
    {
        for (int i = 0; i < numAlbums; i++)
        {
            if (album.equals(albums[i])) return i;
        }
        return NOT_FOUND;
    } //find the album index, or return NOT_FOUND

    /**
     * This method increases the size of the albums array by 4.
     */
    private void grow()
    {
        Album[] albumsCopy = new Album[albums.length + 4];
        for (int i = 0; i < numAlbums; i++)
        {
            String title = albums[i].getTitle();
            String artist = albums[i].getArtist();
            Genre genre = albums[i].getGenre();
            Date date = albums[i].getDate();
            boolean isAvailable = albums[i].getIsAvailable();
            albumsCopy[i] = new Album(title, artist, genre, date, isAvailable);
        }
        albums = albumsCopy;
    } //increase the capacity of the array list by 4

    /**
     * This method adds a given, valid Album object to the albums array if it does not already exist.
     * @param album an Album object
     * @return true if added, false otherwise
     */
    public boolean add(Album album)
    {
        if (numAlbums == albums.length) grow();
        if (find(album) == NOT_FOUND)
        {
            //only want to add the album to the collection if it has a valid date
            if (album.getDate().isValid())
            {
                albums[numAlbums] = album;
                numAlbums++;
            }
            else return false;
        }
        else return false;
        return true;
    }

    /**
     * This method removes a given Album object from the albums array if it exists in the albums array.
     * @param album an Album object
     * @return true if removed, false otherwise
     */
    public boolean remove(Album album)
    {
        if (find(album) != NOT_FOUND)
        {
            for (int i = 0; i< numAlbums; i++)
            {
                if (album.equals(albums[i]))
                {
                    for (int j = i; j < numAlbums - 1; j++)
                    {
                        albums[j] = albums[j+1];
                    }
                    albums[numAlbums - 1] = null;
                    numAlbums--;
                    break;
                }
            }
        }
        else return false;
        return true;
    }

    /**
     * This method sets the isAvailable boolean attribute to false if it is not already false.
     * @param album an Album object
     * @return true if the isAvailable attribute is set to false, false otherwise
     */
    public boolean lendingOut(Album album)
    {
        if (find(album) != NOT_FOUND)
        {
            for (int i = 0; i < numAlbums; i++)
            {
                if (album.equals(albums[i]))
                {
                    if (albums[i].getIsAvailable())
                    {
                        albums[i].setIsAvailable(false);
                        return true;
                    }
                }
            }
        }
        return false;
    } //set to not available

    /**
     * This method sets the isAvailable boolean attribute to true if it is not already true.
     * @param album an Album object
     * @return true if the isAvailable attribute is set to true, false otherwise
     */
    public boolean returnAlbum(Album album)
    {
        if (find(album) != NOT_FOUND)
        {
            for (int i = 0; i < numAlbums; i++)
            {
                if (album.equals(albums[i]))
                {
                    if (!albums[i].getIsAvailable())
                    {
                        albums[i].setIsAvailable(true);
                        return true;
                    }
                }
            }
        }
        return false;
    } //set to available

    /**
     * This method prints out all Album objects in the albums array.
     */
    public void print()
    {
        if (numAlbums == 0) System.out.print("The collection is empty!\n");
        else
        {
            System.out.print("*List of albums in the collection.\n");
            for (int i = 0; i < numAlbums; i++)
            {
                System.out.print(albums[i].toString() + "\n");
            }
            System.out.print("*End of list.\n");
        }

    } //display the list without specifying the order

    /**
     * This method prints out all Album objects in the albums array by increasing release date.
     */
    public void printByReleaseDate()
    {
        int BEFORE = -1;
        if (numAlbums == 0) System.out.print("The collection is empty!\n");
        else
        {
            System.out.print("*Album collection by the release dates.\n");
            Album[] dateAlbum = new Album[albums.length];
            for (int i = 0; i < numAlbums; i++)
            {
                String title = albums[i].getTitle();
                String artist = albums[i].getArtist();
                Genre genre = albums[i].getGenre();
                Date date = albums[i].getDate();
                boolean isAvailable = albums[i].getIsAvailable();
                dateAlbum[i] = new Album(title, artist, genre, date, isAvailable);
            }

            for (int i = 0; i < numAlbums - 1; i++)
            {
                int min_date_index = i;
                for (int j = i + 1; j < numAlbums; j++)
                {
                    if (dateAlbum[j].getDate().compareTo(dateAlbum[min_date_index].getDate()) == BEFORE)
                    {
                        min_date_index = j;
                    }
                }
                Album temp = dateAlbum[min_date_index];
                dateAlbum[min_date_index] = dateAlbum[i];
                dateAlbum[i] = temp;
            }
            for (int k = 0; k < numAlbums; k++) System.out.print(dateAlbum[k].toString() + "\n");
            System.out.print("*End of list.\n");
        }
    }

    /**
     * This method prints out all Album objects in the albums array by genre.
     */
    public void printByGenre()
    {
        if (numAlbums == 0) System.out.print("The collection is empty!\n");
        else
        {
            System.out.print("*Album collection by genre.\n");
            //print all Classical albums in albums array
            for (int i = 0; i < numAlbums; i++)
            {
                if (albums[i].getGenre().toString().equals(Genre.Classical.toString()))
                {
                    System.out.print(albums[i].toString() + "\n");
                }
            }
            //print all Country albums in albums array
            for (int i = 0; i < numAlbums; i++)
            {
                if (albums[i].getGenre().toString().equals(Genre.Country.toString()))
                {
                    System.out.print(albums[i].toString() + "\n");
                }
            }
            //print all Jazz albums in albums array
            for (int i = 0; i < numAlbums; i++)
            {
                if (albums[i].getGenre().toString().equals(Genre.Jazz.toString()))
                {
                    System.out.print(albums[i].toString() + "\n");
                }
            }
            //print all Pop albums in albums array
            for (int i = 0; i < numAlbums; i++)
            {
                if (albums[i].getGenre().toString().equals(Genre.Pop.toString()))
                {
                    System.out.print(albums[i].toString() + "\n");
                }
            }
            //print all Unknown albums in albums array
            for (int i = 0; i < numAlbums; i++)
            {
                if (albums[i].getGenre().toString().equals(Genre.Unknown.toString()))
                {
                    System.out.print(albums[i].toString() + "\n");
                }
            }
            System.out.print("*End of list.\n");
        }
    }
}
