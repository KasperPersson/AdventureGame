public class MeleeWeapon extends Weapon {

    public MeleeWeapon(String weaponShortName, String weaponLongName) {
        super(weaponShortName, weaponLongName);
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