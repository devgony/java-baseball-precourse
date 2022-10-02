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

    @Test
    void yieldNothing() {
        Score score = new Score(0, 0);
        String actual = score.yield();
        assertThat(actual).isEqualTo("Nothing");
    }

    @Test
    void yieldThreeBall() {
        Score score = new Score(3, 0);
        String actual = score.yield();
        assertThat(actual).isEqualTo("3 Ball");
    }

    @Test
    void yieldThreeStrike() {
        Score score = new Score(0, 3);
        String actual = score.yield();
        assertThat(actual).isEqualTo("3 Strike");
    }

    @Test
    void yieldOneBallOneStrike() {
        Score score = new Score(1, 1);
        String actual = score.yield();
        assertThat(actual).isEqualTo("1 Ball 1 Strike");
    }

    @Test
    void isDoneIfThreeStrike() {
        Score score = new Score(0, 3);
        boolean actual = score.isDone();
        assertThat(actual).isTrue();
    }
}
