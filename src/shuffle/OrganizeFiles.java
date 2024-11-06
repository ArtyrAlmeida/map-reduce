package shuffle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.FileHandler;

public class OrganizeFiles implements Shuffle {
    public void shuffle() {
        String fileName = "src/archives/intermediate.txt";
        String[] keys = FileHandler.getLines(fileName);

        Map<String, String> mapOfKeys = new HashMap<String, String>();
        for (String key : keys) {
            String[] keyValues = key.split(" ");
            if (keyValues.length < 2 || keyValues[0] == "") continue;
            String keyValue = keyValues[0];
            String value = keyValues[1];
            if (mapOfKeys.containsKey(keyValue)) {
                String currentValue = mapOfKeys.get(keyValue);
                mapOfKeys.put(keyValue, currentValue + "," + value);
            } else {
                mapOfKeys.put(keyValue, value);
            }
        }

        List<String> keyAlphabetic = new ArrayList<>(mapOfKeys.keySet());

        Collections.sort(keyAlphabetic, Comparator.comparing(String::toString));

        FileHandler.clearFile(fileName);
        StringBuilder sBuilder = new StringBuilder();
        keyAlphabetic.forEach((key) -> {
            sBuilder.append((key + " " + mapOfKeys.get(key)) + System.getProperty("line.separator"));
        });
        FileHandler.appendText(fileName, sBuilder.toString());
    }

}
