public class Collection {
    public class Collection {
        private Album[] albums;
        private int numAlbums; //number of albums currently in the collection

        private int find(Album album) {
            for (int i = 0; i < numAlbums; i++)
            {
                if (album.equals(albums[i]))
                {
                    return i;
                }
            }
            return -1;
        } //find the album index, or return NOT_FOUND
        private void grow()
        {
            // last four albums may be void
            Album[] albumsCopy = new Album[numAlbums + 4];
            for (int i = 0; i < numAlbums; i++)
            {
                albumsCopy[i].title = albums[i].title;
                albumsCopy[i].artist = albums[i].artist;
                albumsCopy[i].Genre = albums[i].genre;
                albumsCopy[i].Date = albums[i].Date;
                albumsCopy[i].isAvailable = albums[i].isAvailable;
            }
            albums = new Album[numAlbums + 4];
            numAlbums += 4;
            albums = albumsCopy;
        } //increase the capacity of the array list by 4
        public boolean add(Album album)
        {
            if (numAlbums == albums.size())
            {
                grow();
            }
            int i = 0;
            while (i < numAlbums) {
                if ()
            }
        }
        public boolean remove(Album album) {}
        public boolean lendingOut(Album album) {} //set to not available
        public boolean returnAlbum(Album album) {} //set to available
        public void print() {
            System.out.println("*List of albums in the collection");
            for (int i = 0; i < numAlbums; i++)
            {
                System.out.println(albums[i].toString());
            }
            System.out.println("");
        } //display the list without specifying the order
        public void printByReleaseDate() {}
        public void printByGenre() {}
        }
    }
}
