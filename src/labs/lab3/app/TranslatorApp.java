package labs.lab3.app;

import java.util.Map;
import java.util.function.Consumer;

import labs.lab3.loader.DictionaryLoader;
import labs.lab3.service.Translator;

public class TranslatorApp {

    public static String translateText(String input, String dictPath, Consumer<String> printer) {
        try {
            Map<String, String> dictionary = DictionaryLoader.load(dictPath);
            return Translator.translate(input, dictionary);
        } catch (Exception e) {
            printer.accept("Ошибка: " + e.getMessage());
            return "";
        }
    }

}
