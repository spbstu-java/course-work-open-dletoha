package labs.lab1.game;

import java.util.function.Consumer;

import labs.lab1.strategy.MovementStrategy;
import labs.lab1.strategy.MovementStrategyFactory;

public class Game {
    // public static void main(String[] args) {
    // Hero hero = new Hero();
    // Scanner scanner = new Scanner(System.in);

    // while (true) {
    // System.out.println("Select transport:");
    // for (var opt : labs.lab1.strategy.MovementOption.values()) {
    // System.out.printf("%s — %s%n", opt.getCode(), opt.getDescription());
    // }
    // System.out.println("0 — Exit");
    // System.out.print("Input number: ");

    // String choice = scanner.nextLine().trim();
    // if ("0".equals(choice)) {
    // System.out.println("Game over.");
    // break;
    // }

    // MovementStrategy strat = MovementStrategyFactory.create(choice);
    // if (strat == null) {
    // System.out.println("Invalid input. Try again.");
    // continue;
    // }

    // hero.setMovementStrategy(strat);
    // hero.move();
    // }

    // scanner.close();
    // }

    public static void run(String choice, Consumer<String> printer) {
        MovementStrategy strat = MovementStrategyFactory.create(choice);
        if (strat == null) {
            printer.accept("Invalid input.");
            return;
        }
        Hero hero = new Hero();
        hero.setMovementStrategy(strat);
        hero.move(printer);
    }

}
