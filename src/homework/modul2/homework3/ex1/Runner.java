package homework.modul2.homework3.ex1;

import homework.modul2.homework3.ex1.fruit.Apple;
import homework.modul2.homework3.ex1.fruit.Apricot;
import homework.modul2.homework3.ex1.fruit.Fruit;
import homework.modul2.homework3.ex1.fruit.GrowFruit;

public class Runner {
    public static void main(String[] args) {
        GrowFruit<Apple> appleFerm = () -> new Apple();
        GrowFruit<Apricot> apricotFerm = () -> new Apricot();

        Apple apple = appleFerm.get();
        Apricot apricot = apricotFerm.get();
    }
}
