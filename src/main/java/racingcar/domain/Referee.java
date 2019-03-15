package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Referee {
    private int getMaxPosition(List<Car> cars) {
        Car maxPositionCar = cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow(NoSuchElementException::new);
        return maxPositionCar.getPosition();
    }

    public List<String> pickNamesOfWinners(List<Car> cars) {
        int MaxPosition = getMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == MaxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}