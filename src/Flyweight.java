import java.util.ArrayList;
import java.util.List;

public class Flyweight {
    private final String key;
    private final List<Flyweight> flyweights = new ArrayList<>();

    public Flyweight(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public Flyweight get(String keys) {
        String[] splitKeys = FlyweightFactory.splitKeys(keys);
        Flyweight flyweight = FlyweightFactory.findOrCreate(flyweights, splitKeys[0]);
        if (splitKeys.length > 1)
            return flyweight.get(splitKeys[1]);
        return flyweight;
    }

}