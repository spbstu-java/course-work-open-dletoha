package labs.lab1.strategy;

import java.util.function.Consumer;

public class HorseRideStrategy implements MovementStrategy {
    public void move(Consumer<String> printer) {
        printer.accept("The hero is riding a horse.");
    }
}
