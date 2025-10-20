package steamApiMethods;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyMethods {
    // Среднее значение списка целых чисел
    public static double average(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("Список пуст"));
    }

    // Преобразование строк в верхний регистр с префиксом "_new_"
    public static List<String> transformStrings(List<String> strings) {
        return strings.stream()
                .map(s -> "_new_" + s.toUpperCase())
                .collect(Collectors.toList());
    }

    // Список квадратов элементов, встречающихся только один раз
    public static List<Integer> uniqueSquares(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey() * entry.getKey())
                .collect(Collectors.toList());
    }

    // Последний элемент коллекции или исключение
    public static <T> T getLastElement(Collection<T> collection) {
        return collection.stream()
                .reduce((first, second) -> second)
                .orElseThrow(() -> new NoSuchElementException("Коллекция пуста"));
    }

    // Сумма чётных чисел массива
    public static int sumEven(int[] array) {
        return Arrays.stream(array)
                .filter(n -> n % 2 == 0)
                .sum();
    }

    // Преобразование строк в Map: первый символ — ключ, остальные — значение
    public static Map<Character, String> toCharMap(List<String> strings) {
        return strings.stream()
                .filter(s -> s.length() > 1)
                .collect(Collectors.toMap(
                        s -> s.charAt(0),
                        s -> s.substring(1),
                        (v1, v2) -> v1 // если ключ повторяется, то оставляем первый
                ));
    }

}
