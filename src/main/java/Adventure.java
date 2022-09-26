public class Adventure {

    private Room currentRoom;
    public void createRooms(){
        Room room1 = new Room("Road",
                "You are on the road outside your apartment complex," +
                        " you are the only one around, everything is deserted",
                null, null, null, null);


        currentRoom = room1;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
