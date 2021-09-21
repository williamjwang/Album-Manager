package albums;
import java.util.StringTokenizer;
import java.util.Scanner;

/**
 * This class defines the CollectionManager abstract data type
 * ...
 * There is one method in this class: run()
 * The run() method simulates a Collection object and
 */
public class CollectionManager
{
    private static final int NOT_FOUND = 0;

    private Collection CM_add(StringTokenizer st, Collection c)
    {
        String title = st.nextToken();
        String artist = st.nextToken();
        String genreType = st.nextToken();
        if (!(genreType.equals("classical") || genreType.equals("country") || genreType.equals("jazz") || genreType.equals("pop")))
        {
            genreType = "unknown";
        }
        Genre genre = Genre.valueOf(genreType);
        Date date = new Date(st.nextToken());
        boolean isAvailable = true;
        Album temp = new Album(title, artist, genre, date, isAvailable);
        if (!date.isValid())
        {
            System.out.println("Invalid date!");
            return c;
        }
        else if (c.add(temp))
        {
            System.out.println(temp.toString() + " >> added");
            return c;
        }
        else
        {
            System.out.println(temp.toString() + " >> is already in the collection.");
            return c;
        }
    }

    private Collection CM_delete(StringTokenizer st, Collection c)
    {
        String title = st.nextToken();
        String artist = st.nextToken();
        Album temp = new Album(title, artist);
        if (c.remove(temp))
        {
            System.out.println(title + "::" + artist + " >> deleted.");
            return c;
        }
        else {
            System.out.println(title + "::" + artist + " >> is not in the collection.");
            return c;
        }
    }

    private Collection CM_lendingOut(StringTokenizer st, Collection c)
    {
        String title = st.nextToken();
        String artist = st.nextToken();
        Album temp = new Album(title, artist);
        if (c.lendingOut(temp)) {
            System.out.println(title + "::" + artist + " >> lending out and set to not available.");
            return c;
        }
        else {
            System.out.println(title + "::" + artist + " >> is not available.");
            return c;
        }
    }

    private Collection CM_return(StringTokenizer st, Collection c)
    {
        String title = st.nextToken();
        String artist = st.nextToken();
        Album temp = new Album(title, artist);
        if (c.returnAlbum(temp)) {
            System.out.println(title + "::" + artist + " >> returning and set to available.");
            return c;
        }
        else {
            System.out.println(title + "::" + artist + " >> return cannot be completed.");
            return c;
        }
    }

    public void run()
    {
        Scanner s = new Scanner(System.in);
        String inputLine = s.nextLine();

        Collection c = new Collection();

        while (!inputLine.equals("Q"))
        {
            StringTokenizer st = new StringTokenizer(inputLine, ",");
            String command = st.nextToken();
            if (command.equals("A")) c = CM_add(st, c);
            else if (command.equals("D")) c = CM_delete(st, c);
            else if (command.equals("L")) c = CM_lendingOut(st, c);
            else if (command.equals("R")) c = CM_return(st, c);
            else if (command.equals("P")) c.print();
            else if (command.equals("PD")) c.printByReleaseDate();
            else if (command.equals("PG")) c.printByGenre();
            else System.out.println("Invalid command!");

            inputLine = s.nextLine();
        }
        System.out.println("Collection Manager terminated.");
    }

    public static void main(String[] args)
    {
       CollectionManager cm =  new CollectionManager();
       cm.run();
    }
}