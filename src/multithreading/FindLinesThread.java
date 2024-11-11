package multithreading;
import utils.FileHandler;

public class FindLinesThread extends Thread {

    private String line;
    private String file;

    public FindLinesThread(String file, String line) {
        this.line = line;
        this.file = file;
    }

 public void run() {
        String[] keyValues = this.line.split(": ");
        if (keyValues.length < 2)
            return;
        String key = keyValues[0];
        FileHandler.appendText(this.file, key);
        System.out.println(key);
    }   
}
