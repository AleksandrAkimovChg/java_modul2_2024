package homework.modul2.homework4.ex1;

public class Car {
    private static Integer countPattern1 = 0;
    private static Integer countPattern2 = 0;
    private Integer count;
    private String pattern;
    private String number;
    private CarNumberPattern carNumberPattern;

    public Car(CarNumberPattern carNumberPattern) {
        this.carNumberPattern = carNumberPattern;
        this.pattern = this.carNumberPattern.getPatternNumber();
        setCount(this.carNumberPattern.getIndex());
        countChoicePatternCount(this.carNumberPattern.getIndex());
        counting();
        doNumber();
    }

    private void setCount(int index) {
        this.count = countPattern1;
        if (index !=0) {
            this.count = countPattern2;
        }
    }

    private void countChoicePatternCount(int index) {
        if (index == 0) {
            countPattern1++;
        }
        if (index != 0) {
            countPattern2++;
        }
    }

    private void counting() {
        if (this.count <= 99) {
            count++;
        }
    }

    private void doNumber() {
        String str = String.format(this.pattern, this.count);
        this.number = str;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Car{" +
                "number='" + number + '\'' +
                '}';
    }
}
