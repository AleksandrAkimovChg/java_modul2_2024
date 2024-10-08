package homework.modul2.homework4.ex2;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        //Задание №2 - Сколько здесь "о" ?
        //1. Создать набор уникальных слов: "тон", "тополь", "боль", "рой", "стройка"
        //2. Создать стрим у набора
        //2.1 Посчитать количество букв "о" в одном слове
        //2.2 Посчитать сумму количества букв "о" во всех словах из набора
        //2.3 Вывести на экран сумму букв "о". Если в словах нет буквы "о", то распечатать ноль.
        //
        //ожидаемый результат:
        //6
        List<String> list = List.of("тон", "тополь", "боль", "рой", "стройка");
        List<String> list2 = List.of("тн", "тль", "бь", "рй", "стрка");

        /**
         * 2.1 Посчитать количество букв "о" в одном слове
         */
        list.stream()
                .map(e -> e.replaceAll("[^о]", ""))
                .map(String::length)
                .forEach(System.out::println);

        /**
         * 2.2 Посчитать сумму количества букв "о" во всех словах из набора
         */
        long count = list.stream()
                .flatMapToInt(String::chars)
                .filter(c -> c == 'о').count();
        System.out.println(count);

        /**
         * 2.3 Вывести на экран сумму букв "о". Если в словах нет буквы "о", то распечатать ноль.
         */
        int reduce = list2.stream()
                .flatMapToInt(String::chars)
                .filter(c -> c == 'о').reduce(0, Integer::sum);
        System.out.println(reduce);
    }
}
