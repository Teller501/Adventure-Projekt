import java.util.Locale;
import java.util.Scanner;

public class UserInterface {
    Scanner keyb = new Scanner(System.in).useLocale(Locale.ENGLISH);
    Adventure adventure = new Adventure();
    public void start() {
        adventure.createRooms();
        String input = "";

        while(!input.equals("exit")){
            input = keyb.nextLine().toLowerCase();

            switch(input){
                case "go north" -> adventure.goNorth();
                case "go south" -> adventure.goSouth();
                case "go east" -> adventure.goEast();
                case "go west" -> adventure.goWest();
                case "look" -> System.out.println(adventure.getCurrentRoom().getName()
                        + " " + adventure.getCurrentRoom().getDescription()) ;
                case "help" -> System.out.println("display help"); //TODO: print help commands
                case "exit" -> {
                    System.out.println("exiting program");
                    System.exit(1);
                }
            }
        }
    }
}
