public class Enemy {

    private String name, description;
    private int healthPoints;
    private Weapon weapon;

    public Enemy(String name, String description, int healthPoints, Weapon weapon){
        this.name = name;
        this.description = description;
        this.healthPoints = healthPoints;
        this.weapon = weapon;
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


    public void setHealthPoints(int newHealth) {
        this.healthPoints = newHealth;
    }
}
