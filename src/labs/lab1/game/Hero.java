package labs.lab1.game;

import labs.lab1.strategy.MovementStrategy;

public class Hero {
    private MovementStrategy movementStrategy;

    public void setMovementStrategy(MovementStrategy strategy) {
        this.movementStrategy = strategy;
    }

    public void move() {
        if (movementStrategy != null) {
            movementStrategy.move();
        } else {
            System.out.println("No movement strategy specified");
        }
    }
}
