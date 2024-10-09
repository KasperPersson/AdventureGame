public abstract class Weapon extends Item {

    public Weapon(String weaponShortName, String weaponLongName) {
        super(weaponShortName, weaponLongName);
    }

    public abstract boolean canUse();

    public abstract int remainingUses();

    public abstract void use();
}