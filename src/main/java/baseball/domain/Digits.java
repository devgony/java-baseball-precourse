package baseball.domain;

import java.util.Arrays;


public class Digits {
    private Digit[] digits;

    public Digits(Digit[] digits) {
        this.digits = digits;
    }

    public static Digits parse(String input) {
        Digit[] digits = new Digit[3];
        for (int i = 0; i < input.length(); i++) {
            digits[i] = new Digit(Character.getNumericValue(input.charAt(i)));
        }
        return new Digits(digits);
    }

    public Digits generate() {
        Digit[] digits = new Digit[3];
        for (int i = 0; i < 3; i++) {
            digits[i] = (Digit.generate());
        }
        return new Digits(digits);

    }

    public Score match(Digit[] inputDigits) {
        Score score = new Score(0, 0);
        for (int inputDigitIndex = 0; inputDigitIndex < inputDigits.length; inputDigitIndex++) {
            score = renewScoreWithDigits(inputDigits, score, inputDigitIndex);
        }

        return score;
    }

    private Score renewScoreWithDigits(Digit[] inputDigits, Score score, int inputDigitIndex) {
        for (int digitIndex = 0; digitIndex < digits.length; digitIndex++) {
            score = renewScore(inputDigits, score, inputDigitIndex, digitIndex);
            continue;
        }
        return score;
    }

    private Score renewScore(Digit[] inputDigits, Score score, int inputDigitIndex, int digitIndex) {
        if (isStrike(digits[digitIndex], inputDigits[inputDigitIndex], inputDigitIndex, digitIndex)) {
            return score.addStrike();
        } else if (isBall(digits[digitIndex], inputDigits[inputDigitIndex])) {
            return score.addBall();
        }
        return score;
    }

    private boolean isBall(Digit digit, Digit inputDigit) {
        return digit.equals(inputDigit);
    }

    private boolean isStrike(Digit digit, Digit inputDigit, int inputDigitIndex, int digitIndex) {
        return isBall(digit, inputDigit) && inputDigitIndex == digitIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Digits digits = (Digits) o;
        return Arrays.equals(this.digits, digits.digits);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(digits);
    }

    @Override
    public String toString() {
        return "Digits{" +
                "values=" + Arrays.toString(digits) +
                '}';
    }
}
