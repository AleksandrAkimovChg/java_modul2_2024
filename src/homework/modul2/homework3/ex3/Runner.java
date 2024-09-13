package homework.modul2.homework3.ex3;

import homework.modul2.homework3.ex3.fuel.Burn;
import homework.modul2.homework3.ex3.fuel.Tree;
import homework.modul2.homework3.ex3.fuel.Uranium;

public class Runner {
    public static void main(String[] args) {
        Burn<Uranium> nuclearReactor = arg -> System.out.println("Зеленый свет вокруг!");
        Burn<Tree> fire = arg -> System.out.println("Желто-красный свет вокруг!");

        nuclearReactor.burn(new Uranium());
        fire.burn(new Tree());
    }
}
