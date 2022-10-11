public class Enemy {

    private String name, description;
    private int healthPoints;
    private Weapon weapon;
    private Room room;

    public Enemy(String name, String description, int healthPoints, Weapon weapon, Room room){
        this.name = name;
        this.description = description;
        this.healthPoints = healthPoints;
        this.weapon = weapon;
        this.room = room;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public Weapon getWeapon() {
        return weapon;
    }


    public void hit(int newHealth) {
        this.healthPoints = newHealth;
    }

    public boolean isDead(){
        if (healthPoints<=0){
            room.addItem(weapon);
            room.removeEnemy(this);
            return true;
        }else{
            return false;
        }
    }


}
