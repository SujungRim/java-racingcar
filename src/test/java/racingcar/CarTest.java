package racingcar;

import org.junit.Test;
import racingcar.domain.Car;
import racingcar.utils.FixedNumberGenerator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CarTest {
    @Test
    public void 숫자4이상_전진() {
        for (int i = 4; i <= 9; i++) {
            Car car = new Car("1번차", 3);
            car.move(new FixedNumberGenerator(i));
            assertThat(car.getPosition(), is(1));
        }
    }

    @Test
    public void 숫자4미만_멈춤() {
        for (int i = 0; i < 4; i++) {
            Car car = new Car("2번차", 3);
            car.move(new FixedNumberGenerator(i));
            assertThat(car.getPosition(), is(0));
        }
    }

    // tdd
    // 0. 한가지의 테스트 케이스에 집중
    // 1. 실패하는 테스트 코드 먼저 작성
    // 2. 성공했으나 실패했으나 리팩토링 먼저!!
    // 3. 반복
    @Test
    public void 정지() {
        Car car = new Car("수정", 3);
        car.move(3);            // 인터페이스를 구현하는 익명클래스로 대신할 수 있음
        assertThat(car.getPosition(), is(0));
    }

    @Test
    public void 이동() {
        Car car = new Car("수정", 3);
        car.move(4);
        assertThat(car.getPosition(), is(1));
    }
}