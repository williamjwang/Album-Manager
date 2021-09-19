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
    public void run()
    {
        Scanner s = new Scanner(System.in);
        String inputLine = s.nextLine();

        Collection c = new Collection();

        while (!inputLine.equals("Q"))
        {
            StringTokenizer st = new StringTokenizer(inputLine, ",");
            String command = st.nextToken();
            if (command.equals("A"))
            {
                String title = st.nextToken();
                String artist = st.nextToken();
                Genre genre = Genre.valueOf(st.nextToken());
                Date date = new Date(st.nextToken());
                boolean isAvailable = true;
                Album temp = new Album(title, artist, genre, date, isAvailable);
                if (c.add(temp)) System.out.println(temp.toString() + " >> added");
                else System.out.println(temp.toString() + " >> is already in the collection.");

            }
            else if (command.equals("D"))
            {
                String title = st.nextToken();
                String artist = st.nextToken();
                Album temp = new Album(title, artist);
                if (c.remove(temp)) System.out.println(title + "::" + artist + " >> deleted.");
                else System.out.println(title + "::" + artist + " >> is not in the collection.");
            }
            else if (command.equals("L"))
            {
                String title = st.nextToken();
                String artist = st.nextToken();
                Album temp = new Album(title, artist);
                if (c.lendingOut(temp)) System.out.println(title + "::" + artist + " >> lending out and set to not available.");
                else System.out.println(title + "::" + artist + " >> is not available.");
            }
            else if (command.equals("R"))
            {
                String title = st.nextToken();
                String artist = st.nextToken();
                Album temp = new Album(title, artist);
                if (c.returnAlbum(temp)) System.out.println(title + "::" + artist + " >> returning and set to available.");
                else System.out.println(title + "::" + artist + " >> return cannot be completed.");
            }
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