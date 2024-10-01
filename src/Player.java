import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> playerInventory;

    public Player(Room startRoom) {
        this.currentRoom = startRoom;
        this.playerInventory = new ArrayList<>();
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

    public String showInventory() {
        if (playerInventory.isEmpty()) {
            return "You have nothing in your inventory.";
        } else {
            StringBuilder inventory = new StringBuilder("Player inventory:\n");
            for (Item item : playerInventory) {
                inventory.append(item.getShortName()).append("\n");
            }
            return inventory.toString();
        } // Skal have nedenstående metode til at virke istedet
    }

//    public String showInventory(){
//        if (playerInventory.isEmpty()){
//            return "You have nothing in your inventory.";
//        } else {
//            for (Item item : playerInventory) {
//                System.out.println(item.getShortName());
//            }
//            return playerInventory // toString skal laves her
//        }
//    }

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