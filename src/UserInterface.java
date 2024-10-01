import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private AdventureGame game;

    public UserInterface(AdventureGame game){
        this.game = game;
    }

    public void start() {
        Scanner brugerInput = new Scanner(System.in);
        System.out.println("As you open your eyes, you find yourself in complete darkness. " +
                "The air is cold and damp, and the sound of distant dripping water echoes around you. " +
                "\nYour head throbs with a dull ache, and your clothes are covered in dust and grime. " +
                "You have no memory of how you got here, but the rough stone beneath " +
                "your hands and the \nfaint earthy scent tell you that you're deep underground—trapped " +
                "within a cavernous labyrinth.\n" +
                "\n" +
                "You take a deep breath and steady yourself. This is no ordinary cave; there's something ancient, " +
                "something powerful lurking in the shadows. You can feel it. \nAs your eyes adjust to the darkness, a " +
                "faint glow appears in the distance, just enough to outline the shape of the cavern walls around you. " +
                "The cave stretches out into \nmultiple passages, each one shrouded in an air of mystery and danger.\n" +
                "\n" +
                "Driven by a strange mix of curiosity and fear, you decide to venture forth. What secrets does this place hold? " +
                "What has been waiting for you in these forsaken depths? \nThe smell of something rotten lingers in the air, " +
                "and as you move forward, you spot the broken remains of something large—something that sends a shiver down " +
                "your spine.\n" +
                "\n" +
                "You know you must find a way out, but more than that, you must discover the truth about this place. " +
                "Who or what brought you here? And why does it feel like you are not alone?\n" +
                "\n" +
                "With a deep breath, you take your first step into the unknown. The adventure begins now.");
        System.out.println(game.getCurrentRoom().getDescriptionOfRoom());


        while (true) {
            System.out.print("Enter a direction (north, east, south, west), help or 'look' to examine the room, or 'quit' to exit: ");
            String kommando = brugerInput.nextLine();

            if (kommando.equals("quit")) {
                System.out.println("Thanks for playing! Goodbye.");
                break;

            }
            else if (kommando.equals("help")) {
                System.out.println("These are the commands you have available:\n'look': Look around and repeat the description of everything you see.\n" +
                        "'go north', 'go south', 'go east', 'go west': Walk in some direction");
            }
            else if (kommando.equals("look")) {
                print("You are now in: " + game.getCurrentRoom().getName() + game.getCurrentRoom().getDescriptionOfRoom());
            }
            else if (kommando.startsWith("take ")) {
                String[] word = kommando.split(" ");
                if (word.length > 1) {
                    String itemName = word[1];
                    Item itemTotake = game.getCurrentRoom().findItem(itemName);
                    game.playerTakeItem(itemName);

                    if (itemTotake != null) {
                        // game.getCurrentRoom().removeItem(itemTotake);
                        System.out.println("You have taken the " + itemTotake.getShortName());
                    } else{
                        System.out.println("There is no such item as " + itemName);
                        System.out.println("Please specify the item you want to take");
                    }
                }
            }
            else if (kommando.startsWith("drop ")){
                String[] word = kommando.split(" ");
                if (word.length > 1){
                    String itemName = word[1];
                    Item itemToDrop = game.findItemInPlayerInventory(itemName);
                    game.playerDropItem(itemName);
                    if (itemToDrop != null){
                        System.out.println("You have dropped " + itemToDrop.getShortName());
                    } else {
                        System.out.println("There is no such item as " + itemName);
                        System.out.println("Please specify the item you want to drop");
                    }
                }
            }
            else if (kommando.equalsIgnoreCase("inventory")){
                game.showPlayerInventory();
            }

            else {
                game.movePlayer(kommando);
            }
        }
    }
    public void print(String message) {
        System.out.println(message);
    }
}
