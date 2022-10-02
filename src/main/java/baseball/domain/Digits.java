package baseball.domain;

import java.util.Arrays;

public class Digits {
    private Digit[] digits;

    public Digits(Digit[] digits) {
        this.digits = digits;
    }

    public Score match(Digit[] myDigits) {
        Score score = new Score(0, 0);
        for (int myDigitIndex = 0; myDigitIndex < myDigits.length; myDigitIndex++) {
            score = renewScoreWithDigits(myDigits, score, myDigitIndex);
        }

        return score;
    }

    private Score renewScoreWithDigits(Digit[] myDigits, Score score, int myDigitIndex) {
        for (int digitIndex = 0; digitIndex < digits.length; digitIndex++) {
            score = renewScore(myDigits, score, myDigitIndex, digitIndex);
            continue;
        }
        return score;
    }

    private Score renewScore(Digit[] myDigits, Score score, int myDigitIndex, int digitIndex) {
        if (isStrike(digits[digitIndex], myDigits[myDigitIndex], myDigitIndex, digitIndex)) {
            return score.addStrike();
        } else if (isBall(digits[digitIndex], myDigits[myDigitIndex])) {
            return score.addBall();
        }
        return score;
    }

    private boolean isBall(Digit digit, Digit myDigit) {
        return digit.equals(myDigit);
    }

    private boolean isStrike(Digit digit, Digit myDigit, int myDigitIndex, int digitIndex) {
        return isBall(digit, myDigit) && myDigitIndex == digitIndex;
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
