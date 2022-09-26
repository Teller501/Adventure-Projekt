public class Room {
    private String name;
    private String description;
    private Room northRoom;
    private Room southRoom;
    private Room eastRoom;
    private Room westRoom;

    public Room(String name, String description, Room northRoom,
                Room southRoom, Room eastRoom, Room westRoom){
        this.name = name;
        this.description = description;
        this.northRoom = northRoom;
        this.southRoom = southRoom;
        this.eastRoom = eastRoom;
        this.westRoom = westRoom;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
