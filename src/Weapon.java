public abstract class Weapon extends Item {
    private int damage;
    public Weapon(String weaponShortName, String weaponLongName, int damage) {
        super(weaponShortName, weaponLongName);
        this.damage = damage;
    }

    public abstract boolean canUse();

    public abstract int remainingUses();

    public abstract void use();

    public int getDamage() {
        return damage;
    }
}