package homework.modul2.homework4.ex1;

import java.util.stream.Stream;

public class    Runner {
    private static final int LIMIT_CAR = 50;
    private static final int MIN_RANGE = 40;
    private static final int MAX_RANGE = 50;

    public static void main(String[] args) {
        //ИСПОЛЬЗОВАНИЕ FOR, WHILE ЗАПРЕЩЕНО В ЭТОЙ ДЗ! Только СТРИМЫ.

        //Задание №1 - Список спец номеров
        //Нам необходимо распечатать список номеров, которые принадлежат чиновникам
        //1. Создать класс машина. У машины есть номер.
        //2. Создать 50 машин с номерами а0[01-50]ан799 (где [01-50] - это все значения от 01 до 50)
        //3. Создать 50 машин с номерами к0[01-50]се178 (где [01-50] - это все значения от 01 до 50)
        //4. Объединить машины в единый стрим
        //5. Оставить в объединенном стриме машины с номерами 04[0-9] - это номера, выдаваемые чиновникам
        //6. Получить из оставшихся машин номера.
        //7. Распечатать номера.1        //ожидаемый результат:
        // a040ан799
        // a041ан799
        // ...
        // k048се178
        // k049се178

        Stream<Car> stream1 = Stream.generate(() -> new Car(CarNumberPattern.CAR_NUMBER_PATTERN_1))
                .limit(LIMIT_CAR);
        Stream<Car> stream2 = Stream.generate(() -> new Car(CarNumberPattern.CAR_NUMBER_PATTERN_2))
                .limit(LIMIT_CAR);

        Stream.concat(stream1, stream2)
                .filter(e -> (Integer.parseInt(e.getNumber().substring(2, 4)) >= MIN_RANGE)
                && Integer.parseInt(e.getNumber().substring(2, 4)) < MAX_RANGE)
                .forEach(System.out::println);
    }
}
