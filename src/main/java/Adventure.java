public class Adventure {

    private Room currentRoom;
    public void createRooms(){
        // Creating room objects
        Room room1 = new Room("Road",
                "You are on the road outside your apartment complex," +
                        " you are the only one around, everything is deserted");
        Room room2 = new Room("Room 2",
                "You are on the road outside your apartment complex," +
                        " you are the only one around, everything is deserted");
        Room room3 = new Room("Room 3",
                "You are on the road outside your apartment complex," +
                        " you are the only one around, everything is deserted");
        Room room4 = new Room("Room 4",
                "You are on the road outside your apartment complex," +
                        " you are the only one around, everything is deserted");
        Room room5 = new Room("Room 5",
                "You are on the road outside your apartment complex," +
                        " you are the only one around, everything is deserted");
        Room room6 = new Room("Room 6",
                "You are on the road outside your apartment complex," +
                        " you are the only one around, everything is deserted");
        Room room7 = new Room("Room 7",
                "You are on the road outside your apartment complex," +
                        " you are the only one around, everything is deserted");
        Room room8 = new Room("Room 8",
                "You are on the road outside your apartment complex," +
                        " you are the only one around, everything is deserted");
        Room room9 = new Room("Room 9",
                "You are on the road outside your apartment complex," +
                        " you are the only one around, everything is deserted");

        // Setting directions for each room
        room1.setEast(room2);
        room1.setSouth(room4);

        room2.setWest(room1);
        room2.setEast(room3);

        room3.setWest(room2);
        room3.setSouth(room6);

        room4.setNorth(room1);
        room4.setSouth(room7);

        room5.setSouth(room8);


        room6.setNorth(room3);
        room6.setSouth(room9);

        room7.setNorth(room4);
        room7.setEast(room8);

        room8.setWest(room7);
        room8.setNorth(room5);
        room8.setEast(room9);

        room9.setWest(room8);
        room9.setNorth(room6);

        // Setting currentRoom to room1 at the start
        currentRoom = room1;

    }

    // Getting current room
    public Room getCurrentRoom() {
        return currentRoom;
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
