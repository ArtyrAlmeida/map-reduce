package multithreading;

import java.lang.Thread;

import utils.FileHandler;;

public class AppendWordsThread extends Thread {
    private int threadNumber;
    private String file;
    public AppendWordsThread (int threadNumber, String file) {
        this.threadNumber = threadNumber;
        this.file = file;
    }

    @Override
    public void run() {
        System.out.println("Running " + threadNumber);
        String fileName = "src/archives/archives" + threadNumber + ".txt";
        String fileContent = FileHandler.readFile(fileName);
        String wordCount = FileHandler.getWordCount(fileContent);
        FileHandler.appendText(this.file, wordCount);
    }
}
