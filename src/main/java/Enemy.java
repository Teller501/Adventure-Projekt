public class Enemy {

    private String name, description;
    private int healthPoints, damage;
    private Weapon weapon;

    public Enemy(String name, String description, int healthPoints, int damage, Weapon weapon){
        this.name = name;
        this.description = description;
        this.healthPoints = healthPoints;
        this.damage = damage;
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
}
