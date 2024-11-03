package multithreading;

import utils.FileHandler;

public class CountWordsThread extends Thread {
    private int threadNumber;
    private String file;
    private String word;
    public CountWordsThread (int threadNumber, String file, String word) {
        this.threadNumber = threadNumber;
        this.word = word;
        this.file = file;
    }

    public void run() {
        System.out.println("Running reduce thread " + this.threadNumber);
        String[] keyValues = this.word.split(": ");
        String key = keyValues[0];
        int quantity = keyValues[1].split(",").length;

        String textToAppend = key + ": " + quantity;
        FileHandler.appendText(this.file, textToAppend);
    }
}