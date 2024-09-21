package homework.modul2.homework4.ex1;

public enum CarNumberPattern {
    CAR_NUMBER_PATTERN_1(0, "а0%02dан799"),
    CAR_NUMBER_PATTERN_2(1, "к0%02dсе178");

    private final int index;
    private final String patternNumber;

    CarNumberPattern(int index, String number) {
        this.index = index;
        this.patternNumber = number;
    }

    public String getPatternNumber() {
        return patternNumber;
    }

    public int getIndex() {
        return index;
    }
}
