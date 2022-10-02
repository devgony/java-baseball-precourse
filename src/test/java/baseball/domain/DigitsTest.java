package baseball.domain;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class DigitsTest {
    @Test
    void parseStringToDigits() {
        Digits actual = Digits.parse("123");
        Digits expected = new Digits(new Digit[]{new Digit(1), new Digit(2), new Digit(3)});
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void shouldReturnThreeBall() {
        Digit[] answerDigits = new Digit[]{new Digit(1), new Digit(2), new Digit(3)};
        Digits inputDigits = new Digits(new Digit[]{new Digit(3), new Digit(1), new Digit(2)});
        Digits digits = new Digits(answerDigits);
        assertThat(digits.match(inputDigits)).isEqualTo(new Score(3, 0));
    }

    @Test
    void shouldReturnThreeStrike() {
        Digit[] answerDigits = new Digit[]{new Digit(1), new Digit(2), new Digit(3)};
        Digits inputDigits = new Digits(new Digit[]{new Digit(1), new Digit(2), new Digit(3)});
        Digits digits = new Digits(answerDigits);
        assertThat(digits.match(inputDigits)).isEqualTo(new Score(0, 3));
    }

    @Test
    void shouldReturnOneStrikeOneBall() {
        Digit[] answerDigits = new Digit[]{new Digit(1), new Digit(2), new Digit(3)};
        Digits inputDigits = new Digits(new Digit[]{new Digit(4), new Digit(1), new Digit(3)});
        Digits digits = new Digits(answerDigits);
        assertThat(digits.match(inputDigits)).isEqualTo(new Score(1, 1));
    }
}
