import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private Room northRoom;
    private Room southRoom;
    private Room eastRoom;
    private Room westRoom;

    private ArrayList <Item> roomItems = new ArrayList<>();

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

    public void createItem(String name, String description){
        Item item = new Item(name, description);
        addItem(item);
    }

    public void createFood(String name, String description, double healthPoints){
        Food food = new Food(name,description,healthPoints);
        addItem(food);
    }

    public void addItem(Item item){
        roomItems.add(item);
    }

    public ArrayList<Item> getRoomItems(){
        return roomItems;
    }

    // method for removing item from room inventory, looping through the roomItems
    public Item removeItem(String name){
        for (Item item : roomItems){
            if (item.getName().equals(name)){
                roomItems.remove(item);
                return item;
            }
        }
        return null;
    }

}
