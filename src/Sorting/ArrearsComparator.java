package Sorting;

import Payment.PaymentLoader;

import java.util.Comparator;

public class ArrearsComparator implements Comparator<PaymentLoader> {
    @Override
    public int compare(PaymentLoader p1, PaymentLoader p2) {
        // Tvinger dataen til at loade på begge objekter, så vi er sikre på, de ikke er null
        p1.loadMember();
        p2.loadMember();

        // Eksempel: Sorterer så dem med restance (false) kommer først, og derefter efter beløb
        int paidCompare = Boolean.compare(p1.getPaidStatus(), p2.getPaidStatus());

        if (paidCompare != 0) {
            return paidCompare; // Hvis den ene har betalt og den anden ikke har, sorterer vi på det
        }

        // Hvis begge har samme betalingsstatus, sorterer vi efter beløb (højest til lavest)
        return Double.compare(p2.getMembersFee(), p1.getMembersFee());
    }
}
