import java.util.Scanner;

public class UserInterface {
    private AdventureGame game;

    public UserInterface(AdventureGame game){
        this.game = game;
    }

    public String getInput() {
        Scanner brugerInput = new Scanner(System.in);
        System.out.print("Enter a command: ");
        return brugerInput.nextLine();
    }
    public void print(String message) {
        System.out.println(message);
    }
}
