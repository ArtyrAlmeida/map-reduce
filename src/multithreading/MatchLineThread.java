package multithreading;

import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.regex.Pattern;

import utils.FileHandler;

public class MatchLineThread extends Thread {
    private int threadNumber;
    private String file;
    private String pattern;
    private boolean isRegex;

    public MatchLineThread(int threadNumber, String file, String pattern, boolean isRegex) {
        this.threadNumber = threadNumber;
        this.isRegex = isRegex;
        this.file = file;
        this.pattern = pattern;
    }

    public void run() {
        System.out.println("Running " + this.threadNumber);
        ArrayList<String> matches = new ArrayList<>();
        String fileName = "src/archives/grepArchive" + threadNumber + ".txt";
        String[] lines = FileHandler.getLines(fileName);
        for(String line : lines) {
            boolean isMatch = isRegex ? Pattern.compile(pattern).matcher(line).find() : line.contains(pattern);
            if (isMatch) matches.add(line);
        }

        StringJoiner archiveContent = new StringJoiner(System.getProperty("line.separator"));

        for(String matchedString : matches) {
            archiveContent.add(matchedString + ": 1");
        }

        FileHandler.appendText(file, archiveContent.toString());
    }
}
