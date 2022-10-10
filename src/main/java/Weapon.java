public abstract class Weapon extends Item{

    private int damage;

    public Weapon(String name, String description, int damage) {
        super(name, description);
        this.damage = damage;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public int getDamage() {
        return damage;
    }

    public abstract int getRemainingAmmo();



}
