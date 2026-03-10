public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
        if (s == null || s.isBlank()) {
            return PasswordStrength.INVALID;
        }

        boolean lengthEnough = s.length() >= 8;
        boolean containsNum = meetsContainingNumberCriteria(s);
        boolean containsUpp = meetsContainingUppercaseCriteria(s);


        // 길이만 충분한 경우
        if (lengthEnough && !containsUpp && !containsNum) {
            return PasswordStrength.WEAK;
        }
        // 숫자만 충분한 경우
        if (!lengthEnough && !containsUpp && containsNum) {
            return PasswordStrength.WEAK;
        }
        // 길이가 충분하지 않은 경우
        if (!lengthEnough) {
            return PasswordStrength.NORMAL;
        }
        // 숫자가 포함되지 않은 경우
        if (!containsNum) {
            return PasswordStrength.NORMAL;
        }
        // 대문자가 포함되지 않은 경우
        if (!containsUpp) {
            return PasswordStrength.NORMAL;
        }

        return PasswordStrength.STRONG;
    }

    private static boolean meetsContainingUppercaseCriteria(String s) {
        boolean containsUpp = false;
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                containsUpp = true;
                break;
            }
        }
        return containsUpp;
    }

    private static boolean meetsContainingNumberCriteria(String s) {
        boolean containsNum = false;
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch < '9') {
                containsNum = true;
                break;
            }
        }
        return containsNum;
    }
}
