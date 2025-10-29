package labs.lab1.game;

import java.util.function.Consumer;

import labs.lab1.strategy.MovementStrategy;

public class Hero {
    private MovementStrategy movementStrategy;

    public void setMovementStrategy(MovementStrategy strategy) {
        this.movementStrategy = strategy;
    }

    public void move(Consumer<String> printer) {
        if (movementStrategy != null) {
            movementStrategy.move(printer);
        } else {
            printer.accept("No movement strategy specified");
        }
    }
}
