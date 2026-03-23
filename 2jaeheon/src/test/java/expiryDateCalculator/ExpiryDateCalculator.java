package expiryDateCalculator;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(PayData payData) {
        int addedMonths = payData.getPayAmount() / 10000;
        if (payData.getFirstBillingDate() != null) {
            return expiryDataUsingFirstBillingDate(payData, addedMonths);
        } else {
            return payData.getBillingDate().plusMonths(addedMonths);
        }
    }

    private LocalDate expiryDataUsingFirstBillingDate(PayData payData, int addedMonths) {
        if (payData.getFirstBillingDate() != null) {
            // 후보 만료일
            LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
            // 첫 납부일과 납부일의 일자가 다르면 첫 납부일의 일자를 만료읠의 일자로 사용
            int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
            if (dayOfFirstBilling != candidateExp.getDayOfMonth()) {
                // 후보 만료일이 포함된 달의 마지막 날짜 < 첫 납부일의 일자 -> 후보 만료일을 그달의 마지막 날로 조정해야 한다
                int dayLenOfCandiMon = YearMonth.from(candidateExp).lengthOfMonth();
                if (dayLenOfCandiMon < dayOfFirstBilling) {
                    return candidateExp.withDayOfMonth(dayLenOfCandiMon);
                }

                return candidateExp.withDayOfMonth(dayOfFirstBilling);
            } else {
                return candidateExp;
            }
        } else {
            return payData.getBillingDate().plusMonths(addedMonths);
        }
    }
}
