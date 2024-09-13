package homework.modul2.homework3.ex4;

import homework.modul2.homework3.ex4.item.Animal;
import homework.modul2.homework3.ex4.item.Boat;
import homework.modul2.homework3.ex4.item.Rule;

public class Runner {
    public static void main(String[] args) {
        Rule<Boat> boatMeter = arg -> arg.getLength();
        Rule<Animal> animalMeter = arg -> arg.getBody() + arg.getTail();

        Integer measure1 = boatMeter.measure(new Boat(8));
        Integer measure2 = animalMeter.measure(new Animal(50, 40));
    }
}
