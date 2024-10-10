public class RangedWeapon extends Weapon {
    private int ammo;

    public RangedWeapon (String weaponShortName, String weaponLongName, int damage, int ammo) {
        super(weaponShortName, weaponLongName, damage);
        this.ammo = ammo;
    }

    @Override
    public boolean canUse() {
        return ammo > 0;
    }

    @Override
    public int remainingUses() {
        return ammo;
    }

    @Override
    public void use() {
        if (canUse()) {
            ammo--;
        }
    }
}