package homework.modul2.homework3.ex4.item;

@FunctionalInterface
public interface Rule<T> {

    Integer measure(T arg);
}
