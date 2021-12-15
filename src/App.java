
public class App {

    private final CLI cli = new CLI();
    private final IFlyweightFactory flyweightFactory = new ProxyFlyweightFactory();


    public String getLocalization() {
        return getCoordinates("Type longitude:", "E", "W") + " " + getCoordinates("Type latitude:", "N", "S");
    }

    public String getCoordinates(String label, String cardinalDirection1, String cardinalDirection2) {
        cli.display(label);
        return getCoordinate("Deg:") + "'" + getCoordinate("Min:") + "'" + getCoordinate("Sec:") + "'" + getCardinalDirection(cardinalDirection1, cardinalDirection2);
    }


    public String getCardinalDirection(String one, String two) {
        String cardinalDirection = cli.getInput("[" + one + "/" + two + "]").trim();
        try {
            if (!cardinalDirection.equals(one) && !cardinalDirection.equals(two))
                throw new Exception("Invalid cardinal direction!");
        } catch (Exception e) {
            cli.display(e.getMessage());
            return getCardinalDirection(one, two);
        }
        return cardinalDirection;
    }


    public String getCoordinate(String label) {
        String coordinate = cli.getInput(label);
        try {
            if (Integer.parseInt(coordinate) < 0 || Integer.parseInt(coordinate) > 90)
                throw new Exception("Invalid coordinate format.");
        } catch (Exception e) {
            cli.display(e.getMessage());
            coordinate = getCoordinate(label);
        }
        return coordinate;
    }


    public void run() {

        cli.displayMenu();
        String input = cli.getInput("Type option:");
        switch (input) {
            case "0" -> System.exit(0);
            case "1" -> {
                flyweightFactory.get(cli.getInput("Type full name:") + ";" + getLocalization());
                run();
            }
        }
    }
}
