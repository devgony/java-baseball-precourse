package baseball.controller;

import baseball.domain.Digits;
import baseball.domain.Score;
import baseball.view.Input;
import baseball.view.Output;

public class Game {
    private final Digits digits;

    public Game() {
        this.digits = Digits.generate();
    }

    public void play() {
        String input = Input.scanDigits();
        Digits inputDigits = Digits.parse(input);
        Score score = digits.match(inputDigits);
        Output.print(score.yield());
        if (score.isDone()) {
            int command = Input.scanCommand();
            replay(doesReplay(command));
            return;
        }
        play();
    }

    private boolean doesReplay(int command) {
        return command == 1;
    }

    private void replay(boolean doesReplay) {
        if (doesReplay) {
            Game game = new Game();
            game.play();
        }
    }
}
