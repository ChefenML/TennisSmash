package Payment;

import FileHandler.*;
import Member.*;

import java.util.ArrayList;


public class PaymentLoader {
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

    public String toString(){
        loadMember();
        return actualMember.getName() + " Medlem: " + memberId + " Betalt: " + hasPaid + " Beløb: " + actualMember.membersFee();
    }

}
