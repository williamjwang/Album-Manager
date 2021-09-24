package albums;
import java.util.StringTokenizer;
import java.util.Scanner;

/**
 * This class defines the CollectionManager abstract data type.
 * @author William Wang
 */
public class CollectionManager
{
    /**
     * This method takes a String and returns the String with the first letter capitalized.
     * @param input A String
     * @return A String with its first letter capitalized
     */
    private static String firstToUpperCase(String input)
    {
        return Character.toUpperCase(input.charAt(0)) + "" + input.substring(1);
    }

    /**
     * This method implements the add() functionality for the Collection Manager.
     * @param st A StringTokenizer object
     * @param c A Collection object
     * @return A Collection object, with a new Album added to it through a given String inputLine tokenized
     */
    private static Collection CM_add(StringTokenizer st, Collection c)
    {
        String title = st.nextToken();
        String artist = st.nextToken();
        String genreType = firstToUpperCase(st.nextToken());
        if (!(genreType.equals("Classical") || genreType.equals("Country") || genreType.equals("Jazz") || genreType.equals("Pop")))
        {
            genreType = "Unknown";
        }
        Genre genre = Genre.valueOf(genreType);
        Date date = new Date(st.nextToken());
        boolean isAvailable = true;
        Album temp = new Album(title, artist, genre, date, isAvailable);
        if (!date.isValid()) System.out.println("Invalid date!");
        else if (c.add(temp)) System.out.println(temp.toString() + " >> added.");
        else System.out.println(temp.toString() + " >> is already in the collection.");
        return c;
    }

    /**
     * This method implements the remove() functionality for the Collection Manager.
     * @param st A StringTokenizer object
     * @param c A Collection object
     * @return A Collection object, with an Album deleted from it through a given String inputLine tokenized
     */
    private static Collection CM_delete(StringTokenizer st, Collection c)
    {
        String title = st.nextToken();
        String artist = st.nextToken();
        Album temp = new Album(title, artist);
        if (c.remove(temp)) System.out.println(title + "::" + artist + " >> deleted.");
        else System.out.println(title + "::" + artist + " >> is not in the collection.");
        return c;
    }

    /**
     * This method implements the lendingOut() functionality for the Collection Manager.
     * @param st A StringTokenizer object
     * @param c A Collection object
     * @return A Collection object, with an Album's isAvailable parameter set to false if it exists and is not already set to false
     */
    private static Collection CM_lendingOut(StringTokenizer st, Collection c)
    {
        String title = st.nextToken();
        String artist = st.nextToken();
        Album temp = new Album(title, artist);
        if (c.lendingOut(temp)) System.out.println(title + "::" + artist + " >> lending out and set to not available.");
        else System.out.println(title + "::" + artist + " >> is not available.");
        return c;
    }

    /**
     * This method implements the returnAlbum() functionality for the Collection Manager.
     * @param st A StringTokenizer object
     * @param c A Collection object
     * @return A Collection object, with an Album's isAvailable parameter set to true if it exists and is not already set to true
     */
    private static Collection CM_returnAlbum(StringTokenizer st, Collection c)
    {
        String title = st.nextToken();
        String artist = st.nextToken();
        Album temp = new Album(title, artist);
        if (c.returnAlbum(temp)) System.out.println(title + "::" + artist + " >> returning and set to available.");
        else System.out.println(title + "::" + artist + " >> return cannot be completed.");
        return c;
    }

    /**
     * This method creates a Collection object and simulates the addition, removal, and other functionality of Album objects.
     */
    public void run()
    {
        System.out.println("Collection Manager starts running.");
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
            else if (command.equals("R")) c = CM_returnAlbum(st, c);
            else if (command.equals("P")) c.print();
            else if (command.equals("PD")) c.printByReleaseDate();
            else if (command.equals("PG")) c.printByGenre();
            else System.out.println("Invalid command!");
            inputLine = s.nextLine();
        }
        System.out.println("Collection Manager terminated.");
    }
}