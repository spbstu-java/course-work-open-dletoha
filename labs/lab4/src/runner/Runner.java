package runner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import steamApiMethods.MyMethods;

public class Runner {
    public static void main(String[] args) {
        // Пример для среднего значения
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        double avg = MyMethods.average(numbers);
        System.out.println("Среднее значение: " + avg);

        // Пример для преобразования строк
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        List<String> transformed = MyMethods.transformStrings(strings);
        System.out.println("Преобразованные строки: " + transformed);

        // Пример для квадратов уникальных элементов
        List<Integer> numsWithDuplicates = Arrays.asList(2, 3, 2, 4, 5, 5, 6);
        List<Integer> uniqueSquares = MyMethods.uniqueSquares(numsWithDuplicates);
        System.out.println("Квадраты уникальных элементов: " + uniqueSquares);

        // Пример для получения последнего элемента
        List<String> sampleList = Arrays.asList("first", "middle", "last");
        String lastElement = MyMethods.getLastElement(sampleList);
        System.out.println("Последний элемент: " + lastElement);

        // Пример для суммы чётных чисел
        int[] array = { 1, 2, 3, 4, 5, 6 };
        int evenSum = MyMethods.sumEven(array);
        System.out.println("Сумма чётных чисел: " + evenSum);

        // Пример для преобразования строк в Map
        List<String> stringList = Arrays.asList("apple", "banana", "cherry", "gavocado");
        Map<Character, String> charMap = MyMethods.toCharMap(stringList);
        System.out.println("Преобразование в Map:");
        charMap.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

}
