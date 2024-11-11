package reduce;
import utils.FileHandler;
import multithreading.FindLinesThread;

public class GrepReduce implements Reduce {

    private String intermediateArchive;
    private String finalArchive;

    public GrepReduce() {
        this.intermediateArchive = "src/archives/grepIntermediate.txt";
        this.finalArchive = "src/archives/grepFinal.txt";
    }


    public void run () {
        FileHandler.clearFile(this.finalArchive);
        String[] valuesToProcess = FileHandler.getLines(this.intermediateArchive);
        for (int i = 0; i < valuesToProcess.length; i++) {
            FindLinesThread thread = new FindLinesThread(this.finalArchive, valuesToProcess[i]);
            thread.start();
        }
        FileHandler.clearFile(this.intermediateArchive);
    }
    
    
}
