import java.util.Scanner;

public class UserInterface {
    private AdventureGame game;

    public UserInterface() {
        game = new AdventureGame();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        String brugerInput;

        System.out.println("As you open your eyes, you find yourself in complete darkness." +
                "\nThe air is cold and damp, and the sound of distant dripping water echoes around you.");
        System.out.println("Enter a command: ");

        boolean running = true;
        while (running) {
            brugerInput = scanner.nextLine().toLowerCase();
            String[] word = brugerInput.split(" ");
            String action = word[0];

            switch (action) {
                case "quit" -> {
                    System.out.println("Thanks for playing! Goodbye.");
                    return; // Afslutter spillet
                }
                case "help" -> System.out.println(game.getHelp());
                case "look" -> System.out.println(game.look());
                case "go" -> {
                    if (word.length > 1) {
                        System.out.println(game.movePlayer(word[1]));
                    } else {
                        System.out.println("Please specify a direction (north, east, south, west).");
                    }
                }
                case "take" -> {
                    if (word.length > 1) {
                        System.out.println(game.playerTakeItem(word[1]));
                    } else {
                        System.out.println("Please specify an item to take.");
                    }
                }
                case "drop" -> {
                    if (word.length > 1) {
                        System.out.println(game.playerDropItem(word[1]));
                    } else {
                        System.out.println("Please specify an item to drop.");
                    }
                }
                case "inventory", "inv" -> System.out.println(game.showInventory());
                case "health" -> System.out.println(game.getHealthStatus()); // Ny kommando for health
                case "eat" -> {
                    if (word.length > 1) {
                        System.out.println(game.eatItem(word[1]));
                    } else {
                        System.out.println("Please specify an item to eat.");
                    }
                }
                case "equip" -> {
                    if (word.length > 1) {
                        System.out.println(game.equipWeapon(word[1]));
                    } else {
                        System.out.println("Please specify a weapon to equip");
                    }
                }
                case "attack" -> System.out.println(game.attack());
                default -> System.out.println("Unknown command: " + action);
            }
        }
    }
}
