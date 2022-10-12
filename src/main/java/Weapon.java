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


    public abstract void setAmmo(int ammo);

    public boolean canUse(){
        return true;
    }


    public void attack(Enemy enemy, Weapon weapon) {
        int damageDealt = enemy.dealDamage(weapon);
        enemy.hit(damageDealt);
        setAmmo(getRemainingAmmo()-1);
    }
}
