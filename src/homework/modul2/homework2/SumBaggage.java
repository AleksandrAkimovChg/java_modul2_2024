package homework.modul2.homework2;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SumBaggage {
    private final static String DIVIDER = ";";
    private final static int INDEX_WEIGHT_BAGGAGE = 1;
    private final static String BAGGAGE_CATEGORY_LIGHT = "Легкий";
    private final static int MAX_LIMIT_BAGGAGE_CATEGORY_LIGHT = 5;
    private final static String BAGGAGE_CATEGORY_MIDDLE = "Средний";
    private final static int MAX_LIMIT_BAGGAGE_CATEGORY_MIDDLE = 10;
    private final static String BAGGAGE_CATEGORY_HEAVY = "Тяжелый";

    public static void main(String[] args) {
        System.out.println(ex2("luggage.csv"));
    }

    public static Map<String, Integer> ex2(String filename) {
        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put(BAGGAGE_CATEGORY_LIGHT, 0);
        resultMap.put(BAGGAGE_CATEGORY_MIDDLE, 0);
        resultMap.put(BAGGAGE_CATEGORY_HEAVY, 0);
        try (Scanner scanner = new Scanner(SumBaggage.class.getClassLoader().getResourceAsStream(filename))) {
            scanner.nextLine();
            addSumBaggage(scanner, resultMap);
        }
        return resultMap;
    }

    private static void addSumBaggage(Scanner scanner, Map<String, Integer> resultMap) {
        while (scanner.hasNext()) {
            int weight = Integer.parseInt(scanner.nextLine().split(DIVIDER)[INDEX_WEIGHT_BAGGAGE].trim());
            if (weight < MAX_LIMIT_BAGGAGE_CATEGORY_LIGHT) {
                resultMap.put(BAGGAGE_CATEGORY_LIGHT, resultMap.get(BAGGAGE_CATEGORY_LIGHT) + weight);
            } else if (weight < MAX_LIMIT_BAGGAGE_CATEGORY_MIDDLE) {
                resultMap.put(BAGGAGE_CATEGORY_MIDDLE, resultMap.get(BAGGAGE_CATEGORY_MIDDLE) + weight);
            } else {
                resultMap.put(BAGGAGE_CATEGORY_HEAVY, resultMap.get(BAGGAGE_CATEGORY_HEAVY) + weight);
            }
        }
    }
}
