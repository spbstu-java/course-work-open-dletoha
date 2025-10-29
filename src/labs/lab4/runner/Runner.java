package labs.lab4.runner;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import labs.lab4.steamApiMethods.MyMethods;

public class Runner {

    public static void runAverage(List<Integer> numbers, Consumer<String> printer) {
        double avg = MyMethods.average(numbers);
        printer.accept("Среднее: " + avg);
    }

    public static void runTransform(List<String> strings, Consumer<String> printer) {
        List<String> result = MyMethods.transformStrings(strings);
        printer.accept("Преобразованные строки: " + result.toString());
    }

    public static void runDuplicates(List<Integer> numbers, Consumer<String> printer) {
        List<Integer> result = MyMethods.uniqueSquares(numbers);
        printer.accept("Квадраты уникальных элементов: " + result.toString());
    }

    public static void runLastElement(Collection<Object> collection, Consumer<String> printer) {
        Object result = MyMethods.getLastElement(collection);
        printer.accept("Последний элемент: " + result.toString());
    }

    public static void runEvenSum(int[] numbers, Consumer<String> printer) {
        int result = MyMethods.sumEven(numbers);
        printer.accept("Последний элемент: " + result);
    }

    public static void runCharMap(List<String> strings, Consumer<String> printer) {
        Map<Character, String> result = MyMethods.toCharMap(strings);
        printer.accept("Преобразование в Map:");
        result.forEach((k, v) -> printer.accept(k + " -> " + v));
    }

}
