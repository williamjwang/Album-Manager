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

            if (command == "A") collection.add();
        }
    }
}
