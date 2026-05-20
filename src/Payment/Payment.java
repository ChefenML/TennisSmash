package Payment;

import Member.Member;

public class Payment implements Comparable<Payment>{

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

    public  double getSubscriptionPrice() {
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
        //toString metode til at returnerer hvad medlemmet skal betale baseret på deres membertype og haspaid viser om de har betalt. så hvis haspaid er false skylder de det beløb getSubscriptionPrice() returnerer.

    @Override
    public int compareTo(Payment other) {

        //Checker om det man vil sammenligne med er null, hvis det er så kaster vi en nullpointer exception.
        if (other == null){
            throw new NullPointerException("Kan ikke sammenligne med null");
        }

        return Double.compare(this.getSubscriptionPrice(), other.getSubscriptionPrice());
    }

        @Override
        public String toString(){
            return "Navn: " + getName() + " - MedlemsID: " + getMemberId() + " - Kontigent: " + getSubscriptionPrice();
        }

}
