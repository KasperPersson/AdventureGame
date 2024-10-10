import java.util.ArrayList;

public class Room {
    private String name;
    private String descriptionOfRoom;
    private Room north, east, south, west;
    private ArrayList<Item> items;
    private ArrayList<Enemy> enemies;

    public Room(String name, String descriptionOfRoom) {
        this.name = name;
        this.descriptionOfRoom = descriptionOfRoom;
        this.items = new ArrayList<>();
        this.enemies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescriptionOfRoom() {
        String description = descriptionOfRoom;
        if (!items.isEmpty()) {
            description += "\nItems in the room: ";
            for (Item item : items) {
                description += "\n" + item.getShortName();
            }
        } else {
            description += "\nThere are no items in this room.";
        }
        if (!enemies.isEmpty()) {
            description += "\nEnimies in the room: ";
            for (Enemy enemy : enemies) {
                description += "\n" + enemy.getName() + enemy.getDescription() + " (Health: " + enemy.getHealth() + ")";
            }
        } else {
            description += "\nThere are no enemies in this room.";
        }
        return description;
    }

    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public Enemy getEnemyByName(String enemyName) {
        for (Enemy enemy : enemies) {
            if (enemy.getName().equalsIgnoreCase(enemyName)) {
                return enemy;
            }
        }
        return null;
    }

    public Enemy getNearestEnemy() {
        if (enemies.isEmpty()) {
            return null;
        }
        return enemies.get(0);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public Item findItem(String itemName) {
        for (Item item : items) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public Room getNorth() {
        return north;
    }

    public Room getEast() {
        return east;
    }

    public Room getSouth() {
        return south;
    }

    public Room getWest() {
        return west;
    }
}