package racingcar.app;

import racingcar.dao.CarDao;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.Referee;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class ConsoleApp {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.input();

        CarDao carDao = new CarDao();
        carDao.save(inputView.getNames());
        RacingGame racingGame = new RacingGame(inputView.getTimes());

        OutputView.printIntroduction();
        List<Car> racer = carDao.findAll();
        racingGame.repeatTimes(racer);

        Referee referee = new Referee();
        List<String> namesOfWinners = referee.pickNamesOfWinners(racer);
        OutputView.printResult(namesOfWinners);
    }
}
