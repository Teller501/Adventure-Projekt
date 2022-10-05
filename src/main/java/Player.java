import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private ArrayList<Item> playerInventory = new ArrayList<>();
    private double health;
    private final double maxHealth = 50;

    public Player(double health) {
        this.health = health;
    }

    public double getHealth() {
        return health;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public boolean move(String direction) {
        Room requestedRoom = null;

        if (direction.charAt(0) == 'n') {
            requestedRoom = currentRoom.getNorthRoom();
        } else if (direction.charAt(0) == 's') {
            requestedRoom = currentRoom.getSouthRoom();
        } else if (direction.charAt(0) == 'e') {
            requestedRoom = currentRoom.getEastRoom();
        } else if (direction.charAt(0) == 'w') {
            requestedRoom = currentRoom.getWestRoom();
        }

        if (requestedRoom != null) {
            currentRoom = requestedRoom;
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Item> getPlayerInventory() {
        return playerInventory;
    }

    public void addItem(Item item) {
        playerInventory.add(item);
    }


    // method for removing item from player inventory, looping through the playerInventory
    public Item removeItem(String name) {
        for (Item item : playerInventory) {
            if (item.getName().equals(name)) {
                playerInventory.remove(item);
                return item;
            }
        }
        return null;
    }

    // Method for eating food
    public boolean eatingFood(String itemName) {
        for (Item item : playerInventory) {
            if (item instanceof Food) {
                if (item.getName().equals(itemName)) {
                    health += ((Food) item).getHealthPoints();
                    return true;
                }

            }

        } return false;
    }

    // Method for finding an item and returning that item
}



