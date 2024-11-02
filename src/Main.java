import map.AppendWordsMap;

public class Main {
    public static void main(String[] args) {
        MapReduce mapReduce = new MapReduce(new AppendWordsMap());

        mapReduce.run();
    }
}
