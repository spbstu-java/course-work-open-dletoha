package labs.lab3.loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import labs.lab3.exceptions.FileReadException;
import labs.lab3.exceptions.InvalidFileFormatException;

public class DictionaryLoader {

    // Загружает словарь из файла, сортирует по убыванию длины ключа.

    public static Map<String, String> load(String filePath)
            throws InvalidFileFormatException, FileReadException {
        Map<String, String> temp = new LinkedHashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                int delim = line.indexOf('|');
                if (delim < 0) {
                    throw new InvalidFileFormatException("В строке отсутствует разделитель '|': " + line);
                }
                String key = line.substring(0, delim).trim();
                String value = line.substring(delim + 1).trim();
                if (key.isEmpty() || value.isEmpty()) {
                    throw new InvalidFileFormatException("Пустой ключ или перевод: " + line);
                }
                temp.put(key, value);
            }
        } catch (IOException e) {
            throw new FileReadException("Не удалось прочитать файл: " + filePath, e);
        }

        // Сортировка по длине ключа (убывание)
        List<Map.Entry<String, String>> entries = new ArrayList<>(temp.entrySet());
        entries.sort((e1, e2) -> Integer.compare(e2.getKey().length(), e1.getKey().length()));

        LinkedHashMap<String, String> sorted = new LinkedHashMap<>();
        for (Map.Entry<String, String> e : entries) {
            sorted.put(e.getKey(), e.getValue());
        }
        return sorted;
    }
}
