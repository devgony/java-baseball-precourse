package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {
    @Test
    void addStrike() {
        Score score = new Score(0, 0);
        Score actual = score.addStrike();
        Score expected = new Score(0, 1);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void addBall() {
        Score score = new Score(0, 0);
        Score actual = score.addBall();
        Score expected = new Score(1, 0);
        assertThat(actual).isEqualTo(expected);
    }
}
