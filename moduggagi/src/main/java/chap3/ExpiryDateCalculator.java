package chap3;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(PayData payData) {

        int addedMonths = calculateAddedMonths(payData);

        if (payData.getFirstBillingDate() != null) {
            return expiryDateUsingFirstBillingDate(payData, addedMonths);
        } else {
            return payData.getBillingDate().plusMonths(addedMonths);
        }
    }

    private int calculateAddedMonths(PayData payData) {
        int payAmount = payData.getPayAmount();
        int addedMonths = 0;
        if (payAmount >= 100_000) {
            int yearlyPay = payAmount / 100_000;
            addedMonths += (12 * yearlyPay);
            payAmount %= 100_000;
        }

        addedMonths += payAmount / 10_000;
        return addedMonths;
    }

//    private LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addedMonths) {
//        LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
//        final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
//        if (dayOfFirstBilling != candidateExp.getDayOfMonth()) {
//            final int dayLenOfCandiMon = YearMonth.from(candidateExp).lengthOfMonth();
//            if (dayLenOfCandiMon < dayOfFirstBilling) {
//                return candidateExp.withDayOfMonth(dayLenOfCandiMon);
//            }
//            return candidateExp.withDayOfMonth(dayOfFirstBilling);
//        } else {
//            return candidateExp;
//        }
//    }

    private LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addedMonths) {
        LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);

        if (isSameDayOfMonth(payData.getFirstBillingDate(), candidateExp)) {
            final int dayLenOfCandiMon = lastDayOfMonth(candidateExp);
            final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
            if (dayLenOfCandiMon < dayOfFirstBilling) {
                return candidateExp.withDayOfMonth(dayLenOfCandiMon);
            }
            return candidateExp.withDayOfMonth(dayOfFirstBilling);
        } else {
            return candidateExp;
        }
    }

    private int lastDayOfMonth(LocalDate date) {
        return YearMonth.from(date).lengthOfMonth();
    }

    private boolean isSameDayOfMonth(LocalDate date1, LocalDate date2) {
        return date1.getDayOfMonth() != date2.getDayOfMonth();
    }
}
