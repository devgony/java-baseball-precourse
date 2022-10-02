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
                if (isStrike(values[j], myDigits[i], i, j)) {
                    score = score.addStrike();
                    continue;
                } else if (isBall(values[j], myDigits[i])) {
                    score = score.addBall();
                    continue;
                }

            }
        }

        return score;
    }

    private boolean isBall(Digit digit, Digit myDigit) {
        return digit.equals(myDigit);
    }

    private boolean isStrike(Digit digit, Digit myDigit, int i, int j) {
        return isBall(digit, myDigit) && i == j;
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
