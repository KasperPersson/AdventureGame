public class AdventureGame {
    private Player player;
    private Map map;
    private UserInterface ui;

    public AdventureGame() {
        map = new Map();
        Room startRoom = map.createRooms();
        player = new Player(startRoom);
        ui = new UserInterface(this);
    }

    public void startGame(){
        ui.start();
    }

    public Room getCurrentRoom(){
        return player.getCurrentRoom();
    }

    public void movePlayer(String direction) {
        boolean moved = player.move(direction);
        if (!moved) {
            ui.print("That way is blocked");
        } else {
            ui.print("You are now in: " + player.getCurrentRoom().getName() + player.getCurrentRoom().getDescriptionOfRoom());
        }
    }

    public void playerTakeItem(String itemName){
        player.takeItem(itemName);
    }

    public void playerDropItem(String itemName){
        player.dropItem(itemName);
    }

    public Item findItemInPlayerInventory(String itemName){
        return player.findItem(itemName);
    }

    public void showPlayerInventory(){
        player.showInventory();
        player.getItems(); //test med array print
    }
}
