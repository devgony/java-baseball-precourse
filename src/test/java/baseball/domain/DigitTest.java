package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DigitTest {
    @Test
    void shouldReturnTrueIfEqual() {
        Digit digit = new Digit(1);
        assertThat(digit.isEqual(1)).isTrue();
    }
}
