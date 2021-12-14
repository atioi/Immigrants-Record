import java.util.Arrays;
import java.util.Scanner;

public class App {

    private final IFlyweightFactory flyweightFactory = new ProxyFlyweightFactory();

    private final String[] options = {
            "0: Exit",
            "1: Add person",
            "2: Show all"
    };

    public void displayMenu() {
        Arrays.stream(options).forEach(System.out::println);
    }

    public String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public void loop() {
        while (true) {
            displayMenu();
            String opt = getInput();

            switch (opt) {
                case "0":
                    System.exit(0);
                case "1":
                    flyweightFactory.get(getInput());
                    break;
                case "2":
                    break;
            }
        }
    }

}
