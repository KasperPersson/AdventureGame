import java.util.Scanner;

public class UserInterface {
    AdventureGame game;
    public UserInterface(AdventureGame game){
        this.game = game;
    }
    public void start() {
        Scanner brugerInput = new Scanner(System.in);
        boolean retning = false;

        while (!retning) {
            System.out.print("Type in a command: 'go north', 'go east', 'go south', 'go west', 'look', 'help' or 'quit' to exit the game: ");
            String kommando = brugerInput.nextLine();

            switch (kommando) {
                case "go north", "north", "n", "go n" -> {
                    Room nextRoom = game.getCurrentRoom().getNorth();
                    if (nextRoom != null) {
                        game.setCurrentRoom(nextRoom);
                        System.out.println("Going north. You are in " + game.getCurrentRoom().getName() +game.getCurrentRoom().getDescriptionOfRoom());
                    } else {
                        System.out.println("That way is blocked");
                    }
                }
                case "go east", "east", "e", "go e" -> {
                    Room nextRoom = game.getCurrentRoom().getEast();
                    if (nextRoom != null) {
                        game.setCurrentRoom(nextRoom);
                        System.out.println("Going east. You are in " + game.getCurrentRoom().getName() + game.getCurrentRoom().getDescriptionOfRoom());
                    } else {
                        System.out.println("That way is blocked");
                    }
                }
                case "go south" -> {
                    Room nextRoom = game.getCurrentRoom().getSouth();
                    if (nextRoom != null) {
                        game.setCurrentRoom(nextRoom);
                        System.out.println("Going south. You are in " + game.getCurrentRoom().getName() + game.getCurrentRoom().getDescriptionOfRoom());
                    } else {
                        System.out.println("That way is blocked");
                    }
                }
                case "go west" -> {
                    Room nextRoom = game.getCurrentRoom().getWest();
                    if (nextRoom != null) {
                        game.setCurrentRoom(nextRoom);
                        System.out.println("Going west. You are in " + game.getCurrentRoom().getName() + game.getCurrentRoom().getDescriptionOfRoom());
                    } else {
                        System.out.println("That was is blocked");
                    }
                }
                case "look" -> System.out.println("Looking around" + "\nYou are in " + game.getCurrentRoom().getName() + ", " + game.getCurrentRoom().getDescriptionOfRoom());
                case "help" -> System.out.println("These are the commands you have available:\n'look': Look around and repeat the description of everything you see.\n" +
                        "'go north', 'go south', 'go east', 'go west': Walk in some direction");
                case "quit" -> {
                    System.out.println("Exiting game");
                    retning = true;
                }
                default -> System.out.println("Ugyldig kommando, prøv igen.");
            }
        }
    }
}
