package albums;

/**
 * This class defines the Collection data type
 *
 * There are nine methods in this class:
 * The find() method returns the index of the album in the albums array, or if it is not found
 * The grow() method increases the size of the albums array by 4
 * The add() method adds an album to the albums array
 * The remove() method removes an album from the albums array
 * The lendingOut() method sets the isAvailable boolean attribute of an album in the albums array to false if it exists
 * The returnAlbum() method sets the isAvailable boolean attribute of an album in the albums array to true if it exists
 * The print() method displays all albums in the albums array
 * The printByReleaseDate() method displays all albums in the albums array by increasing release date
 * The printByGenre() method displays all albums in the albums array by genre
 *
 * @author William Wang, Joshua Sze
 */
public class Collection
{
    private Album[] albums;
    private int numAlbums; //number of albums currently in the collection

    private static final int NOT_FOUND = -1;

    /**
     * This method returns the albums array of the Collection object
     * @return albums array of the Collection object
     */
    public Album[] getAlbums()
    {
        return albums;
    }

    /**
     * This method returns the number of albums in the Collection object
     * @return int numAlbums of the Collection object
     */
    public int getNumAlbums()
    {
        return numAlbums;
    }

    /**
     * This method returns a Collection object
     */
    public Collection()
    {
        int initialAlbumsSize = 4;
        this.albums = new Album[initialAlbumsSize];
        this.numAlbums = 0;
    }

    /**
     * This method returns the index of a given Album object if it is in the albums array, and NOT_FOUND otherwise
     * @param album An Album object
     * @return index of given Album object or NOT_FOUND
     */
    private int find(Album album)
    {
        for (int i = 0; i < numAlbums; i++)
        {
//            if (album.getTitle().equals(albums[i].getTitle()))
//            {
//                if (album.getArtist().equals(albums[i].getArtist()))
//                {
//                    if (album.getGenre().toString().equals(albums[i].getGenre().toString()))
//                    {
//                        if (album.getDate().compareTo(albums[i].getDate()) == 0)
//                        {
//                            if (album.getIsAvailable() == albums[i].getIsAvailable())
//                            {
//                                return i;
//                            }
//                            else continue;
//                        }
//                        else continue;
//                    }
//                    else continue;
//                }
//                else continue;
//            }
//            else continue;
            if (album.equals(albums[i])) return i;
        }
        return NOT_FOUND;
    } //find the album index, or return NOT_FOUND

    /**
     * This method increases the size of the albums array by 4
     */
    private void grow()
    {
        Album[] albumsCopy = new Album[albums.length + 4];
        for (int i = 0; i < numAlbums; i++)
        {
            albumsCopy[i] = new Album();
            albumsCopy[i].setTitle(albums[i].getTitle());
            albumsCopy[i].setArtist(albums[i].getArtist());
            albumsCopy[i].setGenre(albums[i].getGenre());
            albumsCopy[i].setDate(albums[i].getDate());
            albumsCopy[i].setIsAvailable(albums[i].getIsAvailable());
        }
        albums = albumsCopy;
    } //increase the capacity of the array list by 4

    /**
     * This method adds a given, valid Album object to the albums array if it does not already exist
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
                //if genre is not in Genre, make it unknown?

                albums[numAlbums] = album;
                numAlbums++;
            }
            else return false;
        }
        else return false;
        return true;
    }

    /**
     * This method removes a given Album object from the albums array if it exists in the albums array
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
        else return false; //return false, i.e. not removed, if album is not found
        return true;
    }

    /**
     * This method sets the isAvailable boolean attribute to false
     * @param album an Album object
     * @return true if the isAvailable attribute is set to false, false otherwise
     */
    public boolean lendingOut(Album album)
    {
        if (find(album) != NOT_FOUND)
        {
            for (int i = 0; i < numAlbums; i++)
            {
                if (album.equals(albums[i]) && (albums[i].getIsAvailable() == true))
                {
                    albums[i].setIsAvailable(false);
                    break;
                }
                else return false;
            }
        }
        else return false;
        return true;
    } //set to not available

    /**
     * This method sets the isAvailable boolean attribute to true
     * @param album an Album object
     * @return true if the isAvailable attribute is set to true, false otherwise
     */
    public boolean returnAlbum(Album album)
    {
        if (find(album) != NOT_FOUND)
        {
            for (int i = 0; i < numAlbums; i++)
            {
                if (album.equals(albums[i]) && (albums[i].getIsAvailable() == false))
                {
                    albums[i].setIsAvailable(true);
                    break;
                }
                else return false;
            }
        }
        else return false;
        return true;
    } //set to available

    /**
     * This method prints out all Album objects in the albums array
     */
    public void print()
    {
        if (numAlbums == 0) System.out.println("The collection is empty!");
        else
        {
            System.out.println("*List of albums in the collection.");
            for (int i = 0; i < numAlbums; i++)
            {
                System.out.println(albums[i].toString());
            }
            System.out.println("*End of list.");
        }

    } //display the list without specifying the order

    /**
     * This method prints out all Album objects in the albums array by increasing release date
     */
    public void printByReleaseDate()
    {
//        Album[] albumsCopy = new Album[numAlbums];
//        for (int i = 0; i < numAlbums; i++)
//        {
//            albumsCopy[i].setTitle(albums[i].getTitle());
//            albumsCopy[i].setArtist(albums[i].getArtist());
//            albumsCopy[i].setGenre(albums[i].getGenre());
//            albumsCopy[i].setDate(albums[i].getDate());
//            albumsCopy[i].setIsAvailable(albums[i].getIsAvailable());
//        }
//        Album temp =  albumsCopy[0];
//        int AFTER = 1;
//        for (int i = 0; i < albumsCopy.length; i++)
//        {
//            if (temp.getDate().compareTo(albumsCopy[i].getDate()) == AFTER)
//            {
//                temp = albumsCopy[i];
//            }
//            System.out.println(temp.toString());
//
//            for (int j = 0; j< numAlbums; j++)
//            {
//                if (temp.equals(albumsCopy[i]))
//                {
//                    for (int k = j; k < numAlbums; k++)
//                    {
//                        albumsCopy[k] = albumsCopy[k+1];
//                    }
//                    albumsCopy[numAlbums - 1] = null;
//                    numAlbums--;
//                    break;
//                }
//            }
//        }
        int BEFORE = -1;
        if (numAlbums == 0) System.out.println("The collection is empty!");
        else
        {
            System.out.println("*Album collection by the release dates.");
            Album[] dateAlbum = albums;
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
            for (int k = 0; k < numAlbums; k++) System.out.println(dateAlbum[k].toString());
            System.out.println("*End of list.");
        }
    }

    /**
     * This method prints out all Album objects in the albums array by genre
     */
    public void printByGenre()
    {
        if (numAlbums == 0) System.out.println("The collection is empty!");
        else
        {
            System.out.println("*Album collection by genre.");
            //print all Classical albums in albums array
            for (int i = 0; i < numAlbums; i++)
            {
                if (albums[i].getGenre().toString().equals(Genre.classical.toString()))
                {
                    System.out.println(albums[i].toString());
                }
            }
            //print all Country albums in albums array
            for (int i = 0; i < numAlbums; i++)
            {
                if (albums[i].getGenre().toString().equals(Genre.country.toString()))
                {
                    System.out.println(albums[i].toString());
                }
            }
            //print all Jazz albums in albums array
            for (int i = 0; i < numAlbums; i++)
            {
                if (albums[i].getGenre().toString().equals(Genre.jazz.toString()))
                {
                    System.out.println(albums[i].toString());
                }
            }
            //print all Pop albums in albums array
            for (int i = 0; i < numAlbums; i++)
            {
                if (albums[i].getGenre().toString().equals(Genre.pop.toString()))
                {
                    System.out.println(albums[i].toString());
                }
            }
            //print all Unknown albums in albums array
            for (int i = 0; i < numAlbums; i++)
            {
                if (albums[i].getGenre().toString().equals(Genre.unknown.toString()))
                {
                    System.out.println(albums[i].toString());
                }
            }
            System.out.println("*End of list.");
        }
    }

    /**
     * Testbed main for Collection class
     * @param args
     */
    public static void main (String[] args)
    {
        Collection c = new Collection();
//        Album a1 = new Album();
//        c.add(a1);
//        c.print();
//        Date d1 = new Date();
//        Album a2 = new Album("Resonance", "Home", Genre.Jazz, d1, true);
//        c.add(a2);
//        c.print();
//        c.printByGenre();

        Date D1 = new Date("7/9/2000");
        Album b1 = new Album("apples", "johnny appleseed", Genre.pop, D1, true);

        Date D2 = new Date("8/6/1995");
        Album b2 = new Album("oranges", "johnny orangeseed", Genre.classical, D2, true);

        Date D3 = new Date("12/15/1997");
        Album b3 = new Album("lemons", "johnny lemonseed", Genre.unknown, D3, true);

        c.add(b1);
        c.add(b2);
        c.add(b3);

//        System.out.println("Print:"); //D1 D2 D3
//        c.print();
//
//        System.out.println("Print by Genre:"); //D2 D1 D3
//        c.printByGenre();

        System.out.println("Print by Release Date:"); //D2 D3 D1
        c.printByReleaseDate();
    }
}
