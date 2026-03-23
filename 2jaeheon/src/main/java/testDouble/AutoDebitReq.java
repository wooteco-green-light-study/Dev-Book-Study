package testDouble;

public class AutoDebitReq {
    private String user;
    private String cardNumber;

    public AutoDebitReq(String user, String cardNumber) {
        this.user = user;
        this.cardNumber = cardNumber;
    }

    public String getUserId() {
        return user;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
