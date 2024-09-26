package homework.modul2.homework4.ex3;

import java.util.Comparator;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        //Задание №3 - Небоскребы, небоскребы, а я...
        //1. Создать Класс Небоскреб - имя небоскреба, его высота в метрах.
        //2. Необходимо создать небоскребы:
        //Всемирный торговый центр - 541м
        //Шанхайская башня - 632м
        //Бурдж-Халифа - 828м
        //Международный финансовый центр Пинань - 599м
        //Абрадж аль-Бейт - 601м
        //Всемирный центр Лотте - 555м

        //3. Занести небоскребы в List! Дважды положить бурдж халифа в лист.

        //4. С помощью стримов:
        //4.1 Убрать дубликаты и сохранить в новый лист (далее работаем с этим листом).
        //(РАЗНЫЕ СТРИМЫ!)
        //4.2. Вывести только первые три небоскреба.
        //4.3. Вывести самый высокий небоскреб.
        //4.4. Вывести те небоскребы, которые выше километра.
        //Если выше километра нет, то вывести на экран: небоскреба выше километра - нет.

        Skyscraper worldTradeCenter = new Skyscraper("Всемирный торговый центр", 541);
        Skyscraper shanghaiTower = new Skyscraper("Шанхайская башня", 632);
        Skyscraper burjKhalifa = new Skyscraper("Бурдж-Халифа", 828);
        Skyscraper pingAnFinanceCenter = new Skyscraper("Международный финансовый центр Пинань", 599);
        Skyscraper abrajAlBayt = new Skyscraper("Абрадж аль-Бейт", 601);
        Skyscraper worldCenterLotte = new Skyscraper("Всемирный центр Лотте", 555);

        /**
         * 3. Занести небоскребы в List! Дважды положить бурдж халифа в лист.
         */
        List<Skyscraper> skyscrapers = List.of(worldTradeCenter, shanghaiTower, burjKhalifa, pingAnFinanceCenter,
                abrajAlBayt, worldCenterLotte, burjKhalifa);

        /**
         * Убрать дубликаты и сохранить в новый лист (далее работаем с этим листом).
         */
        List<Skyscraper> skyscrapersDistinct = skyscrapers.stream().distinct().toList();

        /**
         * 4.2. Вывести только первые три небоскреба.
         */
        skyscrapersDistinct.stream().limit(3).forEach(System.out::println);

        /**
         * 4.3. Вывести самый высокий небоскреб.
         */
        skyscrapersDistinct.stream().max(Comparator.comparing(Skyscraper::getHeight)).ifPresent(System.out::println);

        /**
         * 4.4. Вывести те небоскребы, которые выше километра.
         * Если выше километра нет, то вывести на экран: небоскреба выше километра - нет.
         */
        skyscrapersDistinct
                .stream()
                .filter(e -> e.getHeight() > 1000)
                .peek(System.out::println)
                .findFirst()
                .ifPresentOrElse(e -> {}, () -> System.out.println("небоскреба выше километра - нет"));
    }
}
