package multithreading;

import utils.FileHandler;

public class CountWordsThread extends Thread {
    private String file;
    private String word;

    public CountWordsThread(int threadNumber, String file, String word) {
        this.word = word;
        this.file = file;
    }

    public void run() {
        String[] keyValues = this.word.split(": ");
        if (keyValues.length < 2)
            return;
        String key = keyValues[0];
        int quantity = keyValues[1].split(",").length;

        String textToAppend = key + ": " + quantity;
        FileHandler.appendText(this.file, textToAppend);
    }
}