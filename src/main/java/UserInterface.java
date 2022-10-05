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
            String[] inputSplit = input.split(" ");
            String direction = "";
            String command = inputSplit[0];

            if (inputSplit.length > 1){
                direction = inputSplit[1];
            }

            switch(command){
                // TODO: fix input when typing 'go direction'
                case "go" -> { // Case for going north
                    if (adventure.go(direction)){
                        System.out.println("going " + direction);
                    }else{
                        System.out.println("you cannot go that way");
                    }
                }


                // take method, that first removes the item from the room, then adds it to player inventory
                case "take" -> {
                    Item itemPickedUp = adventure.getPlayer().getCurrentRoom().removeItem(direction);
                    if (itemPickedUp == null){
                        System.out.println("no such item..");
                    } else {
                        System.out.println("you picked up " + itemPickedUp.getName());
                        adventure.getPlayer().addItem(itemPickedUp);
                    }
                }

                // method for dropping the item, adding the item to the current room
                case "drop" -> {
                    Item itemDropped = adventure.getPlayer().removeItem(direction);
                    if (itemDropped == null){
                        System.out.println("no such item...");
                    } else {
                        System.out.println("you have dropped " + itemDropped);
                        adventure.getPlayer().getCurrentRoom().addItem(itemDropped);
                    }
                }

                // method for printing players current items they are holding
                case "inventory", "inv" -> {
                    if (adventure.getPlayer().getPlayerInventory().isEmpty()){
                        System.out.println("you are currently holding nothing...");
                    }else{
                        System.out.println("you are currently holding " + adventure.getPlayer().getPlayerInventory());
                    }
                }

                case "health", "hp" -> {
                    System.out.println("you currently have " + adventure.getPlayer().getHealth() + " hp");
                }

                case "eat" ->{} // TODO: create eat function in Player

                case "look" -> System.out.println(adventure.getCurrentRoom().getName() // TODO: write a better look case
                        + " " + adventure.getPlayer().getCurrentRoom().getRoomItems());

                case "help" -> showHelp(); // Showing list of commands
                case "exit" -> {
                    System.out.println("exiting program");
                    System.exit(1);
                }
                default -> {
                    System.out.println("unknown command.. type 'help' for list of commands");
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
                            type 'health' to see how much health you currently have
                            type 'help' to display commands
                            type 'exit' to exit game
                            """);
    }
}
