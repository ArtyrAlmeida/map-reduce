import map.AppendWordsMap;
import reduce.CountWordsReduce;
import shuffle.OrganizeFiles;

public class Main {
    public static void main(String[] args) {
        MapReduce mapReduce = new MapReduce(new AppendWordsMap(), new OrganizeFiles(), new CountWordsReduce());

        mapReduce.run();
    }
}
