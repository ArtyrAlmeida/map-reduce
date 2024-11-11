package utils;

import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
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

    public static void clearFile(String file) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write("");
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("Error clearing file: " + e.getMessage());
        }
    }

    public static void writeText(String file, String text) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(text);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
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

    public static String emitWords(String text) {
        StringJoiner wordCount = new StringJoiner("\n");

        String[] wordsArr = text.split("[\\r\\n\\t ]");

        for (String word : wordsArr) {
            wordCount.add(word + ": " + 1);
        }

        return wordCount.toString();
    }

    public static String[] getLines(String file) {
        String text = FileHandler.readFile(file);
        return text.split(System.getProperty("line.separator"));
    }

    public static int getNumberOfFiles(String path, String interest) {
        File[] fileList = new File(path).listFiles();
        int numberOfFiles = 0;
        for(File file : fileList) {
            if (file.getName().contains(interest)) {
                numberOfFiles += 1;
            };
        }
        return numberOfFiles;
    }
}
