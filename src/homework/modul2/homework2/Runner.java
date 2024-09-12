package homework.modul2.homework2;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Runner {
    private final static String DIVIDER = ";";
    private final static String LOAD_ON_TAPE_START = "Начинается загрузка на ленту.";
    private final static String LOAD_ON_TAPE_STOP = "Лента загружена.";
    private final static String BAGGAGE_CLAIM_START = "Начинается выдача багажа.";
    private final static String BAGGAGE_CLAIM = "<Багаж № %s - выдан.";
    private final static String TAPE_IS_EMPTY = "Лента пустая, закончена выдача багажа.";
    private final static int INDEX_NUMBER_BAGGAGE = 0;
    private final static int INDEX_WEIGHT_BAGGAGE = 1;
    private final static int COUNT_TEN = 10;
    private final static String BAGGAGE_CATEGORY_LIGHT = "Легкий";
    private final static int MAX_LIMIT_BAGGAGE_CATEGORY_LIGHT = 5;
    private final static String BAGGAGE_CATEGORY_MIDDLE = "Средний";
    private final static int MAX_LIMIT_BAGGAGE_CATEGORY_MIDDLE = 10;
    private final static String BAGGAGE_CATEGORY_HEAVY = "Тяжелый";

    public static void main(String[] args) {

        ex1("luggage.csv");
        System.out.println(ex2("luggage.csv"));
    }

    public static void ex1(String filename) {
        Queue<String> queue = new ArrayDeque<>();
        try (InputStream inputStream = Runner.class.getClassLoader().getResourceAsStream(filename);
             Scanner scanner = new Scanner(inputStream);) {
            while (scanner.hasNext()) {
                scanner.nextLine();
                loadBaggageOnTape(queue, scanner);
                claimBaggage(queue);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void loadBaggageOnTape(Queue<String> queue, Scanner scanner) {
        System.out.println(LOAD_ON_TAPE_START);
        int count = 0;
        while (scanner.hasNext() && count < COUNT_TEN) {
            String tempString = scanner.nextLine().split(DIVIDER)[INDEX_NUMBER_BAGGAGE].trim();
            queue.add(tempString);
            count++;
        }
        System.out.println(LOAD_ON_TAPE_STOP);
    }

    private static void claimBaggage(Queue<String> queue) {
        System.out.println(BAGGAGE_CLAIM_START);
        while (queue.peek() != null) {
            System.out.printf(BAGGAGE_CLAIM + "%n", queue.poll());
        }
        System.out.println(TAPE_IS_EMPTY);
    }

    public static Map<String, Integer> ex2(String filename) {
        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put(BAGGAGE_CATEGORY_LIGHT, 0);
        resultMap.put(BAGGAGE_CATEGORY_MIDDLE, 0);
        resultMap.put(BAGGAGE_CATEGORY_HEAVY, 0);
        try (InputStream inputStream = Runner.class.getClassLoader().getResourceAsStream(filename);
             Scanner scanner = new Scanner(inputStream);) {
            scanner.nextLine();
            addSumBaggage(scanner, resultMap);
        } catch (IOException ex) {
            ex.printStackTrace();
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
