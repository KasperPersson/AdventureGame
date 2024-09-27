public class Player {
    private Room currentRoom;

    public Player(Room startRoom) {
        this.currentRoom = startRoom;
    }

    public Room getCurrentRoom(){
        return currentRoom;
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