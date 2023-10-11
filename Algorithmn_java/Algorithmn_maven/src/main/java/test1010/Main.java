package test1010;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Box> boxList = new HashMap<>();
        boxList.put(1, new Box(20, "snack"));
        boxList.put(2, new Box(14, "drink"));
        boxList.put(3, new Box(3, "book"));

        boxList.values().stream()
                .sorted(Comparator.comparing(Box::getName))
                .map(n-> n.getName().toUpperCase())
                .forEach(System.out::println);
    }
}
