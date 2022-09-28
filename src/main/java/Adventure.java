public class Adventure {

    private Room currentRoom;
    private Map map;

    public Adventure(){
        map.createMap();
    }

    // Getting current room
    public Room getCurrentRoom() {
        return map.getStarterRoom();
    }

    public boolean goNorth() {
        if (currentRoom.getNorthRoom() != null){
            currentRoom = currentRoom.getNorthRoom();
            return true;
        } else{
            return false;
        }

    }

    public boolean goSouth() {
        if (currentRoom.getSouthRoom()!=null) {
            currentRoom = currentRoom.getSouthRoom();
            return true;
        } else {
            System.out.println("you can't go that way");
            return false;
        }

    }

    public boolean goEast() {
        if (currentRoom.getEastRoom()!=null) {
            currentRoom = currentRoom.getEastRoom();
            return true;
        } else {
            return false;
        }
    }

    public boolean goWest() {
        if (currentRoom.getWestRoom()!=null) {
            currentRoom = currentRoom.getWestRoom();
            return true;
        } else {
            return false;
        }
    }
}
