public class Food extends Item{
    private double healthPoints;

    public Food(String name, String description, double healthPoints) {
        super(name, description);
        this.healthPoints = healthPoints;
    }
}
