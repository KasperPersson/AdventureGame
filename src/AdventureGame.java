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

    public void startGame() {
        ui.print("As you open your eyes, you find yourself in complete darkness. " +
                "The air is cold and damp, and the sound of distant dripping water echoes around you.");
        ui.print(player.getCurrentRoom().getDescriptionOfRoom());

        boolean running = true;
        while (running) {
            String brugerInput = ui.getInput();
            String[] word = brugerInput.split(" ");
            String action = word[0];

            switch (action) {
                case "quit" -> {
                    ui.print("Thanks for playing! Goodbye.");
                    return;
                }
                case "help" ->
                        ui.print("These are the commands you have available:\n" +
                                "'look': Look around and repeat the description of everything you see.\n" +
                                "'go north', 'go south', 'go east', 'go west': Walk in some direction.");
                case "look" ->
                        ui.print(player.getCurrentRoom().getDescriptionOfRoom());
                case "go" -> {
                    ui.print("You are moving: ");
                    if (word.length > 1) {
                        ui.print(movePlayer(word[1]));
                    } else {
                        ui.print("Please specify a direction (north, east, south, west).");
                    }
                }
                case "take" -> {
                    if (word.length > 1){
                        ui.print(player.takeItem(word[1]));
                    } else {
                        ui.print("Please specify the item you want to take");
                    }
                }
                case "drop" -> {
                    if(word.length > 1){
                        ui.print(player.dropItem(word[1]));
                    } else {
                        ui.print("Please specifiy the item you want to drop");
                    }
                }
                case "inventory", "inv" -> ui.print(player.showInventory());
            }
        }
    }

    public Room getCurrentRoom() {
        return player.getCurrentRoom();
    }

    public String movePlayer(String direction) {
        boolean moved = player.move(direction);
        if (moved) {
            return "You are now in: " + player.getCurrentRoom().getName() + "\n" + player.getCurrentRoom().getDescriptionOfRoom();
        } else {
            return "That way is blocked.";
        }
    }
}
