public class MeleeWeapon extends Weapon {

    public MeleeWeapon(String weaponShortName, String weaponLongName, int damage) {
        super(weaponShortName, weaponLongName, damage);
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public int remainingUses() {
        return -1;
    }

    @Override
    public void use() {
    }
}