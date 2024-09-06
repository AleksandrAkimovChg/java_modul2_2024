package homework.modul2.homework1;

import homework.modul2.homework1.zoo.Zoo;
import homework.modul2.homework1.zoo.animal.Bird;
import homework.modul2.homework1.zoo.animal.Dog;
import homework.modul2.homework1.zoo.animal.Tiger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        ex1();
        ex2();

        ArrayList<String> monday = new ArrayList<>(
                List.of("Чебуречная №1", "Реберная", "Андерсон", "Ниппон", "Фо бо"));
        ArrayList<String> tuesday = new ArrayList<>(
                List.of("Вареничная №1", "Пушкин", "Чебуречная №1", "Ниппон", "Реберная"));
        ArrayList<String> wednesday = new ArrayList<>(
                List.of("Реберная", "Арарат", "Майя", "Ниппон", "Таксим"));
        ArrayList<String> thursday = new ArrayList<>(
                List.of("Грех", "Ваниль", "Реберная", "Пянсе", "Фо бо"));
        ArrayList<String> friday = new ArrayList<>(
                List.of("Бёрдс", "Реберная", "Андерсон", "Ниппон", "Чифанька"));

        ex3(monday, tuesday, wednesday, thursday, friday);
    }

    private static void ex1() {
        Zoo<Tiger, Dog, Bird> zoo = new Zoo<>(new Tiger(), new Dog(), new Bird());
        zoo.getFirstAnimal().tigerGrowls();
        zoo.getSecondAnimal().dogBarks();
        zoo.getThirdAnimal().birdFly();
    }

    private static void ex2() {
        List<Integer> january = List.of(0, -1, -1, -2, -5, -6, -7, -8, -9, -10, -5, -5,
                -2, -7, -3, -1, -8, -9, -8, -8, -18, -20, -23, -24, -25, -9, -8, -7, -6, -5, -1);
        List<Integer> february = List.of(-8, -10, -12, -13, -15, -16, -12, -7, -8, -10,
                -10, -9, -8, -8, -8, -9, -10, -9, -5, -6, -8, -7, -8, -9, -6, -5, -3, -1);
        ArrayList<Integer> monthlyAverage = new ArrayList<>();
        monthlyAverage.addAll(january);
        monthlyAverage.addAll(february);
        double sum = 0;
        for (Integer item : monthlyAverage) {
            sum += item;
        }
        BigDecimal result = new BigDecimal(sum / monthlyAverage.size()).setScale(1, RoundingMode.HALF_UP);
        System.out.println(result);
    }

    private static void ex3(ArrayList<String> monday, ArrayList<String> tuesday, ArrayList<String> wednesday,
                            ArrayList<String> thursday, ArrayList<String> friday) {
        ArrayList<String> result = new ArrayList<>(monday);
        ArrayList<ArrayList> arrayLists = new ArrayList<>(List.of(tuesday, wednesday, thursday, friday));
        for (int i = 0; i < arrayLists.size(); i++) {
            result.retainAll(arrayLists.get(i));
        }
        System.out.println(result);
    }
}
