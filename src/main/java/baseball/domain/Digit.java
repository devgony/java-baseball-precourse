package baseball.domain;

import java.util.Objects;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Digit {
    private int value;

    public Digit(int value) {
        this.value = value;
    }

    public static Digit generate() {
        int random = pickNumberInRange(0, 9);
        return new Digit(random);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Digit digit = (Digit) o;
        return value == digit.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Digit{" +
                "value=" + value +
                '}';
    }
}
