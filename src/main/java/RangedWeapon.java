public class RangedWeapon extends Weapon{

    private int ammo;

    public RangedWeapon(String name, String description, int damage, int ammo) {
        super(name, description, damage);
        this.ammo = ammo;
    }

    @Override
    public int getRemainingAmmo() {
        return ammo;
    }
}
