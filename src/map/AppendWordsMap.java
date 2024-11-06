package map;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import multithreading.AppendWordsThread;

public class AppendWordsMap implements Map {
    private String finalArchive;

    public AppendWordsMap() {
        this.finalArchive = "src/archives/intermediate.txt";
    }

    public void run() {
        List<CompletableFuture<Void>> threadPool = new ArrayList<CompletableFuture<Void>>();
        for (int i = 0; i < 9; i++) {
            AppendWordsThread thread = new AppendWordsThread(i, this.finalArchive);
            threadPool.add(CompletableFuture.runAsync(thread));
        }

        CompletableFuture.allOf(threadPool.toArray(new CompletableFuture[threadPool.size()])).join();
        System.out.println("Fim");
    }
}
