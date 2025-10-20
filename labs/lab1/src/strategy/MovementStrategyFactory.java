package strategy;

public class MovementStrategyFactory {

    // Возвращает новую стратегию по коду, или null, если код неизвестен.

    public static MovementStrategy create(String code) {
        return MovementOption
                .fromCode(code)
                .map(MovementOption::createStrategy)
                .orElse(null);
    }
}
