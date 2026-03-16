package chap05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SumTest {
    @Test
    void sum() {
        int result = 2 + 3;
        assertEquals(5, result);
    }
}
