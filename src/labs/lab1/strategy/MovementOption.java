package labs.lab1.strategy;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Supplier;

public enum MovementOption {
    WALK("1", "On foot", WalkStrategy::new),
    HORSE("2", "On hourse", HorseRideStrategy::new),
    FLY("3", "On griffin", FlyStrategy::new);

    private final String code;
    private final String description;
    private final Supplier<MovementStrategy> supplier;

    MovementOption(String code, String description, Supplier<MovementStrategy> supplier) {
        this.code = code;
        this.description = description;
        this.supplier = supplier;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public MovementStrategy createStrategy() {
        return supplier.get();
    }

    public static Optional<MovementOption> fromCode(String code) {
        return Arrays.stream(values())
                .filter(opt -> opt.code.equals(code))
                .findFirst();
    }
}
