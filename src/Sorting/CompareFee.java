package Sorting;

import Member.Member;
import Payment.PaymentLoader;

import java.util.Comparator;

public class CompareFee implements Comparator<PaymentLoader> {
    @Override
    public int compare(PaymentLoader o1, PaymentLoader o2) {
        return Double.compare(o2.getMembersFee(), o1.getMembersFee());
    }
}
