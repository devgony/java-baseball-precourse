package baseball.domain;

public class Digit {
    private int value;

    public Digit(int value) {
        this.value = value;
    }

    public boolean isEqual(int input) {
        return value == input;
    }
}
