import map.Map;
import shuffle.Shuffle;
import reduce.Reduce;

public class MapReduce {
    private Map map;
    private Shuffle shuffle;
    private Reduce reduce;

    public MapReduce(Map map, Shuffle shuffle, Reduce reduce) {
        this.map = map;
        this.shuffle = shuffle;
        this.reduce = reduce;
    }

    public MapReduce(Map map, Reduce reduce) {
        this.map = map;
        this.reduce = reduce;
    }
    
    public void run() {
        this.map.run();
        if (this.shuffle != null) this.shuffle.shuffle();
        this.reduce.run();
    }
}