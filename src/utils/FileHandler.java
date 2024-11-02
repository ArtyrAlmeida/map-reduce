package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public final class FileHandler {
    public static void appendText(String file, String text) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.write(text + "\n");
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("Error appending file: " + e.getMessage());
        }
    }

    public static String readFile(String file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringJoiner archiveContent = new StringJoiner(System.getProperty("line.separator"));
            String line = bufferedReader.readLine();
            while (line != null) {
                archiveContent.add(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            return archiveContent.toString();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
    }

    public static String getWordCount(String text) {
        StringJoiner wordCount = new StringJoiner("\n");

        String[] wordsArr = text.split("[\\r\\n\\t ]");

        Map<String, Integer> map = new HashMap<>();

        for (String word : wordsArr) {
            if (word == "") continue;
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        map.forEach((key, value) -> {
            wordCount.add(key + ": " + value);
        });

        return wordCount.toString();
    }
}
