package baseball.domain;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class DigitsTest {
    @Test
    void matchShouldReturnScore() {
        Digit[] answerDigits = new Digit[]{new Digit(1), new Digit(2), new Digit(3)};
        Digit[] myDigits = new Digit[]{new Digit(1), new Digit(2), new Digit(3)};
        Digits digits = new Digits(answerDigits);
        assertThat(digits.match(myDigits)).isEqualTo(new Score(0, 3));
    }
}
