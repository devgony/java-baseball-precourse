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
        String input = Input.scan();
        Digits inputDigits = Digits.parse(input);
        Score score = digits.match(inputDigits);
        Output.print(score.yield());
        if (score.isDone()) {
            Output.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }
        play(digits);
    }
}
