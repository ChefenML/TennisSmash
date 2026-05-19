package Payment;

import FileHandler.*;
import Member.*;

import java.util.ArrayList;


public class PaymentLoader {
    Member loadMember;
    int memberId;
    boolean hasPaid;
    MemberHandler memberHandler;
    ArrayList<Member> members;

    public PaymentLoader(int memberId, boolean hasPaid){
        members = memberHandler.load();
        this.memberId = memberId;
        this.hasPaid = hasPaid;

    }

}
