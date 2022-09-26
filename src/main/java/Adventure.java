public class Adventure {

    private Room currentRoom;
    public void createRooms(){
        Room room1 = new Room("Road",
                "You are on the road outside your apartment complex," +
                        " you are the only one around, everything is deserted");
        Room room2 = new Room("Road",
                "You are on the road outside your apartment complex," +
                        " you are the only one around, everything is deserted");
        Room room3 = new Room("Road",
                "You are on the road outside your apartment complex," +
                        " you are the only one around, everything is deserted");
        Room room4 = new Room("Road",
                "You are on the road outside your apartment complex," +
                        " you are the only one around, everything is deserted");
        Room room5 = new Room("Road",
                "You are on the road outside your apartment complex," +
                        " you are the only one around, everything is deserted");
        Room room6 = new Room("Road",
                "You are on the road outside your apartment complex," +
                        " you are the only one around, everything is deserted");
        Room room7 = new Room("Road",
                "You are on the road outside your apartment complex," +
                        " you are the only one around, everything is deserted");
        Room room8 = new Room("Road",
                "You are on the road outside your apartment complex," +
                        " you are the only one around, everything is deserted");
        Room room9 = new Room("Road",
                "You are on the road outside your apartment complex," +
                        " you are the only one around, everything is deserted");

        room1.setEast(room2);
        room1.setSouth(room2);

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

        currentRoom = room1;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

}
