package labs.lab1.strategy;

public class FlyStrategy implements MovementStrategy {
    public void move() {
        System.out.println("The hero flies");
    }
}