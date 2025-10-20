package service;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Translator {

    public static String translate(String text, Map<String, String> dict) {
        String result = text;
        for (Map.Entry<String, String> entry : dict.entrySet()) {
            String key = entry.getKey();
            String translation = entry.getValue();

            Pattern pattern = Pattern.compile("\\b" + Pattern.quote(key) + "\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(result);
            result = matcher.replaceAll(Matcher.quoteReplacement(translation));
        }
        return result;
    }
}
