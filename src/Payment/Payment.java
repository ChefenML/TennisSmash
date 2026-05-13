package Payment;

import Member.Member;

public class Payment {

    private Member member;
    private String name;
    private int memberId;
    private double subscriptionPrice;
    private boolean hasPaid;


    public Payment(Member member, boolean hasPaid){

        this.member = member;
        this.name = member.getName();
        this.memberId = member.getMemberID();
        this.subscriptionPrice = member.membersFee();
        this.hasPaid = hasPaid;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getName() {
        return member.getName();
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberId() {
        return member.getMemberID();
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public double getSubscriptionPrice() {
        return member.membersFee();
    }

    public void setSubscriptionPrice(double subscriptionPrice) {
        this.subscriptionPrice = subscriptionPrice;
    }

    public boolean hasPaid() {
        return hasPaid;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }






}
