//package albums;

import java.util.Scanner;

public class CollectionManager
{
    public static boolean acceptableInput(String input)
    {
        String command = input;
        String split[] = command.split(",", 2);
        command = split[0];

        if (command.equals("A") || command.equals("D") || command.equals("L") || command.equals("R") || command.equals("P") || command.equals("PD") || command.equals("PG"))
        {
            return false;
        }
        else return true;
    }

    public void run()
    {
        Scanner s = new Scanner(System.in);
        String input = "";

        Collection collection = new Collection();

        while (!input.equals("Q"))
        {
            if (acceptableInput(input) == false) System.out.println("Invalid command!");

            String command = input;
            String split[] = command.split(",", 2);
            command = split[0];

            if (command == "A") collection.add(); // add an album to the collection,
            else if (command == "D") // remove an album from the collection
            {
                collection.remove();
            }
            else if (command == "L") // lend out an album
            {
                collection.lendingOut();
            }
            else if (command == "R") // return an album
            {
                collection.returnAlbum();
            }
            else if (command == "P") // display the collection without displaying the order
            {
                collection.print():
            }
            else if (command == "PD") // display the collection sorted by the release dates
            {
                collection.printByReleaseDate();
            }
            else if (command == "PG") // display the collection sorted by the genres
            {
                collection.printByGenre();
            }
        }
        System.out.printf("Collection Manager terminated.");
    }
}
