package chap2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void plus() {
        //given
        // 지금 당장은 정적 메서드로 충분할 것 같아 정적 메서드로.
        // 지금 당장 필요한 수준까지만 생각
        int result = Calculator.plus(1, 2);
        //when
        //then
        Assertions.assertEquals(3, result);
        Assertions.assertEquals(5, Calculator.plus(4, 1));
    }
}
