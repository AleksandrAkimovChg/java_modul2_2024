package homework.modul2.homework1.zoo;

import homework.modul2.homework1.zoo.animal.Animal;

public class Zoo <T extends Animal, D extends Animal, B extends Animal> {
    private T firstAnimal;
    private D secondAnimal;
    private B thirdAnimal;

    public Zoo(T firstAnimal, D secondAnimal, B thirdAnimal) {
        this.firstAnimal = firstAnimal;
        this.secondAnimal = secondAnimal;
        this.thirdAnimal = thirdAnimal;
    }

    public T getFirstAnimal() {
        return firstAnimal;
    }

    public D getSecondAnimal() {
        return secondAnimal;
    }

    public B getThirdAnimal() {
        return thirdAnimal;
    }
}
