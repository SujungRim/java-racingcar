package racingcar.domain;

import racingcar.utils.NumberGenerator;
import racingcar.utils.RandomNumberGenerator;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGame {
    private final int times;

    public RacingGame(final int times) {
        this.times = times;
    }

    public void repeatTimes(List<Car> cars) {
        for (int i = 1; i <= times; i++) {
            race(cars, new RandomNumberGenerator());
            OutputView.printBody(cars);
        }
    }

    public void race(List<Car> cars, NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator);
        }
    }

    public int getTimes() {
        return this.times;
    }
}