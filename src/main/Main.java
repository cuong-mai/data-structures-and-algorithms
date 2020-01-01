import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<String> flights = new LinkedList<>();
        flights.add("Toronto");
        flights.add("Quebec");

        System.out.println(flights.get(1));
    }


}
