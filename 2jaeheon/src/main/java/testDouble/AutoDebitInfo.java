package testDouble;

import java.time.LocalDateTime;

public class AutoDebitInfo {
    String userId;
    String cardNumber;
    LocalDateTime time;

    public AutoDebitInfo(String name, String cardNumber, LocalDateTime time) {
        this.userId = name;
        this.cardNumber = cardNumber;
        this.time = time;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getUserId() {
        return userId;
    }


    public void changeCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
