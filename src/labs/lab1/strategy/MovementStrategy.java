package labs.lab1.strategy;

import java.util.function.Consumer;

public interface MovementStrategy {
    void move(Consumer<String> printer);
}
