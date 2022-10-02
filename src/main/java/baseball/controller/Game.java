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
            if (command == 2) {
                return;
            }
            Game game = new Game();
            game.play();
            return;
        }
        play();
    }
}
