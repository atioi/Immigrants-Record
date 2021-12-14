import java.util.Arrays;
import java.util.stream.Collectors;


/**
 * Proxy pattern implementations.
 */
public class ProxyFlyweightFactory implements IFlyweightFactory {

    private final IFlyweightFactory flyweightFactory;

    public ProxyFlyweightFactory() {
        this.flyweightFactory = new FlyweightFactory();
    }

    public static String capitalize(String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
    }

    public String prepareKeys(String keys) {
        return Arrays.stream(keys.split("\s"))
                .map(ProxyFlyweightFactory::capitalize)
                .collect(Collectors.joining("\s"));
    }

    @Override
    public Flyweight get(String keys) {
        return flyweightFactory.get(prepareKeys(keys));
    }

}

