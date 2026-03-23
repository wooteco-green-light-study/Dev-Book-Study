package chap03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PasswordStrengthMeterTest {
    @Test
    void meetsOnlyUpperCriteria_Then_Weak() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.meter("abcDef");
        assertEquals(PasswordStrength.WEAK, result);
    }

    @Test
    void meetsAllCriteria_Then_Weak() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result1 = meter.meter("abcDef12");
        assertEquals(PasswordStrength.STRONG, result1);
        PasswordStrength result2 = meter.meter("aZcDef12");
        assertEquals(PasswordStrength.STRONG, result2);
    }

    @Test
    void meetsAllCriteria_Then_Strong() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result1 = meter.meter("ab12!@AB");
        assertEquals(PasswordStrength.STRONG, result1);
        PasswordStrength result2 = meter.meter("abc1!Add");
        assertEquals(PasswordStrength.STRONG, result2);
    }

    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result1 = meter.meter("ab12!@A");
        assertEquals(PasswordStrength.NORMAL, result1);
        PasswordStrength result2 = meter.meter("Ab12!c");
        assertEquals(PasswordStrength.NORMAL, result2);
    }
}
