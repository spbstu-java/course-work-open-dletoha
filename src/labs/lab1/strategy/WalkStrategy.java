package labs.lab1.strategy;

import java.util.function.Consumer;

public class WalkStrategy implements MovementStrategy {
    public void move(Consumer<String> printer) {
        printer.accept("The hero goes on foot.");
    }
}