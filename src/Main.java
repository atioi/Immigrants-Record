public class Main {
    public static void main(String[] args) {
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        flyweightFactory.get("Adam");
        flyweightFactory.get("Adam Kochanowski Tomaszów Górka");
        flyweightFactory.get("Marek Kochanowski Tomaszów Górka");
        flyweightFactory.get("Marek Kochanowski Grudnik Ziobro");

    }
}
