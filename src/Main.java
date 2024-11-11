import map.AppendWordsMap;
import reduce.CountWordsReduce;
import shuffle.OrganizeFiles;
import map.GrepMap;
import reduce.GrepReduce;

public class Main {
    public static void main(String[] args) {
        // MapReduce mapReduce = new MapReduce(new AppendWordsMap(), new OrganizeFiles(), new CountWordsReduce());
        MapReduce mapReduce2 = new MapReduce(new GrepMap("[a-z]{4}", true), new GrepReduce());
        mapReduce2.run();
    }
}
