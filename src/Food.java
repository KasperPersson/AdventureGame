public class Food extends Item {
    private int healthPoints;

    public Food(String foodShortName, String foodLongName, int healthPoints) {
        super(foodShortName, foodLongName);
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }
}