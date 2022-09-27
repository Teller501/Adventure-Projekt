public class Room {
    private String name;
    private String description;
    private Room northRoom;
    private Room southRoom;
    private Room eastRoom;
    private Room westRoom;

    public Room(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setNorth(Room room){
        this.northRoom = room;
    }
    public void setSouth(Room room){
        this.southRoom = room;
    }
    public void setEast(Room room){
        this.eastRoom = room;
    }
    public void setWest(Room room){
        this.westRoom = room;
    }

    public Room getNorthRoom() {
        return northRoom;
    }

    public Room getSouthRoom() {
        return southRoom;
    }

    public Room getWestRoom() {
        return westRoom;
    }

    public Room getEastRoom() {
        return eastRoom;
    }
}
