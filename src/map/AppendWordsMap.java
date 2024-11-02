package map;
import multithreading.AppendWordsThread;

public class AppendWordsMap implements Map {
    private String finalArchive;
    public AppendWordsMap() {
        this.finalArchive = "src/archives/intermediate.txt";
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            AppendWordsThread thread = new AppendWordsThread(i, this.finalArchive);
            thread.start();
        }
    }
}
