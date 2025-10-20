package labs.lab3.app;

import java.util.Map;
import java.util.Scanner;

import labs.lab3.exceptions.FileReadException;
import labs.lab3.exceptions.InvalidFileFormatException;
import labs.lab3.loader.DictionaryLoader;
import labs.lab3.service.Translator;

public class TranslatorApp {

    public static void main(String[] args) {

        String dictPath = "lab3/src/resources/dictionary.txt";

        try (Scanner console = new Scanner(System.in)) {
            Map<String, String> dictionary;
            try {
                dictionary = DictionaryLoader.load(dictPath);
            } catch (InvalidFileFormatException | FileReadException ex) {
                System.err.println("Ошибка при загрузке словаря: " + ex.getMessage());
                return;
            }

            System.out.println("Словарь загружен. Введите текст для перевода (пустая строка — выход):");
            while (true) {
                String line = console.nextLine();
                if (line.isEmpty()) {
                    break;
                }
                String translated = Translator.translate(line, dictionary);
                System.out.println(translated);
            }
        }

        System.out.println("Программа завершена.");
    }
}
