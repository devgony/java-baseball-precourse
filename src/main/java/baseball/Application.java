package baseball;

import baseball.domain.Digits;
import baseball.domain.Score;
import baseball.view.Input;
import baseball.view.Output;

public class Application {
    public static void main(String[] args) {
        Digits digits = Digits.generate();
        play(digits);
    }

    private static void play(Digits digits) {
        String input = Input.scanDigits();
        Digits inputDigits = Digits.parse(input);
        Score score = digits.match(inputDigits);
        Output.print(score.yield());
        if (score.isDone()) {
            int command = Input.scanCommand();
            if (command == 2) {
                return;
            }
            Digits newDigits = Digits.generate();
            play(newDigits);
            return;
        }
        play(digits);
    }
}
