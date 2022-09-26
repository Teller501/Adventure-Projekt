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
                case "go north" -> System.out.println("going north");
                case "go south" -> System.out.println("going south");
                case "go east" -> System.out.println("going east");
                case "go west" -> System.out.println("going west");
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
