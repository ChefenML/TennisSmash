package Payment;

import FileHandler.Filehandler;
import Member.Member;

import java.util.ArrayList;


public class PaymentLoader {
    Member loadMember;
    int memberId;
    boolean hasPaid;
    Filehandler memberload;
    ArrayList<Member> members = memberload.load();

    public PaymentLoader(int memberId, boolean hasPaid){
        this.memberId = memberId;
        this.hasPaid = hasPaid;
    }

    public Member getMembernameFromId(int id){
        return loadMember = members.get(id-1);
    }
}
