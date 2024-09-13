package homework.modul2.homework3.ex1.fruit;

@FunctionalInterface
public interface GrowFruit<T extends Fruit> {

    T get();
}
