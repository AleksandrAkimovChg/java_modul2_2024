package homework.modul2.homework2;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class QueueBaggage {
    private final static String DIVIDER = ";";
    private final static String LOAD_ON_TAPE_START = "Начинается загрузка на ленту.";
    private final static String LOAD_ON_TAPE_STOP = "Лента загружена.";
    private final static String BAGGAGE_CLAIM_START = "Начинается выдача багажа.";
    private final static String BAGGAGE_CLAIM = "<Багаж № %s - выдан.";
    private final static String TAPE_IS_EMPTY = "Лента пустая, закончена выдача багажа.";
    private final static int INDEX_NUMBER_BAGGAGE = 0;
    private final static int COUNT_LIMIT_BAGGAGE_ON_TAPE = 10;

    public static void main(String[] args) {
        ex1("luggage.csv");
    }

    public static void ex1(String filename) {
        Queue<String> queue = new ArrayDeque<>();
        try (Scanner scanner = new Scanner(QueueBaggage.class.getClassLoader().getResourceAsStream(filename))) {
            while (scanner.hasNext()) {
                scanner.nextLine();
                loadBaggageOnTape(queue, scanner);
                claimBaggage(queue);
            }
        }
    }

    private static void loadBaggageOnTape(Queue<String> queue, Scanner scanner) {
        System.out.println(LOAD_ON_TAPE_START);
        int count = 0;
        while (scanner.hasNext() && count < COUNT_LIMIT_BAGGAGE_ON_TAPE) {
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
}
