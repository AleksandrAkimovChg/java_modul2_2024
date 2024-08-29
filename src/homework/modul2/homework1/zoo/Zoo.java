package homework.modul2.homework1.zoo;

import homework.modul2.homework1.zoo.animal.Animal;

import java.util.Arrays;

public class Zoo <T extends Animal> {
    Animal[] animals = new Animal[3];

    public Zoo(T animal1, T animal2, T animal3) {
        this.animals[0] = animal1;
        this.animals[1] = animal2;
        this.animals[2] = animal3;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "animals=" + Arrays.toString(animals) +
                '}';
    }

    public <T > T getAnimal1() {
        return (T) this.animals[0];
    }

    public <T> T getAnimal2() {
        return (T) this.animals[1];
    }

    public <T> T getAnimal3() {
        return (T) this.animals[2];
    }
}
