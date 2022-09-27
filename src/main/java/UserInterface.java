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
                case "go north" -> {
                    if (adventure.goNorth()){
                        System.out.println(adventure.getCurrentRoom().getName()
                                + " " + adventure.getCurrentRoom().getDescription());
                    }else{
                        System.out.println("you cannot go that way");
                    }
                }
                case "go south" -> {
                    if (adventure.goSouth()){
                        System.out.println(adventure.getCurrentRoom().getName()
                                + " " + adventure.getCurrentRoom().getDescription());
                    }else{
                        System.out.println("you cannot go that way");
                    }
                }
                case "go east" -> {
                    if (adventure.goEast()){
                        System.out.println(adventure.getCurrentRoom().getName()
                                + " " + adventure.getCurrentRoom().getDescription());
                    }else{
                        System.out.println("you cannot go that way");
                    }
                }
                case "go west" -> {
                    if (adventure.goWest()){
                        System.out.println(adventure.getCurrentRoom().getName()
                                + " " + adventure.getCurrentRoom().getDescription());
                    }else{
                        System.out.println("you cannot go that way");
                    }
                }
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
