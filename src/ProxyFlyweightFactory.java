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

    public String unifyFullName(String fullName) {
        return Arrays.stream(fullName.split("\s"))
                .map(ProxyFlyweightFactory::capitalize)
                .collect(Collectors.joining("\s"));
    }
    
    @Override
    public Flyweight get(String keys) {
        String[] split = keys.split(";");
        String fullName = split[0];
        String localization = split[1];

        return flyweightFactory.get(unifyFullName(fullName) + " " + localization);

    }
}

