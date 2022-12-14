public class Adventure {

    private Map map = new Map();
    private Player player;

    // Adventure constructer, creating the map, player, and setting players currentRoom to starterRoom
    public Adventure(){
        map.createMap();
        player = new Player(100);
        player.setCurrentRoom(map.getStarterRoom());
    }

    public Player getPlayer() {
        return player;
    }

    // Getting players current Room
    public Room getCurrentRoom(){
        return player.getCurrentRoom();
    }

    // Calling move method from Player class
    public boolean go(String direction){
        return player.move(direction);
    }

    // Calling eat method from Player class
    public ReturnMessage playerEat(String itemName){
        return player.eatFood(itemName);
    }

    // Calling equip method from Player class
    public ReturnMessage equip(String itemName){
        return player.equipWeapon(itemName);
    }

    // Calling attack method from Player class
    public AttackStatus attack(String userChoice) {
        return player.attackCommand(userChoice);
    }
}
