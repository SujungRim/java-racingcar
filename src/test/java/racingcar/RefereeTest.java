package racingcar;

import org.junit.Before;
import org.junit.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.Referee;
import racingcar.utils.FixedNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class RefereeTest {
    List<Car> cars;
    RacingGame racingGame;
    Referee referee;

    @Before
    public void setUp() throws Exception {
        cars = new ArrayList<>();
        String[] names = {"firstCar", "secondCar", "thirdCar"};
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i], 3));
        }
    }

    @Test
    public void 단독우승자_테스트() {
        racingGame = new RacingGame(3);
        racingGame.race(cars, new FixedNumberGenerator(5));
        racingGame.race(cars, new FixedNumberGenerator(6));

        Car thirdCar = cars.get(2);
        thirdCar.move(new FixedNumberGenerator(7));    // c만 힌킨 더 전진

        referee = new Referee();
        assertThat(referee.pickNamesOfWinners(cars).get(0), is("thirdCar"));
    }

    @Test
    public void 공동우승자_테스트() {
        Car firstCar = cars.get(0);
        Car secondCar = cars.get(1);
        Car thirdCar = cars.get(2);

        secondCar.move(new FixedNumberGenerator(5));
        thirdCar.move(new FixedNumberGenerator(6));

        referee = new Referee();
        List<String> namesOfWinners = referee.pickNamesOfWinners(cars);
        assertThat(namesOfWinners, hasItems("secondCar", "thirdCar"));
        assertThat(namesOfWinners, not(hasItems("firstCar")));
    }
}
