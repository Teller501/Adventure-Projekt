public class Adventure {

    private Map map = new Map();
    private Player player;

    public Adventure(){
        map.createMap();
        player = new Player();
        player.setCurrentRoom(map.getStarterRoom());
    }

    public Room getCurrentRoom(){
        return player.getCurrentRoom();
    }

    public boolean go(String direction){
        return player.move(direction);
    }
}
