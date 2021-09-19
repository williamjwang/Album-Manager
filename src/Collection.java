//package albums;

public class Collection {
    private Album[] albums;
    private int numAlbums; //number of albums currently in the collection

    private int find(Album album) {
        for (int i = 0; i < numAlbums; i++) {
            if (album.equals(albums[i])) {
                return i;
            }
        }
        return -1;
    } //find the album index, or return NOT_FOUND

    private void grow() {
        // last four albums may be void
        Album[] albumsCopy = new Album[numAlbums + 4];
        for (int i = 0; i < numAlbums; i++) {
            albumsCopy[i].title = albums[i].title;
            albumsCopy[i].artist = albums[i].artist;
            albumsCopy[i].Genre = albums[i].Genre;
            albumsCopy[i].Date = albums[i].Date;
            albumsCopy[i].isAvailable = albums[i].isAvailable;
        }
        albums = new Album[numAlbums + 4];
        numAlbums += 4;
        albums = albumsCopy;
    } //increase the capacity of the array list by 4

    public boolean add(Album album) {
        if (numAlbums == albums.size()) {
            grow();
        }
        albums[numAlbums] = album;
        numAlbums++;
    }

    public boolean remove(Album album) {
        int i = 0;
        while (i < numAlbums) {
            if (albums[i].title.equals(album.title) && albums[i].artist.equals(album.artist)) {
                int j = i + 1;
                while (j < numAlbums - 1) {
                    albums[i] = albums[j];
                    j++;
                }
                albums[numAlbums] = null;
                numAlbums--;
                return true;
            }
            i++;
        }
        System.out.println();
        return false;
    }

    public boolean lendingOut(Album album) {
        int i = 0;
        while (i < numAlbums) {
            if (albums[i].title.equals(album.title) && albums[i].artist.equals(album.artist)) {
                albums[i].isAvailable = false;
                return true;
            }
            i++;
        }
        System.out.println();
        return false;
    } //set to not available

    public boolean returnAlbum(Album album) {
        int i = 0;
        while (i < numAlbums) {
            if (albums[i].title.equals(album.title) && albums[i].artist.equals(album.artist)) {
                albums[i].isAvailable = true;
                return true;
            }
            i++;
        }
        System.out.println();
        return false;
    } //set to available

    public void print() {
        System.out.println("*List of albums in the collection");
        for (int i = 0; i < numAlbums; i++) {
            System.out.println(albums[i].toString());
        }
        System.out.println("");
    } //display the list without specifying the order

    public void printByReleaseDate() {
        System.out.println("*List of albums in the collection");
        for (int i = 0; i < numAlbums; i++)
        {

        }
    }

    public Album[] organizeGenre(Album[] genreAlbum)
    {
        int i = 0;
        for (int j = 0; j < numAlbums; j++)
        {
            if (albums[j].Genre.equals("classical"))
            {
                genreAlbum[i] = albums[j];
                i++;
            }
        }
        for (int k = 0; k < numAlbums; k++)
        {
            if (albums[k].Genre.equals("country"))
            {
                genreAlbum[i] = albums[k];
                i++;
            }
        }
        for (int l = 0; l < numAlbums; l++)
        {
            if (albums[l].Genre.equals("jazz"))
            {
                genreAlbum[i] = albums[l];
                i++;
            }
        }
        for (int m = 0; m < numAlbums; m++)
        {
            if (albums[m].Genre.equals("pop"))
            {
                genreAlbum[i] = albums[m];
                i++;
            }
        }
        for (int n = 0; n < numAlbums; n++)
        {
            if (albums[n].Genre.equals("unknown"))
            {
                genreAlbum[i] = albums[n];
                i++;
            }
        }
        return genreAlbum;
    }

    public void printByGenre() {
        Album[] genreAlbum = new Album[numAlbums];
        genreAlbum = organizeGenre(genreAlbum);
        for (int i = 0; i < numAlbums; i++)
        {
            System.out.println(genreAlbum[i].toString());
        }
        System.out.println("*List of albums in the collection");
    }
}
