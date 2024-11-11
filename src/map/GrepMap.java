package map;
import multithreading.MatchLineThread;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import utils.FileHandler;


public class GrepMap implements Map {
    private String  expression;
    private String finalArchive;
    private int numberOfThreads;
    private boolean isRegex;

    public GrepMap(String expression, boolean isRegex) {
        this.expression = expression;
        this.isRegex = isRegex;
        this.finalArchive = "src/archives/grepIntermediate.txt";
        this.numberOfThreads = FileHandler.getNumberOfFiles("src/archives/", "grepArchive");
    }

    public void run () {
        List<CompletableFuture<Void>> threadPool = new ArrayList<CompletableFuture<Void>>();
        for (int i = 0; i < numberOfThreads; i++) {
            MatchLineThread thread = new MatchLineThread(i, this.finalArchive, expression, isRegex);
            threadPool.add(CompletableFuture.runAsync(thread));
        }

        CompletableFuture.allOf(threadPool.toArray(new CompletableFuture[threadPool.size()])).join();
        System.out.println("Fim");
    }
    
    
}
