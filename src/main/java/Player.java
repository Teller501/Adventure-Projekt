import java.util.ArrayList;

public class Player {

    private Room currentRoom;
    private ArrayList<Item> playerInventory = new ArrayList<>();
    private Weapon equippedWeapon;
    private double health;


    public Player(double health) {
        this.health = health;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public boolean move(String direction) {
        Room requestedRoom = null;

        if (direction.charAt(0) == 'n') {
            requestedRoom = currentRoom.getNorthRoom();
        } else if (direction.charAt(0) == 's') {
            requestedRoom = currentRoom.getSouthRoom();
        } else if (direction.charAt(0) == 'e') {
            requestedRoom = currentRoom.getEastRoom();
        } else if (direction.charAt(0) == 'w') {
            requestedRoom = currentRoom.getWestRoom();
        }

        if (requestedRoom != null) {
            currentRoom = requestedRoom;
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Item> getPlayerInventory() {
        return playerInventory;
    }

    public void addItem(Item item) {
        playerInventory.add(item);
    }


    // method for removing item from player inventory, looping through the playerInventory
    public Item removeItem(String name) {
        for (Item item : playerInventory) {
            if (item.getName().equals(name)) {
                playerInventory.remove(item);
                return item;
            }
        }
        return null;
    }

    // Method for eating food
    public ReturnMessage eatFood(String itemName) {
        Item item = findItem(itemName);
            if (item instanceof Food) {
                    health += ((Food) item).getHealthPoints();
                    removeItem(itemName);
                    return ReturnMessage.OK; // eatable
                } else {
                if (item!=null){
                    return ReturnMessage.CANT; // not eatable
                }
                return ReturnMessage.NOT_FOUND; // not found
            }
    }

    // Method for finding an item and returning that item
    public Item findItem(String name) {
        for (Item item : playerInventory) {
                if (item.getName().equals(name)) {
                    return item;
                }
        } return null;
    }

    public ReturnMessage equipWeapon(String itemName) {
        Item item = findItem(itemName);
        if (item instanceof Weapon) { // if the item is of type weapon
            equippedWeapon = (Weapon) item; // Setting the equippedWeapon attribute to item casted to Weapon
            return ReturnMessage.OK; // eatable
        } else {
            if (item!=null){
                return ReturnMessage.CANT; // not eatable
            }
            return ReturnMessage.NOT_FOUND; // not found
        }
    }

    //Getter for equippedWeapon
    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public AttackStatus attackCommand(String enemyName){

        Enemy selectedEnemy = null;
        Enemy nearestEnemy = currentRoom.getEnemies().get(0);

        if (getEquippedWeapon() == null){
            return AttackStatus.NO_WEAPON;
        }else{
            if (getEquippedWeapon().canUse()){
                if (!currentRoom.getEnemies().isEmpty()){
                    for (Enemy enemy : currentRoom.getEnemies()){
                        if (enemyName.equals(enemy.getName())){
                            selectedEnemy = enemy;
                            attack(selectedEnemy);
                            return AttackStatus.ATTACKED;
                        }
                    }
                    if (selectedEnemy == null){
                        attack(nearestEnemy);
                        return AttackStatus.NO_SUCH_ENEMY;
                    }
                }else {
                    return AttackStatus.NO_ENEMY;
                }
            }else {
                return AttackStatus.NO_USEABLE_WEAPON;
            }
        }

        return null;
    }

    public void attack(Enemy enemy){
        equippedWeapon.attack(enemy, equippedWeapon);
        enemy.attack(this);
        enemy.isDead();
    }



    public boolean isDead(){
        if (health <= 0){
            return true;
        }else{
            return false;
        }
    }

}









