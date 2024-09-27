public class AdventureGame {
    private Player player;
    public Map map;
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
}
