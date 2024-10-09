public abstract class Weapon extends Item {

    public Weapon(String weaponShortName, String weaponLongName) {
        super(weaponShortName, weaponLongName);
    }

    // Metode til at bruge våbenet (skal overrides i subklasser)
    public abstract boolean canUse();

    // Antal tilbageværende brug, bruges kun af RangedWeapon
    public abstract int remainingUses();

    // Metode til at bruge våbenet (overrides af subklasser)
    public abstract void use();
}