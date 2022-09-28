import java.util.Locale;
import java.util.Scanner;

public class UserInterface {


    Scanner keyb = new Scanner(System.in).useLocale(Locale.ENGLISH);
    Adventure adventure;
    public void start() {
        adventure = new Adventure();
        System.out.println("""
                ______            _                _                       _____  _____ _____ _____\s
                |  ___|          | |              | |                     / __  \\|  _  |  ___|  _  |
                | |_ _ __ ___  __| | ___ _ __  ___| |__   ___  _ __ __ _  `' / /'| |/' |___ \\ \\ V /\s
                |  _| '__/ _ \\/ _` |/ _ \\ '_ \\/ __| '_ \\ / _ \\| '__/ _` |   / /  |  /| |   \\ \\/ _ \\\s
                | | | | |  __/ (_| |  __/ | | \\__ \\ |_) | (_) | | | (_| | ./ /___\\ |_/ /\\__/ / |_| |
                \\_| |_|  \\___|\\__,_|\\___|_| |_|___/_.__/ \\___/|_|  \\__, | \\_____/ \\___/\\____/\\_____/
                                                                    __/ |                          \s
                                                                   |___/   \s
                
                the year is 2058. 
                you find yourself in the aftermath of an apocalypse in the city of Fredensborg.
                you look around.
                
                
                type 'help' for a list of commands to start
                """);

        String input = "";

        while(!input.equals("exit")){
            input = keyb.nextLine().toLowerCase();

            switch(input){
                case "north" -> {
                    if (adventure.goNorth()){
                        System.out.println("going north");
                    }else{
                        System.out.println("you cannot go that way");
                    }
                }
                case "south" -> {
                    if (adventure.goSouth()){
                        System.out.println("going south");
                    }else{
                        System.out.println("you cannot go that way");
                    }
                }
                case "east" -> {
                    if (adventure.goEast()){
                        System.out.println("going east");
                    }else{
                        System.out.println("you cannot go that way");
                    }
                }
                case "west" -> {
                    if (adventure.goWest()){
                        System.out.println("going west");
                    }else{
                        System.out.println("you cannot go that way");
                    }
                }
                case "look" -> System.out.println(adventure.getCurrentRoom().getName()
                        + " " + adventure.getCurrentRoom().getDescription());
                case "help" -> {
                    System.out.println("""
                            type 'go north' to go north
                            type 'go south' to go south
                            type 'go east' to go east
                            type 'go west' to go west
                            
                            type 'look' to get a description of your sorroundings
                            type 'help' to display commands
                            type 'exit' to exit game
                            """);
                }
                case "exit" -> {
                    System.out.println("exiting program");
                    System.exit(1);
                }
            }
        }
    }
}
