package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DigitTest {
    @Test
    void shouldReturnTrueIfEqual() {
        Digit actual = new Digit(1);
        Digit expected = new Digit(1);
        assertThat(actual).isEqualTo(expected);
    }
}
