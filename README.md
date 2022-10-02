# 숫자 야구 게임

## 진행 방법

* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정

* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## Todo

- [x] feat: architecture design - view(input, output), domain(), controller(Application)
- [x] test: Digit.isEqual should return true if it is equal to my digit
- [x] feat: add class Digit {value: int}, fn isEqual(int input) -> bool
- [x] test: add cases for Score.{addStrike, addBall}
- [x] feat: implement Score.{addStrike, addBall} to return renewed Score
- [x] test: Digits.match should return Score
- [ ] feat: implement Digits.match
- [ ] feat: first class collection Digits {values: List<Digit>}, fn match(myDigits: List<Digit>) -> Score
- [ ] feat: fn generate_digits() -> List<Digit>: random digits generator
- [ ] feat: get player input 3 times
- [ ] feat: input 3 times => ask quit or replay
- [ ] feat: IllegalArgumentException for wrong input