import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> playerInventory;
    private int health;
    private Weapon equippedWeapon = null;

    public Player(Room startRoom) {
        currentRoom = startRoom;
        playerInventory = new ArrayList<>();
        health = 100;
    }

    public String takeItem(String itemName){
        Item item = currentRoom.findItem(itemName);
        if (item != null) {
            playerInventory.add(item);
            currentRoom.removeItem(item);
            return "You took : " + item.getLongName();
        } else {
            return "There is nothing like " + itemName + " in this room";
        }
    }

    public String dropItem(String itemName){
        Item item = findItem(itemName);
        if (item != null) {
            playerInventory.remove(item);
            currentRoom.addItem(item);
            return "You dropped : " + item.getLongName();
        } else {
            return "There is nothing like " + itemName + " in your inventory";
        }
    }
    public Equip equip(String itemName) {
        Item item = findItem(itemName); // Finder varen i spillerens inventar

        if (item == null) {
            return Equip.IS_NOT_FOUND;
        } else if (item instanceof Weapon) {
            equippedWeapon = (Weapon) item;
            return Equip.IS_WEAPON;
        } else {
            return Equip.IS_NOT_WEAPON;
        }
    }

    // Attack metoden bruger nu polymorfi
    public String attack() {
        if (equippedWeapon == null) {
            return "You don't have a weapon equipped.";
        }
        if (equippedWeapon.canUse()) {
            equippedWeapon.use();
            return "You use your " + equippedWeapon.getShortName() + ". Remaining uses: " + equippedWeapon.remainingUses();
        } else {
            return "Your " + equippedWeapon.getShortName() + " can't be used anymore.";
        }
    }

    public Weapon getEquippedWeapon(){
        return equippedWeapon;
    }

    public Eat eat (String itemName) {
        Item item = findItem(itemName);
        if (item == null){
            item = currentRoom.findItem(itemName);
            if (item == null) {
                return Eat.IS_NOT_FOUND;
            }
        }
        if (item instanceof Food) {
            Food food = (Food) item;
            changeHealth(food.getHealthPoints());
            if(playerInventory.contains(item)) {
                playerInventory.remove(item);
            } else {
                currentRoom.removeItem(item);
            }
            return Eat.IS_FOOD;
        } else {
            return Eat.IS_NOT_FOOD;
        }
    }

    public String getHealth(){
        String healthStatus;
        if (health >= 80){
            healthStatus = "Your health is high";
        } else if (health >= 50) {
            healthStatus = "You are in good health, but avoid fighting right now";
        } else if (health >= 20) {
            healthStatus = "You are in bad health, be careful";
        } else {
            healthStatus = "You are in very bad health, find something to eat!";
        }
        return "Health: " + health + " - " + healthStatus;
    }

    public void changeHealth(int healthGainOrLoose){
        health += healthGainOrLoose;
        if (health > 100) {
            health = 100;
        } else if (health < 0) {
            health = 0;
        }
    }

    public String showInventory() {
        StringBuilder inventory = new StringBuilder("Inventory:");

        if (playerInventory.isEmpty()) {
            inventory.append(" Your inventory is empty.");
        } else {
            for (Item item : playerInventory) {
                inventory.append("\n").append(item.getShortName());
            }
        }
        if (equippedWeapon != null) {
            inventory.append("\nEquipped weapon: ").append(equippedWeapon.getShortName());
        } else {
            inventory.append("\nNo weapon equipped.");
        }
        return inventory.toString();
    }
    public Room getCurrentRoom(){
        return currentRoom;
    }

    public Item findItem (String itemName){
        for (Item item : playerInventory) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public boolean move(String direction) {
        Room nextRoom = null;

        switch (direction) {
            case "north", "go north", "n", "go n" -> nextRoom = currentRoom.getNorth();
            case "east", "go east", "e", "go e" -> nextRoom = currentRoom.getEast();
            case "south", "go south", "s", "go s" -> nextRoom = currentRoom.getSouth();
            case "west", "go west", "w", "go w" -> nextRoom = currentRoom.getWest();
        }
        if (nextRoom != null) {
            currentRoom = nextRoom;
            return true;
        } else {
            return false;
        }
    }
}