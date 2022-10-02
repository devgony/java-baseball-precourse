package baseball.domain;

import java.util.Arrays;

public class Digits {
    private Digit[] values;

    public Digits(Digit[] digits) {
        this.values = digits;
    }

    public Score match(Digit[] myDigits) {
        Score score = new Score(0, 0);
        for (int i = 0; i < myDigits.length; i++) {
            for (int j = 0; j < values.length; j++) {
                if (values[j].equals(myDigits[i]) && i == j) {
                    score = score.addStrike();
                    continue;
                } else if (values[j].equals(myDigits[i])) {
                    score = score.addBall();
                    continue;
                }

            }
        }

        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Digits digits = (Digits) o;
        return Arrays.equals(values, digits.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

    @Override
    public String toString() {
        return "Digits{" +
                "values=" + Arrays.toString(values) +
                '}';
    }
}
