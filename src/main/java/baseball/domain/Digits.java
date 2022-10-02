package baseball.domain;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;


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
        List<Integer> numbers = pickUniqueNumbersInRange(0, 9, 3);
        for (int i = 0; i < 3; i++) {
            digits[i] = new Digit(numbers.get(i));
        }
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
