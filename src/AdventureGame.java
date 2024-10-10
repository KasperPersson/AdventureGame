public class AdventureGame {
    private Player player;
    private Map map;

    public AdventureGame() {
        map = new Map();
        Room startRoom = map.createRooms();
        player = new Player(startRoom);

    }

    public String getHelp() {
        return "These are the commands you have available:\n" + "'look': Look around and repeat the description of everything you see.\n" + "'go north', 'go south', 'go east', 'go west': Walk in some direction.";
    }

    public String look() {
        return player.getCurrentRoom().getDescriptionOfRoom();
    }

    public String movePlayer(String direction) {
        boolean success = player.move(direction);

        if (success) {
            return "You moved to " + player.getCurrentRoom().getName() + ". " + player.getCurrentRoom().getDescriptionOfRoom();
        } else {
            return "You can't go that way.";
        }
    }

    public String playerTakeItem(String itemName) {
        return player.takeItem(itemName);
    }

    public String playerDropItem(String itemName) {
        return player.dropItem(itemName);
    }

    public String showInventory() {
        return player.showInventory();
    }

    public String getHealthStatus() {
        return player.getHealth();
    }

    public String eatItem(String itemName) {
        Eat status = player.eat(itemName);

        switch (status) {
            case IS_FOOD -> {
                return "You eat the " + itemName + " and feel its effects on your health.";
            }
            case IS_NOT_FOOD -> {
                return "You cannot eat the " + itemName + ". It is not food.";
            }
            case IS_NOT_FOUND -> {
                return "The " + itemName + " is not here or in your inventory.";
            }
            default -> {
                return "An unknown error occurred.";
            }
        }
    }

    public String attack(String enemyName) {
        return player.attack(enemyName);
    }

    public String attack() {
        return player.attack(null); // Angrib den nærmeste fjende
    }

    public String equipWeapon(String weaponName) {
        Equip status = player.equip(weaponName);

        switch (status) {
            case IS_WEAPON -> {
                return "You have equipped " + weaponName;
            }
            case IS_NOT_WEAPON -> {
                return weaponName + " is not a weapon";
            }
            case IS_NOT_FOUND -> {
                return weaponName + " is not found in your inventory";
            }
        }
        return "Error, please check your inventory for item";
    }
}