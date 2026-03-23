package chap07.dto;

public record AutoDebitReq(
        String userId,
        String cardNumber
) {
}
