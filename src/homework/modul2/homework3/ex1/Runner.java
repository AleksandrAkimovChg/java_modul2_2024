package homework.modul2.homework3.ex1;

import homework.modul2.homework3.ex1.fruit.Apple;
import homework.modul2.homework3.ex1.fruit.Apricot;
import homework.modul2.homework3.ex1.fruit.GrowFruit;

public class Runner {
    public static void main(String[] args) {
        GrowFruit<Apple> appleFarm = () -> new Apple();
        GrowFruit<Apricot> apricotFarm = () -> new Apricot();

        Apple apple = appleFarm.get();
        Apricot apricot = apricotFarm.get();
    }
}
