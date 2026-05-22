package Sorting;

import Payment.PaymentLoader;
import java.util.Comparator;

public class ComparePaymentName implements Comparator<PaymentLoader> {

    @Override
    public int compare(PaymentLoader p1, PaymentLoader p2) {
        p1.loadMember();
        p2.loadMember();

        return p1.getPaymentName().compareToIgnoreCase(p2.getPaymentName());
    }
}