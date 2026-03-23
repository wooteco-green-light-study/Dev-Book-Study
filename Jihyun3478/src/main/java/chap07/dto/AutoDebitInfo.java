package chap07.dto;

import java.time.LocalDateTime;

public record AutoDebitInfo(
        String userId,
        String cardNumber,
        LocalDateTime time
) {
}
