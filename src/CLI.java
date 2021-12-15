import java.util.Arrays;
import java.util.Scanner;

public class CLI {

    private final String[] options = {
            "0: Exit",
            "1: Add",
    };

    public void displayMenu() {
        Arrays.stream(options).forEach(System.out::println);
    }

    public String getInput(String label) {
        System.out.print(label + "\s");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }


    public void display(String label) {
        System.out.println(label);
    }


}
