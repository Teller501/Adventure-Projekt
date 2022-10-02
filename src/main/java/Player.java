import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private ArrayList<Item> playerInventory = new ArrayList<>();

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public boolean move(String direction){
        Room requestedRoom = null;

        if (direction.charAt(0) == 'n'){
            requestedRoom = currentRoom.getNorthRoom();
        }else if(direction.charAt(0) == 's'){
            requestedRoom = currentRoom.getSouthRoom();
        }else if(direction.charAt(0) == 'e'){
            requestedRoom = currentRoom.getEastRoom();
        }else if(direction.charAt(0) == 'w'){
            requestedRoom = currentRoom.getWestRoom();
        }

        if (requestedRoom != null){
            currentRoom = requestedRoom;
            return true;
        }else{
            return false;
        }
    }

    public ArrayList<Item> getPlayerInventory() {
        return playerInventory;
    }
    public void addItem(Item item){
        playerInventory.add(item);
    }



}
