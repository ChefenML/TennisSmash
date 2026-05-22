package Payment;

import FileHandler.*;
import Member.*;
import Payment.*;

import java.util.ArrayList;


public class PaymentLoader implements Comparable<PaymentLoader>{
    private Member actualMember;
    private int memberId;
    private boolean hasPaid;
    private MemberHandler memberHandler;
    private ArrayList<Member> members;
    private ArrayList<PaymentLoader> payments;

    public PaymentLoader(int memberId, boolean hasPaid){

        this.memberId = memberId;
        this.hasPaid = hasPaid;
        this.memberHandler = new MemberHandler();

    }
    public void loadMember(){
        members = memberHandler.load();
        actualMember = members.get(memberId-1);
    }

    public double getMembersFee() {
        return (actualMember != null) ? actualMember.membersFee() : 0.0;
    }

    public boolean getPaidStatus() {
        return hasPaid;
    }


    @Override
    public int compareTo(PaymentLoader other) {

        //Checker om det man vil sammenligne med er null, hvis det er så kaster vi en nullpointer exception.
        if (other == null){
            throw new NullPointerException("Kan ikke sammenligne med null");
        }

        return Double.compare(other.getMembersFee(), this.getMembersFee());
    }

    public String toString(){
        loadMember();
        return actualMember.getName() + " Medlem: " + memberId + " Betalt: " + hasPaid + " Beløb: " + this.getMembersFee();
    }

}
