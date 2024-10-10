public class Enemy {
    private String name;
    private String description;
    private int health;
    private Weapon weapon;

    public Enemy(String name, String description, int health, Weapon weapon) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String hit(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
            return name + "" + weapon.getShortName() + ".";
        }
        return name + "" + health + "";
    }

    public String attack(Player player) {
        int damage = weapon.getDamage();
        player.takeDamage(damage);
        return name + " attacks you with " + weapon.getShortName() + " for " + damage + " damage.";
    }

    public Weapon dropWeapon() {
        return weapon;
    }

    @Override
    public String toString() {
        return name + " (Health: " + health + ")";
    }
}
