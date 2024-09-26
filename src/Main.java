public class Main {

    public static void main(String[] args) {
    AdventureGame game = new AdventureGame();
    UserInterface ui = new UserInterface(game);
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
    ui.start();
    }
}
