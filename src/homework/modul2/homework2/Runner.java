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
        //1. Задание: Грузчики в Болгарии
        //В аэропорт Болгарии прилетает самолет. В самолете багаж.
        //На выгрузной ленте может находиться не больше 10 чемоданов.
        //Задача: разгрузить багажное отделение самолета, загружая на ленту не более 10 чемоданов.
        //Примечание: багаж должен отдаваться в том же порядке, в котором попадал на ленту.

        //Т.е нужно создать функцию, в которую приходит имя файла(это прибывший багаж).
        //От туда будет считываться порциями по 10 штук багаж. Этот багаж перемещается на ленту.
        //Печатается: Начинается загрузка на ленту
        //После того как лента заполнена или больше нет чемоданов:
        //Печатается: Лента загружена, начинается выдача багажа.
        //Лента включается и с нее пропадают чемоданы.
        //Печатается на экран: {Номер багажа} - выдан
        //После окончания выдачи печатается: Лента пустая, закончена выдача багажа

        //Т.е. прибыл багаж (файл luggage.csv).
        //Там находится 20 чемоданов(номера от 1 до 20) . На экране будет выведено:
        //Начинается загрузка на ленту
        //Лента загружена, начинается выдача багажа
        //1 - выдан
        //2 - выдан
        //....
        //10 - выдан
        //Лента пустая, закончена выдача багажа
        //Начинается загрузка на ленту
        //Лента загружена, начинается выдача багажа
        //11 - выдан
        //12 - выдан
        //....
        //20 - выдан
        //Лента пустая, закончена выдача багажа

        //Протестировать функцию на файле luggage.csv.

        //2. Задание: Таможня в Болгарии
        //Таможня собирает статистику о весе ввезенных чемоданов.
        //Есть 3 категории чемоданов: легкий (до 5 кг), средний (от 5 кг до 10кг), тяжелый (от 10 кг)
        //Необходимо создать функцию, которая:
        //считывает файл с багажом, суммирует вес по каждой категории и возвращает сгруппированные данные
        //т.е функция должна вернуть данные (не распечатать), в которых будет инфо:
        //категория чемодана - сумма всех чемоданов этой категории

        //Пример возврата:
        //легкий - 205
        //средний - 513
        //тяжелый - 1200

        //Протестировать функцию на файле luggage.csv.

//        ex1("luggage.csv");
        ex2("luggage.csv");
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
            queue.offer(tempString);
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
