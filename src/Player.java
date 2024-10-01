import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> playerInventory;

    public Player(Room startRoom) {
        this.currentRoom = startRoom;
        this.playerInventory = new ArrayList<>();
    }

    public void takeItem(String itemName){
        Item item = currentRoom.findItem(itemName);
        if (item != null) {
            playerInventory.add(item);
            currentRoom.removeItem(item);
            System.out.println("You took : " + item.getLongName());
        } else {
            System.out.println("There is nothing like " + itemName + " in this room");
        }
    }

    public void dropItem(String itemName){
        Item item = findItem(itemName);
        if (item != null) {
            playerInventory.remove(item);
            currentRoom.addItem(item);
            System.out.println("You dropped : " + item.getLongName());
        } else {
            System.out.println("There is nothing like " + itemName + " in your inventory");
        }
    }

    public void showInventory(){
        System.out.println("Player inventory: ");
        if (playerInventory.isEmpty()){
            System.out.println("You have nothing in your inventory.");
        } else {
            for (Item item : playerInventory) {
                System.out.println(item.getShortName());
            }
        }
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }

//    public void addItem (Item item){
//        playerInventory.add(item);
//    }
//
//    public void removeItem(Item item){
//        playerInventory.remove(item);
//    }

    public Item findItem (String itemName){
        for (Item item : playerInventory) {
            if (item.getShortName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    ArrayList<Item> getItems(){
        return playerInventory;
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