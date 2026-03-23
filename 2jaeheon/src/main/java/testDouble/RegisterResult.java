package testDouble;

import java.util.Objects;

public class RegisterResult {
    private final boolean success;
    private final CardValidity validity;

    private RegisterResult(boolean success, CardValidity validity) {
        this.success = success;
        this.validity = validity;
    }

    public static RegisterResult error(CardValidity validity) {
        return new RegisterResult(false, validity);
    }

    public static RegisterResult success() {
        return new RegisterResult(true, null);
    }

    public boolean isSuccess() {
        return success;
    }

    public CardValidity getValidity() {
        return validity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RegisterResult)) {
            return false;
        }
        RegisterResult that = (RegisterResult) o;
        return success == that.success && validity == that.validity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(success, validity);
    }
}
