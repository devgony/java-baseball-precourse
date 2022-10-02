package baseball.domain;

import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

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

    public static Digits generate() {
        Digit[] digits = new Digit[3];
        int a = pickNumberInRange(0, 9);
        int b, c;
        if (a == 0) {
            b = pickNumberInRange(a + 1, 9);
            if (b == 0) {
                c = pickNumberInRange(b + 1, 9);
            }
            if (b == 9) {
                c = pickNumberInRange(a + 1, b - 1);
            }
        }
        if (a == 9) {
            b = pickNumberInRange(0, a - 1);
            if (b == 0) {
                c = pickNumberInRange(b + 1, a - 1);
            }
            if (b == 9) {
                c = pickNumberInRange(0, b - 1);
            }
        }
        b = pickNumberInRange(0, a - 1);
        c = pickNumberInRange(b + 1, 9);

        digits[0] = new Digit(a);
        digits[1] = new Digit(b);
        digits[2] = new Digit(c);

        return new Digits(digits);
    }

    public Score match(Digits inputDigits) {
        // TODO: remove debug only print
        System.out.println(this);

        Digit[] inputDigitArray = inputDigits.digits;
        Score score = new Score(0, 0);
        for (int inputDigitIndex = 0; inputDigitIndex < inputDigitArray.length; inputDigitIndex++) {
            score = renewScoreWithDigits(inputDigitArray, score, inputDigitIndex);
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
                "digits=" + Arrays.toString(digits) +
                '}';
    }
}
