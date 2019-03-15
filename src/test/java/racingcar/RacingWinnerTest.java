package racingcar;

import org.junit.Test;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RacingWinnerTest {
    @Test
    public void 한명의_우승자() {
        Car sujung = new Car("수정", 3);
        // 핵심 로직과 뷰에 데이터를 전달하는 디티오의 역할까지 하기 때문에 가능
        // 외부에서 핵심 로직을 오용할 수 있으므로 최종 결과 상태값만 담아 전달
        // 인스턴스변수의 중복이라는 단점이 생김: 핵심로직을 담당하는 move의 접근제어자를 default로
        // 클래스 메소드에 대한 오해. 그러나 적재적소에 사용하면 테스트하는데 수월하다!
        List<Car> racers = Arrays.asList(new Car("수진", 2), new Car("수현", 1));

        Car winner = RacingWinner.findWinner(racers);
        // 상태를 가지면 테스트가 어려움, 다른 인스턴스 변수와 의존관계를 가지지 않는 것이 좋으니 최대한 클래스메소드로
        // get메소드를 사용하는 것보다 객체에 메세지를 보내는 방식이 좋음.
        assertThat(winner, is(sujung));
    }
}
