package reduce;

import utils.FileHandler;
import multithreading.CountWordsThread;

public class CountWordsReduce implements Reduce {
    private String intermediateArchive;
    private String finalArchive;

    public CountWordsReduce() {
        this.intermediateArchive = "src/archives/intermediate.txt";
        this.finalArchive = "src/archives/final.txt";
    }

    public void run() {
        FileHandler.clearFile(this.finalArchive);
        String[] valuesToProcess = FileHandler.getLines(this.intermediateArchive);
        System.out.println("Counting " + valuesToProcess.length + " words");
        for (int i = 0; i < valuesToProcess.length; i++) {
            CountWordsThread thread = new CountWordsThread(i, this.finalArchive, valuesToProcess[i]);
            thread.start();
        }
        FileHandler.clearFile(this.intermediateArchive);
    }
}