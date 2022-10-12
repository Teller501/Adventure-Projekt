import java.util.Locale;
import java.util.Scanner;

public class UserInterface {


    private Scanner keyb = new Scanner(System.in).useLocale(Locale.ENGLISH);
    private Adventure adventure;
    private String unBold = "\u001b[0m";
    private String bold = "\u001b[1m";
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
                
                
                type 'look' to look around
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
            String userChoice = "";
            String command = inputSplit[0];

            if (inputSplit.length > 1){
                userChoice = inputSplit[1];
            }

            switch(command){
                case "go" -> { // Case for going north
                    if (adventure.go(userChoice)){
                        System.out.println("going " + userChoice);
                    }else{
                        System.out.println("you cannot go that way");
                    }
                }


                // take method, that first removes the item from the room, then adds it to player inventory
                case "take" -> {
                    Item itemPickedUp = adventure.getPlayer().getCurrentRoom().removeItem(userChoice);
                    if (itemPickedUp == null){
                        System.out.println("no such item..");
                    } else {
                        System.out.println("you picked up " + itemPickedUp.getName());
                        adventure.getPlayer().addItem(itemPickedUp);
                    }
                }

                // method for dropping the item, adding the item to the current room
                case "drop" -> {
                    Item itemDropped = adventure.getPlayer().removeItem(userChoice);
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
                        System.out.println("you are currently holding: ");
                        for (Item item : adventure.getPlayer().getPlayerInventory()){
                            if (item instanceof Food){
                                System.out.println(bold + item.getName() + unBold + " - food");
                            } else if (item instanceof Weapon){
                                System.out.println(bold + item.getName() + unBold + " - weapon");
                            } else {
                                System.out.println(bold + item.getName());
                            }
                        }
                    }

                    if(adventure.getPlayer().getEquippedWeapon() == null){
                        System.out.println("you are currently not holding a weapon");
                    }else{
                        System.out.println(bold + adventure.getPlayer().getEquippedWeapon().getName() + unBold + " is equipped");
                    }
                }

                case "health", "hp" -> {
                    System.out.println("you currently have " + bold + adventure.getPlayer().getHealth() + unBold +" hp");
                }

                case "eat" ->{
                    ReturnMessage result = adventure.playerEat(userChoice);
                    switch(result){
                        case OK -> {
                            System.out.println("you eat " + bold + userChoice);
                            System.out.println("your health is now at " + bold + adventure.getPlayer().getHealth());
                            if (adventure.getPlayer().isDead()){
                                System.out.println("you died, try again!!");
                                System.exit(1);
                            }
                        }
                        case CANT -> System.out.println(userChoice + " cannot be eaten ");
                        case NOT_FOUND -> System.out.println("Invalid item " + userChoice);

                    }
                }

                case "equip" -> {
                    ReturnMessage result = adventure.equip(userChoice);
                    switch (result){
                        case OK-> System.out.println("you equipped " + bold + userChoice);
                        case CANT -> System.out.println(bold + userChoice + unBold + " cannot be equipped.");
                        case NOT_FOUND -> System.out.println(bold + userChoice + unBold + " is an invalid item or is not in inventory");
                    }
                }

                case "attack" -> {
                    AttackStatus result = adventure.attack(userChoice);
                    switch (result){
                        case NO_ENEMY -> System.out.println("no enemy in sight..");
                        case NO_SUCH_ENEMY -> {
                            Enemy nearestEnemy = null;
                            if (!adventure.getCurrentRoom().getEnemies().isEmpty()){
                                nearestEnemy = adventure.getCurrentRoom().getEnemies().get(0);
                            }
                            if (!adventure.getPlayer().isDead()) {
                                if (!adventure.getCurrentRoom().getEnemies().isEmpty()){
                                    System.out.println(unBold + "you attack " + bold + nearestEnemy.getName() + unBold + " with " + bold + adventure.getPlayer().getEquippedWeapon().getName());
                                    for (Enemy enemy : adventure.getCurrentRoom().getEnemies()){
                                        System.out.println(bold + enemy.getName() + unBold + " HP: " + bold + enemy.getHealthPoints());
                                    }
                                    System.out.println("you got hit by " + bold + nearestEnemy.getName() + unBold + "!");
                                    System.out.println("your health is now " + bold + adventure.getPlayer().getHealth() + unBold + " HP");
                                }
                            }else{
                                System.out.println("you are dead, goodbye!!!");
                                System.exit(1);
                            }
                        }
                        case NO_USEABLE_WEAPON -> System.out.println("your weapon is not very useable at the moment..");
                        case NO_WEAPON -> System.out.println("you are not wielding any weapon...");
                        case ATTACKED -> {
                            if (!adventure.getPlayer().isDead()) {
                                System.out.println("you attack " + bold + userChoice + unBold + " with " + bold + adventure.getPlayer().getEquippedWeapon().getName());
                                for (Enemy enemy : adventure.getCurrentRoom().getEnemies()){
                                    System.out.println(bold + enemy.getName() + unBold + " HP: " + bold + enemy.getHealthPoints());
                                    if (!enemy.isDead()){
                                        System.out.println("you got hit by " + bold + userChoice + unBold + "!");
                                        System.out.println("your health is now " + bold + adventure.getPlayer().getHealth() + unBold + " HP");
                                    }
                                }
                            }else{
                                System.out.println("you are dead. Try again!");
                                System.exit(1);
                            }
                        }
                    }
                }

                case "look" -> {
                    System.out.println("you are at a " + bold + adventure.getPlayer().getCurrentRoom().getName() + unBold + ". " + adventure.getPlayer().getCurrentRoom().getDescription()+"\n");

                    // Printing out items in the current room if arraylist is not empty
                    if (!adventure.getPlayer().getCurrentRoom().getRoomItems().isEmpty()){
                        for (Item item : adventure.getPlayer().getCurrentRoom().getRoomItems()){
                            System.out.println("there is " + bold + item.getName() + unBold + " " + item.getDescription()+"\n");
                        }
                    }

                    if (!adventure.getCurrentRoom().getEnemies().isEmpty()){
                        for (Enemy enemy : adventure.getCurrentRoom().getEnemies()){
                            System.out.println(bold + enemy.getName() + unBold + " is nearby, " + enemy.getDescription() + " HP: " + bold + enemy.getHealthPoints());
                        }
                    }
                }

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
                            type 'go north' or 'go n' to go north
                            type 'go south' or 'go s' to go south
                            type 'go east' or 'go e' to go east
                            type 'go west' or 'go w' to go west
                            
                            type 'take itemname' to pickup item
                            type 'drop itemname' to drop item
                            type 'eat itemname' to eat item if eatable
                            
                            type 'look' to get a description of your sorroundings
                            type 'health' to see how much health you currently have
                            type 'help' to display commands
                            type 'exit' to exit game
                            """);
    }
}
