import java.util.Locale;
import java.util.Scanner;

public class UserInterface {


    private Scanner keyb = new Scanner(System.in).useLocale(Locale.ENGLISH);
    private Adventure adventure;
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

        handleInput(input);
    }

    // Method for handling all input from user
    public void handleInput(String input) {
        while(!input.equals("exit")){
            input = keyb.nextLine().toLowerCase();

            switch(input){
                case "north", "n" -> { // Case for going north
                    if (adventure.go("north")){
                        System.out.println("going north");
                    }else{
                        System.out.println("you cannot go that way");
                    }
                }
                case "south", "s" -> {
                    if (adventure.go("south")){ // Case for going south
                        System.out.println("going south");
                    }else{
                        System.out.println("you cannot go that way");
                    }
                }
                case "east","e" -> { // Case for going east
                    if (adventure.go("east")){
                        System.out.println("going east");
                    }else{
                        System.out.println("you cannot go that way");
                    }
                }
                case "west","w" -> { // Case for going west
                    if (adventure.go("west")){
                        System.out.println("going west");
                    }else{
                        System.out.println("you cannot go that way");
                    }
                }

                // take method, that first removes the item from the room, then adds it to player inventory
                case "take" -> {
                    Item itemPickedUp = adventure.getPlayer().getCurrentRoom().removeItem(input);
                    if (itemPickedUp == null){
                        System.out.println("no such item..");
                    } else {
                        System.out.println("you picked up " + itemPickedUp.getName());
                        adventure.getPlayer().addItem(itemPickedUp);
                    }
                }

                case "look" -> System.out.println(adventure.getCurrentRoom().getName() // TODO: write a better look case
                        + " " + adventure.getCurrentRoom().getRoomItems());
                case "help" -> showHelp(); // Showing list of commands
                case "exit" -> {
                    System.out.println("exiting program");
                    System.exit(1);
                }
            }
        }
    }

    public void showHelp(){
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
}
