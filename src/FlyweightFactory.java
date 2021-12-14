import java.util.*;

public class FlyweightFactory {
    private final List<Flyweight> flyweights = new ArrayList<>();

    /**
     * In this case our keys are parts of someone's full name.
     */
    public Flyweight get(String keys) {
        String[] splitKeys = splitKeys(keys);
        Flyweight flyweight = findOrCreate(flyweights, splitKeys[0]);
        if (splitKeys.length > 1)
            return flyweight.get(splitKeys[1]);
        return flyweight;
    }

    public static String[] splitKeys(String keys) {
        return keys.split("\s", 2);
    }

    public static Flyweight findOrCreate(List<Flyweight> flyweights, String key) {
        for (Flyweight flyweight : flyweights)
            if (flyweight.getKey().equals(key)) {
                System.out.println("Znalazłem flyweight o kluczu: " + key);
                return flyweight;
            }
        Flyweight flyweight = new Flyweight(key);
        System.out.println("Utworzyłem nowy flyweight o kluczu: " + key);
        flyweights.add(flyweight);
        return flyweight;
    }

}
