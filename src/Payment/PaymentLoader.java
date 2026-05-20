package Payment;

import FileHandler.*;
import Member.*;

import java.util.ArrayList;


public class PaymentLoader implements Comparable<PaymentLoader>{
    private Member actualMember;
    private int memberId;
    private boolean hasPaid;
    private MemberHandler memberHandler;
    private ArrayList<Member> members;

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
        return actualMember.membersFee();
    }

    @Override
    public int compareTo(PaymentLoader other) {

        //Checker om det man vil sammenligne med er null, hvis det er så kaster vi en nullpointer exception.
        if (other == null){
            throw new NullPointerException("Kan ikke sammenligne med null");
        }

        return Double.compare(other.getMembersFee(), actualMember.membersFee());
    }

    public String toString(){
        loadMember();
        return actualMember.getName() + " Medlem: " + memberId + " Betalt: " + hasPaid + " Beløb: " + actualMember.membersFee();
    }

}
