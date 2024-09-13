package homework.modul2.homework3.ex2.fortune;

@FunctionalInterface
public interface FortuneTelling<T> {

    boolean check(T arg);
}
