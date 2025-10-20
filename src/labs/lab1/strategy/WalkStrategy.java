package labs.lab1.strategy;

public class WalkStrategy implements MovementStrategy {
    public void move() {
        System.out.println("The hero goes on foot.");
    }
}