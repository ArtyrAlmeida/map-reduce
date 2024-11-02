import map.Map;

public class MapReduce {
    private Map map;
    public MapReduce (Map map) {
        this.map = map;
    }

    public void run() {
        this.map.run();
    }
}